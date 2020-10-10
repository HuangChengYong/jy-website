package ChatRoom;

import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

/**
 * 上线通知
 * @author huang
 *
 */
public class OnlineNotify implements Runnable{

    private String onlineUserName;

    public OnlineNotify(String onlineUserName){
        this.onlineUserName = onlineUserName;
    }
    @Override
    public void run() {
        try {
            Set<Map.Entry<String, Socket>> set = SocketMap.map.entrySet();
            for (Map.Entry<String,Socket> entry : set) {
                Socket s = (Socket) entry.getValue();
                BufferedOutputStream out =new BufferedOutputStream(s.getOutputStream());
                String notifyInfo = "1000|欢迎 "+onlineUserName+" 登入聊天室";
                Tools.sendData(out, notifyInfo);
            }
        } catch (Exception e) {

        }
    }

}

