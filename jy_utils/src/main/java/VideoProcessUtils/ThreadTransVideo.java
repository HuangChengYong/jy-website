package VideoProcessUtils;


import PropertyUtils.PropertyUtil;
import com.jyinfo.jy_utils.File.DeleteFileUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ThreadTransVideo extends Thread {

    private static final Log logger = LogFactory.getLog(ThreadTransVideo.class);
    //ffmpeg的安装位置
    private static String FF_MPEG_PATH = PropertyUtil.getProperty("FF_MPEG_PATH");
    //mencoder的目录
    private static String MEN_CODER_PATH = PropertyUtil.getProperty("MEN_CODER_PATH");
    //视频转码后添加后缀
    public static String TRANSCODING_SUFFIX = "_DISPOSE";//源视频路径
    //原视频文件存放路径
    public String SOURCE_VIDEO_PATH = null;//源视频路径
    //目标视频文件全路径
    public String TARGET_VIDEO_FILE = null;
    //目标视频文件截图全路径
    private String TARGET_SCREENSHOT_FILE = null;
    //视频宽高
    public int width=0;
    public int height=0;
    //哼哈圈视频的默认宽
    public static final Integer HUM_HA_CIRCLE_VIDEO_WIDTH = 340;

    public ThreadTransVideo(String sourceVideoPath) {
        SOURCE_VIDEO_PATH = sourceVideoPath;
        //在原路径下生成MP4
        TARGET_VIDEO_FILE = sourceVideoPath.substring(0,sourceVideoPath.lastIndexOf("."))+TRANSCODING_SUFFIX + ".mp4";
        //在原路径下生成jpg
        TARGET_SCREENSHOT_FILE = sourceVideoPath.substring(0,sourceVideoPath.lastIndexOf("."))+TRANSCODING_SUFFIX + ".jpg";
    }

    public void run() {
        try {
            beginConver(true);//参数提示功能
        }catch (Exception ex){
            ex.printStackTrace();
            logger.debug("---------------转码发生异常!!!");
        }
    }

    public String getScreenshot(String scene){
        String imgUrl=processImg(SOURCE_VIDEO_PATH);
        try {
            if (!new File(imgUrl).isFile()) {
                Thread.sleep(1000);
            }
            File file = new File(imgUrl);
            FileInputStream fis = new FileInputStream(file);
            BufferedImage bufferedImg = ImageIO.read(fis);
            width = bufferedImg.getWidth();
            height = bufferedImg.getHeight();
            //1.7:1压缩+裁剪
            if("humHaCircleVideo".equals(scene)) {
                ThumbnailsUtil.clip(file, file, HUM_HA_CIRCLE_VIDEO_WIDTH, new Double(HUM_HA_CIRCLE_VIDEO_WIDTH/0.8).intValue(), width > height ? HUM_HA_CIRCLE_VIDEO_WIDTH/2 : 0, 0, true, 1f);
                //ThumbnailsUtil.scale(file,File target,int width,int height,boolean forceAble,float quality)
            } else {
                ThumbnailsUtil.clip(file, file, width, new Double(width / 1.7).intValue(), 0, height > width ? height / 5 : 0, true, 1f);
            }
        } catch (Exception i){
            i.printStackTrace();
        }
        return imgUrl;
    }

    /**
     * 转换视频格式并补边
     * @param isDelSourseFile 转换完成后是否删除源文件
     * @return
     */
    public boolean beginConver(boolean isDelSourseFile) throws InterruptedException {
        //默认转换后目标视频
        String targetExtension = ".mp4";
        if (!checkfile(SOURCE_VIDEO_PATH)) {
            logger.debug(SOURCE_VIDEO_PATH + "文件不存在" + " ");
            return false;
        }
        if (SOURCE_VIDEO_PATH.lastIndexOf(".mp4") < 0) {//判断文件是否为MP4，为MP4则不转码
            logger.debug("开始转文件(" + SOURCE_VIDEO_PATH + ")-------------------------- ");
            if (process(targetExtension, isDelSourseFile)) {//转码成功
                logger.debug("转换成功!!! ");
                if (isDelSourseFile) {//删除原视频
                    DeleteFileUtil.delete(SOURCE_VIDEO_PATH);
                }
                return true;
            } else {
                return false;
            }
        }else {//文件为MP4不转码，只要截图
            File oldFile = new File(SOURCE_VIDEO_PATH);
            File newFile = new File(TARGET_VIDEO_FILE);
            if(oldFile.exists()&&!newFile.exists())
            {
                oldFile.renameTo(newFile);
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     * 对视频进行截图
     *
     * @param sourceVideoPath 需要被截图的视频路径（包含文件名和扩展名）
     * @return
     */
    public String processImg(String sourceVideoPath) {
        if (!checkfile(sourceVideoPath)) {
            logger.debug(sourceVideoPath + " is not file");
            return null;
        }
        List<String> commend = new ArrayList<String>();
        commend.add(FF_MPEG_PATH);
        commend.add("-ss");
        commend.add("0.001");
        commend.add("-i");
        commend.add(sourceVideoPath);
        commend.add("-f");
        commend.add("image2");
        commend.add("-y");
        commend.add(TARGET_SCREENSHOT_FILE); // 添加截取的图片的保存路径
        ProcessBuilder builder = new ProcessBuilder();
        try {
            builder.command(commend);
            builder.redirectErrorStream(true);
            builder.start();
            return TARGET_SCREENSHOT_FILE;
        } catch (Exception e) {
            e.printStackTrace();
            return TARGET_SCREENSHOT_FILE;
        }
    }

    /**
     * 实际转换视频格式的方法
     *
     * @param targetExtension 目标视频扩展名
     * @param isDelSourseFile 转换完成后是否删除源文件
     * @return
     */
    private boolean process(String targetExtension, boolean isDelSourseFile) {
        int type = checkContentType();
        boolean status = false;
        if (type == 0) {
            //如果type为0用ffmpeg直接转换
            status = processVideoFormat(SOURCE_VIDEO_PATH, targetExtension, isDelSourseFile);
        } else if (type == 1) {
            //如果type为1，将其他文件先转换为avi，然后在用ffmpeg转换为指定格式
            String avifilepath = processAVI(type);
            if (avifilepath == null) {
                // avi文件没有得到
                return false;
            } else {
                logger.debug("=============================开始转换=================================");
                status = processVideoFormat(avifilepath, targetExtension, isDelSourseFile);
            }
        }
        return status;
    }

    /**
     * 检查文件类型
     *
     * @return
     */
    private int checkContentType() {
        String type = SOURCE_VIDEO_PATH.substring(SOURCE_VIDEO_PATH.lastIndexOf(".") + 1, SOURCE_VIDEO_PATH.length()).toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }

    /**
     * 检查文件是否存在
     *
     * @param path
     * @return
     */
    public static boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
     *
     * @param type
     * @return
     */
    private String processAVI(int type) {
        String avi_path = SOURCE_VIDEO_PATH.substring(0,SOURCE_VIDEO_PATH.lastIndexOf(".")) + ".avi";

        List<String> commend = new ArrayList<String>();
        commend.add(MEN_CODER_PATH);
        commend.add(SOURCE_VIDEO_PATH);
        commend.add("-oac");
        commend.add("mp3lame");
        commend.add("-lameopts");
        commend.add("preset=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=600");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add(avi_path);
        // 命令类型：mencoder 1.rmvb -oac mp3lame -lameopts preset=64 -ovc xvid
        // -xvidencopts bitrate=600 -of avi -o rmvb.avi
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process p = builder.start();
            doWaitFor(p);
            return avi_path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 转换为指定格式
     * ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
     *
     * @param oldfilepath
     * @param targetExtension 目标格式扩展名 .xxx
     * @param //              isDelSourseFile 转换完成后是否删除源文件
     * @return
     */
    private boolean processVideoFormat(String oldfilepath, String targetExtension, boolean isDelSourceFile) {
        if (!checkfile(SOURCE_VIDEO_PATH)) {
            return false;
        }
        //String target_path = SOURCE_VIDEO_PATH.substring(0,SOURCE_VIDEO_PATH.lastIndexOf("."));
        List<String> commend = new ArrayList<>();
        //ffmpeg -i C:/Users/Administrator/Desktop/vb.mp4 -vcodec libx264 -b:v 500k -s 960x540 -strict -2 C:/Users/Administrator/Desktop/1MlVAykdi.mp4
        //-vf scale=1280:534,pad=1280:720:0:93:black
        commend.add(FF_MPEG_PATH);
        commend.add("-i");
        commend.add(SOURCE_VIDEO_PATH);
        commend.add("-vcodec");
        commend.add("libx264");
        commend.add("-b:v");
        commend.add("500k");
        //ffmpeg -i v.mp4 -vcodec libx264 -b:v 500k -vf scale=1280:534,pad=1280:720:0:93:black -strict -2 Wildlife.mp4
        if(width>0 && height>720) {
            //commend.add("-s");
            //commend.add(width+"x"+height);
            commend.add("-vf");
            int heig = height > 720 ? 720 : height;
            int wid = width > 360 ? 360 : width;
            commend.add("scale=" + wid + ":" + heig + ",pad=1280:720:" + (1280 - wid) / 2 + ":" + (720 - heig) / 2 + ":black");
        }
        commend.add("-strict");
        commend.add("-2");
        commend.add(TARGET_VIDEO_FILE);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process p = builder.start();
            doWaitFor(p);
            p.destroy();
            //转换完成后删除源文件
            if (isDelSourceFile) {
                DeleteFileUtil.delete(SOURCE_VIDEO_PATH);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
     *
     * @param oldfilepath
     * @return
     */
    private boolean processFLV(String oldfilepath) {
        if (!checkfile(SOURCE_VIDEO_PATH)) {
            System.out.println(oldfilepath + " is not file");
            return false;
        }
        String flv_path = SOURCE_VIDEO_PATH.substring(0,SOURCE_VIDEO_PATH.lastIndexOf(".")) + ".flv";
        List<String> commend = new ArrayList<>();
        commend.add(FF_MPEG_PATH);
        commend.add("-i");
        commend.add(oldfilepath);
        commend.add("-ab");
        commend.add("64");
        commend.add("-acodec");
        commend.add("mp3");
        commend.add("-ac");
        commend.add("2");
        commend.add("-ar");
        commend.add("22050");
        commend.add("-b");
        commend.add("230");
        commend.add("-r");
        commend.add("24");
        commend.add("-y");
        commend.add(flv_path);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process p = builder.start();
            doWaitFor(p);
            p.destroy();
            DeleteFileUtil.delete(oldfilepath);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int doWaitFor(Process p) {
        InputStream in = null;
        InputStream err = null;
        int exitValue = -1; // returned to caller when p is finished
        try {
            in = p.getInputStream();
            err = p.getErrorStream();
            boolean finished = false; // Set to true when p is finished

            while (!finished) {
                try {
                    while (in.available() > 0) {
                        Character c = new Character((char) in.read());
                        System.out.print(c);
                    }
                    while (err.available() > 0) {
                        Character c = new Character((char) err.read());
                        System.out.print(c);
                    }

                    exitValue = p.exitValue();
                    finished = true;

                } catch (IllegalThreadStateException e) {
                    Thread.currentThread().sleep(500);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("doWaitFor();: unexpected exception - " + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if (err != null) {
                try {
                    err.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return exitValue;
    }
}