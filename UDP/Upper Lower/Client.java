import java.net.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class Client {

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
            byte[] buffer = new byte[1000];

            aSocket = new DatagramSocket();
            InetAddress aHost = InetAddress.getByName(args[0]);
            int serverPort = Integer.valueOf(args[1]).intValue();

            String stamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            byte[] byteStamp = stamp.getBytes();
            DatagramPacket spacket = new DatagramPacket(byteStamp, stamp.length(), aHost, serverPort);
            aSocket.send(spacket);

            DatagramPacket choices = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(choices);
            System.out.println("\t" + new String(choices.getData()));

            String choice = scan.nextLine();
            byte[] choiceByte = choice.getBytes();
            DatagramPacket choicePacket = new DatagramPacket(choiceByte, choice.length(), aHost, serverPort);
            aSocket.send(choicePacket);
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

                byte[] buffer1 = new byte[1000];
                DatagramPacket reply = new DatagramPacket(buffer1, buffer1.length);
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