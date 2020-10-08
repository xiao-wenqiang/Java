import javax.servlet.ServletOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@javax.servlet.annotation.WebServlet(name = "DownloadServlet")
public class DownloadServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取要下载文件的路径
        String realPath = "C:\\Users\\23734\\Desktop\\Study\\test\\src\\main\\resources\\1.jpg";
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,URLEncoder.encode("UTF-8")));
        FileInputStream inputStream = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream outputStream = response.getOutputStream();
        while ((len= inputStream.read(buffer))>0){
            outputStream.write(buffer,0,len);
        }
        inputStream.close();
        outputStream.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}

/*
可以用response实现用户下载，还可以用来做图片验证



 */