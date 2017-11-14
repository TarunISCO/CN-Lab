import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(65000);
        Socket s = ss.accept();
        DataInputStream ds = new DataInputStream(s.getInputStream());
        System.out.print("I am he");
        while (true) {
            String msg = ds.readUTF();
            if(msg.equals("over"))
                break;
            System.out.println(msg);
        }
        ss.close();

    }
}
