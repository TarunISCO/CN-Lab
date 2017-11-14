import java.util.*;

class CRC {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter DataBits \t: ");
        String data_bits = scan.nextLine();
        System.out.print("Enter Divisor \t: ");
        String divisor = scan.nextLine();
        for(int i = 0; i < divisor.length()-1; i++) {
            data_bits += '0';
        }

        String result = crc(data_bits, divisor);
        result = addBinary(result, data_bits);
        System.out.println("Data to Send \t: " +result);
    }

    public static String xor(String s1, String s2) {
        String result = "";
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == '0' && s2.charAt(i) == '0')
                result += '0';
            else if(s1.charAt(i) == '0' && s2.charAt(i) == '1')
                result += '1';
            else if(s1.charAt(i) == '1' && s2.charAt(i) == '0')
                result += '1';
            else if(s1.charAt(i) == '1' && s2.charAt(i) == '1')
                result += '0';
        }
        return result;
    }
    
    public static String crc(String data, String divisor) {
        String xor_result = "";
        int start_index = 0;
        while(start_index + divisor.length() <= data.length()) {
            String s1 = data.substring(start_index, start_index + divisor.length());
            xor_result = xor(s1, divisor);
            start_index++;
        }
        return xor_result;
    }

    public static String addBinary(String a, String b) {
        while( a.length() < b.length())
            a = '0' + a;

        while( b.length() < a.length())
            b = '0' + b;
        
        StringBuilder sum = new StringBuilder("");
        int carry = 0;
        
        for(int i = 0; i < a.length(); i++){
            int m = getBit(a, a.length() - i - 1);
            int n = getBit(b, a.length() - i - 1);
            int add = m + n + carry;
            sum.append(add % 2);
            carry = add / 2;
        }
        
        String result = sum.reverse().toString();
        if(carry == 1)
            result = addBinary(result, "1");
        
        return result;
    }
    public static int getBit(String s, int index){
        
        if(s.charAt(index) == '1')
            return 1;
        else
            return 0;
    }
}