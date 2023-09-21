import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//
//         int rollno = input.nextInt();
//        if (rollno % 2 == 0){
//            System.out.print("even");
//        }
//        else{
//            System.out.print("odd");
//        }

//        int a = input.nextInt();
//        int b = input.nextInt();
//        int c = input.nextInt();
//        int max = a;
//        if( b > max){
//            max = b;
//        }
//        if ( c > max){
//             max = c;
//        }
//        System.out.print(max);

        //Fibonacci Series In Java
        System.out.print("Enter no. for series:");
        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int a = 0;
//        int b = 1;
//        int count = 2;
//        while (count <= n){
//            int temp = b;
//            b = b + a;
//            a = temp;
//            count++;
//        }
         int term , a = 0 , b =1 , c;
         term = input.nextInt();
         for ( int i = 1 ; i <= term ; i++){
          c = a + b;
          a = b;
          b = c;


        System.out.println();

        

    }
}
}