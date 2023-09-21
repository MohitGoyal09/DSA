import java.util.Scanner;

public class while_ques {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        int sum = 0;

        do {
            System.out.print("Enter a number (0 to exit): ");
            num = in.nextInt();
            sum += num;
        } while (num != 0);

        System.out.println("Sum of all numbers entered: " + sum);
        in.close(); // Close the scanner when you're done with it.
    }
}