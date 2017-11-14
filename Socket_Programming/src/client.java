
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String args[]) throws IOException,UnknownError{
        InetAddress address = InetAddress.getLocalHost();
        Scanner scan = new Scanner(System.in);
        System.out.print(address);
        Socket s = new Socket(address,65000);
        DataInputStream di = new DataInputStream(System.in);
        DataOutputStream ds = new DataOutputStream(s.getOutputStream());
        System.out.print("Enter msg to send to client");
        String user_input = "";
        while(true){
            user_input = scan.nextLine();
            ds.writeUTF(user_input);
            ds.flush();
            if(user_input.equals("over"))
                break;


        }
        ds.close();
        s.close();

    }
}
