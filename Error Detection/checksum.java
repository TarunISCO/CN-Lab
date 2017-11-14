import java.util.*;

class checksum {

    public static String add_binary(String str_1 , String str_2) {
        StringBuilder sum = new StringBuilder("");
        int carry = 0;
        
        for(int i = 0; i < 8; i++){
            int m = getBit(str_1, 7 - i );
            int n = getBit(str_2, 7 - i );
            int add = m + n + carry;
            sum.append(add % 2);
            carry = add / 2;
        }
        sum = sum.reverse();
        String result = sum.toString();

        if(carry == 1) {
            result = add_binary(result , "00000001");
        }
        return result;
    }

    public static int getBit(String s, int index){
        
        if(s.charAt(index) == '0')
            return 0;
        else
            return 1;
        
    }

    public static String ones_compliment(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                result += '1';
            else
                result += '0';
        }
        return result;
    }

    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of DataBytes :");
        int byte_count = scan.nextInt();
        scan.nextLine();
        String output_string = "00000000";
        for(int i = 0; i < byte_count; i++) {
            System.out.print("Enter Byte " + (i+1) + " : ");
            String input_byte = scan.nextLine();
            output_string = add_binary(output_string, input_byte);
        }
        output_string = ones_compliment(output_string);
        System.out.println("Result is : " +output_string);

    }
}