import java.util.Scanner;
import java.net.*;
import java.io.*;

class task1 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        // System.out.println("Enter the hostname : ");
        // String host_name = scan.nextLine();
        try
        {
            InetAddress i_address = InetAddress.getByName(args[0]);
            System.out.println(i_address.getHostAddress());
        }
        catch( UnknownHostException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
