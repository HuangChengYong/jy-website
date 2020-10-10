package VideoProcessUtils;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author：ZengPeng
 * @Dcscription：Thumbnails图片处理
 * @Date：Created in 0:52 2019/5/15
 * @Modificd By:
 */
public class ThumbnailsUtil {
    /**
     * 功能：图片剪裁
     * 按规定的宽度和高度进行剪裁,可用来头像剪裁
     * @param source 原图像
     * @param target 目标图像
     * @param width 剪裁后的宽度
     * @param height 剪裁后的高度
     * @param posX 位置x
     * @param posY 位置y
     * @param scaleAble 是否先缩放后剪裁
     * @param quality 剪裁后的图片质量
     */
    public static void clip(File source, File target, int width, int height, int posX, int posY, boolean scaleAble, float quality){
        int size[] = getSize(source);
        int w = size[0];
        int h = size[1];
        double wScale = width*1.0/w;
        double hScale = height*1.0/h;
        double maxScale = Math.max(wScale, hScale);
        //scale为1.0表示原图剪裁，否则就缩放(扩大)
        double scale = scaleAble ? maxScale : 1.0;
        try {
            //先按比例缩放存到内存
            BufferedImage image = Thumbnails.of(source).scale(scale).asBufferedImage();
            //后从中心剪裁
            Thumbnails.of(image).size(width,height).sourceRegion(posX,posY, width, height).outputQuality(quality).toFile(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能：图片缩放
     * @param source 原图像
     * @param target 目标图像
     * @param width 缩放后的图片宽度
     * @param height 缩放后的图片高度
     * @param forceAble 当图片大小小于规定的尺寸，是否强制将图片放大失真
     * @param quality
     */
    public static void scale(File source,File target,int width,int height,boolean forceAble,float quality){
        //按比例缩放
        int size[] = getSize(source);
        int w = size[0];
        int h = size[1];
        double wScale = width*1.0/w;
        double hScale = height*1.0/h;
        double scale = 1.0;
        /*
         *  width      height
         * -----   =  --------
         *   w              h
         */
        scale = Math.max(wScale, hScale);
        try{
            //如果按照大于1的比例进行缩放（其实是放大），这里会根据参数决定forceAble决定
            if(scale<=1 || scale > 1 && forceAble){
                //缩放原图
                Thumbnails.of(source).width(width).outputQuality(quality).toFile(target);
            }
            else{
                //复制原图
                Thumbnails.of(source).scale(1).outputQuality(quality).toFile(target);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 获取图片的宽度和高度尺寸
     * @param img
     * @return
     */
    public static int[] getSize(File img){
        BufferedImage image = null;
        try {
            image = ImageIO.read(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width =  image.getWidth();
        int height = image.getHeight();
        int[] size = {width,height};
        return size;
    }
}
