package ChatRoom;

import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class ServerBiz {

    public void login(Socket s, String userName)  throws Exception{
        System.out.println("处理用户登入请求....");
        BufferedOutputStream out =new BufferedOutputStream(s.getOutputStream());

        Set<Map.Entry<String,Socket>> set = SocketMap.map.entrySet();
        String responseMsg = "0000";
        for (Map.Entry<String,Socket> en : set) {
            responseMsg = responseMsg +"|"+en.getKey();
        }
        System.out.println(responseMsg);
        Tools.sendData(out, responseMsg);

        //对在线的所有用户进行广播，提示有人上线
        new Thread(new OnlineNotify(userName)).start();
    }

    public void dataTranspond(Socket s) throws Exception{


    }
    /**
     * 群发
     * @param user
     * @throws Exception
     */
    public void pocketTransmission(String user,String msg) throws Exception{

        Set<Map.Entry<String,Socket>> set = SocketMap.map.entrySet();
        for (Map.Entry<String,Socket> entry : set) {
            Socket s = (Socket) entry.getValue();
            BufferedOutputStream out =new BufferedOutputStream(s.getOutputStream());
            Tools.sendData(out, "1001|【"+user+"】对大家说:"+msg);
        }
    }

    /**
     * 用户下线通知
     * @param user
     * @throws Exception
     */
    public void userOffLine(String user) throws Exception {
        Set<Map.Entry<String,Socket>> set = SocketMap.map.entrySet();
        for (Map.Entry<String,Socket> entry : set) {
            Socket s = (Socket) entry.getValue();
            BufferedOutputStream out =new BufferedOutputStream(s.getOutputStream());
            Tools.sendData(out, "1010|"+user);
            s.close();
        }

    }

    /**
     * 消息转发
     * @param fromUser 发送者
     * @param toUser 接收者
     * @param msg 消息
     * @throws Exception
     */
    public void transpondMessage(String fromUser, String toUser, String msg) throws Exception {

        Socket s = SocketMap.map.get(toUser);//获取接收者的socket
        BufferedOutputStream out =new BufferedOutputStream(s.getOutputStream());
        String message = "1002|【"+fromUser+"】对你说:"+msg;
        Tools.sendData(out, message);

    }
}
