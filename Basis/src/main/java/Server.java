import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        Socket socket = null;

        try {
            //创建服务器port
            serverSocket = new ServerSocket(7788);
            while (true) {
                //等待客户端连接：返回客户端的socket
                socket = serverSocket.accept();
                //读取消息。。。
                inputStream = socket.getInputStream();




            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源

        }
    }
}
