package ChatRoom;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class Tools {

    protected static byte[] getMsgLength(int length){
        System.out.println("返回数据");
        byte[] bt = new byte[4];
        bt[0] = (byte) (length/1000);
        bt[1] = (byte) (length%1000/100);
        bt[2] = (byte) (length%100/10);
        bt[3] = (byte) (length%10);

        return bt;
    }

    public static void sendData(BufferedOutputStream out, String message) throws Exception{
        System.out.println("message:"+message);
        byte[] head = Tools.getMsgLength(message.getBytes("UTF-8").length);
        out.write(head);
        out.flush();
        out.write(message.getBytes("UTF-8"));
        out.flush();
    }

    public static String  receiveData(BufferedInputStream in) throws Exception{
        int length = readMsgHead(in);
        System.out.println("接收到的数据长度:"+length);
        byte[] bt = new byte[length];
        in.read(bt);
        String data = new String(bt,"UTF-8");
        return data;
    }



    protected  static int readMsgHead(BufferedInputStream in) throws IOException {
        int length = 0;
        byte[] bt = new byte[4];
        in.read(bt, 0, 4);
        length = bt[0]*1000+bt[1]*100+bt[2]*10+bt[3];
        return length;
    }
}
