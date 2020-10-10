package ChatRoom;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class MyServer {
    private int port;
    private ServerHandler serverHandler;

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public ServerHandler getServerHandler() {
        return serverHandler;
    }
    public void setServerHandler(ServerHandler serverHandler) {
        this.serverHandler = serverHandler;
    }

    public MyServer(int port,ServerHandler serverHandler) throws IOException {
        System.out.println("初始化服务.....");
        this.setPort(port);
        this.setServerHandler(serverHandler);
        ServerSocket ss = new ServerSocket(port);
        System.out.println("创建服务成功.....");
        System.out.println("正在监听"+port+"端口.....");
        while (true) {
            Socket s = ss.accept();
            serverHandler.connectService(s);
            Thread receiveListenerThread =  new Thread(new ReceiveDataListener(serverHandler, s));
            receiveListenerThread.setName(s.getInetAddress().getHostAddress());
            receiveListenerThread.start();
        }
    }



}
