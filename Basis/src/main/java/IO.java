import java.io.*;

public class IO {
    public static void main(String[] args) throws IOException {
        /*
        0101
        -> ASCII（7位/美国的）
        -> ANSI（平台默认编码）：英文系统ISO8859-1：中文系统GBK
        -> Unicode（统称/通用）：UTF-8、UTF-16、UTF-32

        编码：String->byte[]解码：byte[]->String
        写数据是编码过程，读数据是解码过程，编码和解码用字符集要一致！可以用参指定字符集！
        所以存数据是按字符集存，取数据也是按字符集取。然后按字节读还是按字符读，看是否文本文件。

        Windows/DOS用的分隔符：\
        UNIX/URL用的分隔符：/
         */

        //创建节点对象->创建节点流->读/写->关闭资源
        //要用System.in：要先用InputStreamReader和BufferedReader处理
            //或者用Scanner：Scanner s = new Scanner(System.in); s.next();
//处理文本文件：Reader->FileReader->BufferedReader
        //-------------------------------------
        //节点：文本文件对象
        File file1 = new File("t1.txt");
        File file2 = new File("t2.txt");
        //节点流:字符流
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2,true);
        //处理流：缓冲流
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //读/写：
//按字符读：
//        int data = fileReader.read();
//        while (data != -1) {
//            System.out.print((char)data);
//            data = fileReader.read();
//        }
//按字符数组读：
//        char[] chars = new char[1024];
//        int len2;
//        while ((len2=bufferedReader.read(chars)) != -1) {
//            bufferedWriter.write(chars,0,len2);
//        }
//按行读：
        String data;
        while ((data = bufferedReader.readLine()) != null){
            bufferedWriter.write(data+"\n");
        }





//处理非文本文件，InputStream->FileInputStream->BufferedInputStream
        //------------------------------------------
        //节点：非文本文件对象
        File file3 = new File("p1.jpg");
        File file4 = new File("p2.jpg");
        //节点流：文件流
        FileInputStream fileInputStream = new FileInputStream(file3);
        FileOutputStream fileOutputStream = new FileOutputStream(file4);
        //处理流：缓冲流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        //读/写：
        byte[] buffer = new byte[10];
        int len;
        while ((len=bufferedInputStream.read(buffer)) != -1){
            bufferedOutputStream.write(buffer,0,len);
        }


//处理存数据的文件：用DataOutputStream、DataInputStream
        //-----------------------------------------
        File file5 = new File("d1.txt");
        File file6 = new File("d1.txt");
        FileInputStream fileInputStream2 = new FileInputStream(file5);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file6,true);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream2);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream2);
        //写d1：
        dataOutputStream.writeUTF("笨蛋");
        dataOutputStream.flush();
        dataOutputStream.writeInt(22);
        dataOutputStream.flush();
        dataOutputStream.writeBoolean(true);
        dataOutputStream.flush();
        //读d1：
        String name = dataInputStream.readUTF();
        int age = dataInputStream.readInt();
        boolean isMale = dataInputStream.readBoolean();
        System.out.println(name+" "+age+" "+isMale);


        //关闭资源
        //关闭外层的处理流就好了
        bufferedOutputStream.close();
        bufferedInputStream.close();
        bufferedReader.close();
        bufferedWriter.close();
        dataInputStream.close();
        dataOutputStream.close();
    }
}
