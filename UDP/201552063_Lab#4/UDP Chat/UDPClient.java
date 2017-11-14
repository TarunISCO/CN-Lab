import java.net.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class UDPClient {

    static boolean numberOrNot(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
    public static void main(String args[]) {
        // args give message contents and server hostname
        Scanner scan = new Scanner(System.in);
        DatagramSocket aSocket = null;
        if (args.length < 2) {
            System.out.println("Usage: java UDPClient <Host name> <Port number>");
            System.exit(1);
        }
        try {
            aSocket = new DatagramSocket();
            InetAddress aHost = InetAddress.getByName(args[0]);
            int serverPort = Integer.valueOf(args[1]).intValue();

            String stamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            byte[] byteStamp = stamp.getBytes();
            DatagramPacket spacket = new DatagramPacket(byteStamp, stamp.length(), aHost, serverPort);
            System.out.println("Connected to Server at " + stamp);
            aSocket.send(spacket);
            while(true)
            {
                
                
                String s = scan.nextLine();
                while(numberOrNot(s)) {
                    System.out.println("Sorry!!! Numbers are not allowed. Write Message again.");
                    s = scan.nextLine();
                }
                byte [] m = s.getBytes();
                DatagramPacket request = new DatagramPacket(m, s.length(), aHost, serverPort);
                aSocket.send(request);

                if(s.equals("exit")) {
                    break;
                }


                byte[] buffer = new byte[1000];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(reply);
                System.out.println("\t" + new String(reply.getData()));
            }
        }
        catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        finally {
            if (aSocket != null)
            aSocket.close();
        }
    }
}