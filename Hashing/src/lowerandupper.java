import java.util.Scanner;

public class lowerandupper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        s = in.next();


        // Precompute
        int hash[] = new int[256];
        for( int i = 0 ; i<s.length() ; i++){
            hash[s.charAt(i)]++;
        }
        int q;
        q = in.nextInt();
        while ( q-- !=0){
            String c;
            c = in.next();
            // fetching...
            System.out.println(hash[c.charAt(0)]);
        }
    }
}
