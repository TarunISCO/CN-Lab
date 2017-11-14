import java.util.*;
import java.lang.*;
class parity {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the bata byte :");
        String inp_data = scan.nextLine();
        int one_count = 0;
        for (int i = 0; i < inp_data.length(); i++){
            if(inp_data.charAt(i) == '1')
                one_count++;
        }
        one_count = one_count % 2;
        String output = inp_data + one_count;
        System.out.println("Data after adding even parity bit is : " + output);

        System.out.println("\t\t\t ......Sending Data.......");
        System.out.print("Enter Data Recieved :");
        String rec_data = scan.nextLine();

        one_count = 0;
        for (int i = 0; i < rec_data.length() - 1; i++){
            if(inp_data.charAt(i) == '1')
                one_count++;
        }
        one_count = one_count % 2;
        if( one_count == Character.getNumericValue(rec_data.charAt(rec_data.length()-1)) )
            System.out.println("True");
        else
            System.out.println("False");

    }
}