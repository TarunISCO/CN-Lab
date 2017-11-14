import java.util.*;

class hamming {
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the data\t\t: ");
        String inp_data = scan.nextLine();
        inp_data = addBitsToString(inp_data);
        System.out.print("Hamming Code is\t\t: " + fill_P(inp_data) + "\n\nEnter Recieved Hamming code: ");
        String rec_data = scan.nextLine();
        if(rec_data.length() != inp_data.length())
            System.out.println("Data is lost or added");
        else
            verify_p(rec_data);
    }

    public static int getBit(String str, int index) {
        if (str.charAt(index) == '0')
            return 0;
        else
            return 1;
    }

    public static int cal_Pn(String str, int n) {
        int index = n;
        int sum = 0;
        while(index < str.length()) {
            for( int j = 0; index < str.length() && j < n; j++) {
                sum+= getBit(str, index);
                index++;
            }
            for( int j = 0; index < str.length() && j < n; j++) {
                index++;
            }
        }
        return sum%2;

    } 
    public static String fill_P(String str) {
        int i = 1;
        while(i < str.length()) {
            int p = cal_Pn(str, i);
            str = str.substring(0, i - 1) + (char)(p + '0') + str.substring(i, str.length());
            i = i*2;
        }
        return str;
    }
    public static void verify_p(String str) {
        int i = 1;
        int sum = 0;
        while(i < str.length()) {
            int p = cal_Pn(str, i);
            if(p != getBit(str, i - 1))
                sum += i;
            i = i*2;
        }
        sum -= 1;
        System.out.println(sum + "th Bit is changed");
    }
    public static String addBitsToString(String str) {
        int count = 1;
        str = "0" + str;
        while(Math.pow(2,count) < str.length()) {
            int ind = (int)Math.pow(2,count)-1;
            str = str.substring(0, ind) + "0" + str.substring(ind, str.length());
            count++;
        }
        return str;
    }
}