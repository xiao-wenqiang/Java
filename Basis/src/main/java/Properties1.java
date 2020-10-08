import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Properties1 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("p.properties");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        properties.load(inputStreamReader);

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name+":"+password);

        //关闭资源
        inputStreamReader.close();
    }
}
