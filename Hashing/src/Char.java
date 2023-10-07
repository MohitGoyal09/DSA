import java.util.Scanner;

public class Char {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        s = in.next();

        // precompute
        int[] hash = new int[26];
        for ( int i = 0 ; i <s.length() ; i++){
            hash[s.charAt(i) - 'a']+=1;
        }
        int n;
        n = in.nextInt();
        while ( n-- !=0){
            char c;
            c = in.next().charAt(0);
            //fetch;
            System.out.println(hash[c - 'a']);
        }
    }
}
