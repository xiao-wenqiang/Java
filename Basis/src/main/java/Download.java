import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download {
    public static void main(String[] args) throws IOException {

        //URL:协议、IP、port、文件、文件全路径、参数
        URL url = new URL("https://");

        //连接到资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        //下载：
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("f5Xvfv");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer,0,len);
        }

        //关闭资源
        fileOutputStream.close();
        inputStream.close();
        urlConnection.disconnect();
    }
}
