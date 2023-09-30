import java.util.ArrayList;
import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean ans = isPrime(n);
        if (n != 1 && ans == true) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Non Prime Number");
        }
    }

    public static boolean isPrime(int N) {

        for (int i = 2; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
}

