import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Date;

public class UDPServer {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        DatagramSocket aSocket = null;
        if (args.length < 1) {
            System.out.println("Usage: java UDPServer <Port Number>");
            System.exit(1);
        }
        try {
            int socket_no = Integer.valueOf(args[0]).intValue();
            aSocket = new DatagramSocket(socket_no);
            byte[] buffer = new byte[1000];
            DatagramPacket clientStamp = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(clientStamp);
            String stampString = new String(clientStamp.getData(), 0, clientStamp.getLength());
            System.out.println("Client connected at " + stampString + " (local time)");
            while(true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                byte[] data = request.getData();
                String mssg = new String(data, 0, request.getLength());
                if(mssg.equals("exit")) {
                    System.out.println("Client Left");
                    break;
                }
                
                System.out.println("\t" + mssg);

                String s = scan.nextLine();
                byte[] m = s.getBytes();
                DatagramPacket reply = new DatagramPacket(m,
                s.length(),request.getAddress(),
                request.getPort());
                aSocket.send(reply);
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