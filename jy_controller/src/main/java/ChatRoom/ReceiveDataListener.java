package ChatRoom;

import java.net.Socket;

/**
 * 接受消息的线程
 * @author huang
 *
 */
public class ReceiveDataListener implements Runnable{

    private ServerHandler serverHandler;

    private Socket s;

    public ReceiveDataListener(ServerHandler serverHandler, Socket s) {
        this.serverHandler = serverHandler;
        this.s = s;
    }

    public void run() {
        while (true) {
            serverHandler.receiveData(s);
        }
    }



}
