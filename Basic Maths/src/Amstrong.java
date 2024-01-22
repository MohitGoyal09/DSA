import java.util.Scanner;

public class Amstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number to Check Amstrong");
        int n = in.nextInt();
        boolean ans = armstrong(n);
        if ( ans == true){
            System.out.println("Amstrong");
        } else {
            System.out.println(" NOT AMSTRONG");
        }

    }
    static boolean armstrong( int n ){
        int og = n;
        int count = 0;
        int temp = n;
       while ( temp !=0){
           count++;
           temp = temp/10;
       }
       int sumofpower = 0;
       while ( n!= 0){
           int digit = n % 10;
           sumofpower +=Math.pow(digit,count);
           n /=10;
       }
       return (og == sumofpower);
    }
}
