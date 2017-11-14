import java.util.Scanner;
import java.net.*;
import java.io.*;

public class Inet {

    public static void main(String []args) throws IOException, UnknownHostException {
            
            InetAddress address1 = InetAddress.getByName("www.google.com");
            InetAddress address2 = InetAddress.getLocalHost();
            InetAddress address3 = InetAddress.getByName("8.8.8.8");
        
            // System.out.println(address1);
            // System.out.println(address2);
            // System.out.println(address3);

            int port = 65000;
            InetSocketAddress saddr = new InetSocketAddress(address2, port);
            System.out.println(saddr);
            System.out.println(saddr.getAddress().getHostAddress());
            System.out.println(saddr.getHostString() + ":" + saddr.getPort());
        
    }
}