import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP_receive implements Runnable{
    DatagramSocket socket = null;
    private int port;
    private String msgFrom;
    public UDP_receive(int port, String msgFrom) throws SocketException {
        this.port = port;
        this.msgFrom = msgFrom;
        socket = new DatagramSocket(port);
    }
    @Override
    public void run() {
        while (true) {
            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container,0,container.length);
                socket.receive(packet);

                byte[] data = packet.getData();
                String receiveData = new String(data,0,data.length);

                System.out.println(msgFrom+"："+receiveData);

                if (receiveData.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
