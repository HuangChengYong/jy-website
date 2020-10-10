package ChatRoom;

import java.io.IOException;
import java.net.Socket;

public interface ServerHandler {


    /**
     * 建立连接时调用
     * @param s
     */
    public void connectService(Socket s)  throws IOException;

    /**
     * 接收到数据是调用
     * @param s
     * @throws IOException
     */
    public void receiveData(Socket s);

    /**
     * 关闭连接时调用
     * @param s
     * @throws IOException
     */
    public void closeConnect(Socket s);
}
