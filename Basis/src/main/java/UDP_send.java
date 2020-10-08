import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDP_send implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIP;
    private int toPort;

    public UDP_send(int fromPort,String toIP,int toPort){
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));

                socket.send(packet);
                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}

class Teacher{
    public static void main(String[] args) throws SocketException {
        new Thread(new UDP_send(7777,"localhost",9999)).start();
        new Thread(new UDP_receive(8888,"学生")).start();
    }
}

class Student{
    public static void main(String[] args) throws SocketException {
        new Thread(new UDP_send(5555,"localhost",8888)).start();
        new Thread(new UDP_receive(9999,"老师")).start();
    }
}