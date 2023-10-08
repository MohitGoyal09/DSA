import java.util.HashMap;
import java.util.Scanner;

public class Stringmap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        s = in.next();

        HashMap< Character , Integer> hp = new HashMap<>();
        for ( int i = 0 ; i<s.length() ; i++){
            char key = s.charAt(i);
            int freq = 0;
            if (hp.containsKey(key)) {
                freq = hp.get(key);

            }
            freq++;

            hp.put(key , freq);
        }
        int q;
        q = in.nextInt();
        while ( q-- >0){
            String C;
            C = in.next();
            // fetching..
            if (hp.containsKey(C.charAt(0))) System.out.println(hp.get(C.charAt(0)));
            else System.out.println(0);
        }
    }
}
