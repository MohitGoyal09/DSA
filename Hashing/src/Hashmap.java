import java.util.HashMap;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        int arr[] = new int[n];
        for ( int i = 0; i<n ; i++){
            arr[i] = in.nextInt();
        }

        HashMap< Integer , Integer > hp = new HashMap<>();
         for ( int i = 0; i<n ; i++){
            int key = arr[i];
            int freq = 0;
            if ( hp.containsKey(key)) freq = hp.get(key);
            freq++;
            hp.put(key,freq);
        }
         int q;
          q = in.nextInt();
          while ( q-- >0){
              int number;
              number = in.nextInt();
              // fetching..
              if (hp.containsKey(number)) System.out.println(hp.get(number));
              else System.out.println(0);
          }
    }
}
