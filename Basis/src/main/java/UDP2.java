import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP2 {
    public static void main(String[] args) throws IOException {

        //创建Socket，开放端口
        DatagramSocket socket = new DatagramSocket(8878);

        //创建包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        //接收包
        socket.receive(packet);

        //获取数据
        byte[] data = packet.getData();
        String str = new String(data,0, data.length);
        System.out.println(str);

        //关闭Socket
        socket.close();
    }
}
