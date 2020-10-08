import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try {
            //设置服务器ip、port
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 7788;
            //创建Socket链接
            Socket socket = new Socket(address,port);
            //发送消息
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我太难了".getBytes());






        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源


        }
    }
}
