import java.net.*;
import java.io.*;
public class TCPServer {
    public static void main(String[] args) throws Exception {
        try{
            ServerSocket server=new ServerSocket(8888);
            Socket serverClient=server.accept();
            DataInputStream inStream=new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream=new DataOutputStream(serverClient.getOutputStream());
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String clientMessage="", serverMessage="";
            while(true){
                clientMessage=inStream.readUTF();
                System.out.println("From Client: "+clientMessage);
                if(clientMessage.equals("bye"))
                    break;
                serverMessage=reader.readLine();
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }
            inStream.close();
            outStream.close();
            serverClient.close();
            server.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}