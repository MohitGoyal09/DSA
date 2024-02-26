import java.util.* ;
import java.io.*;
public class string_encoding {
    public static void main(String[] args) {

    }

    public class Solution {
        public static String encode(String message) {
            // Write your code here.
            StringBuilder sb = new StringBuilder("");
            int count = 1;
            int i=0;
            for( i=1; i< message.length(); i++){
                if(message.charAt(i) != message.charAt(i-1)) {
                    // System.out.println("str "+message.substring(i-count,i));
                    sb.append(message.charAt(i - 1));
                    sb.append(count);
                    count = 1;
                }else count++;
            }
            if(count >= 1){
                sb.append(message.charAt(i-1)+"");
                sb.append(count+"");
            }
            return sb.toString();
        }
    }
}

