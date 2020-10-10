package ChatRoom;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerHandlerImpl  implements ServerHandler{
    private ServerBiz sb = new ServerBiz();

    public void connectService(Socket s) throws IOException {

        System.out.println(s.getInetAddress().getHostAddress()+" 连接了服务...");
    }

    public void receiveData(Socket s) {

        try {
            BufferedInputStream in = new BufferedInputStream(s.getInputStream());
            String data = Tools.receiveData(in);
            System.out.println("接收到的数据:"+data);
            String[] datas = data.split("\\|");
            switch (Integer.parseInt(datas[0])) {
                case 1000 :
                    System.out.println("客户端发送了登入请求.....");
                    SocketMap.map.put(datas[1], s);
                    sb.login(s,datas[1]);
                    break;
                case 1001:
                    sb.pocketTransmission(datas[1],datas[2]);
                    break;
                case 1002:
                    sb.transpondMessage(datas[1],datas[2],datas[3]);
                    break;
                case 1010:
                    SocketMap.map.remove(datas[1]);
                    sb.userOffLine(datas[1]);
                    s.close();
                default:
                    break;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void closeConnect(Socket s) {
        System.out.println(s.getInetAddress().getHostAddress()+"  的客户端断开了连接");
    }

    /**
     * 检查数据的合法性
     * @param data
     * @return
     */
    protected static boolean checkData(String data){
        if(data.indexOf("|") < 0){
            return false;
        }
        String[] datas = data.split("|");
        if(!datas[0].equals("1000") && !datas[0].equals("1001") && !datas[0].equals("1002")){
            return false;
        }
        return true;
    }
}
