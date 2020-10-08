import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP1 {
    public static void main(String[] args) throws IOException {

        //UDP：不用连接服务器
        //创建Socket ->创建包 ->发送包 ->关闭Socket
        //---------------------------
        //创建Socket
        DatagramSocket socket = new DatagramSocket();

        //创建包：写消息、消息发送的开始位和长度、ip、port
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8878;
        String str = "无所谓，也有点累";
        DatagramPacket packet = new DatagramPacket(str.getBytes(),0,str.getBytes().length,address,port);

        //发送包
        socket.send(packet);
        //关闭Socket
        socket.close();

    }
}
