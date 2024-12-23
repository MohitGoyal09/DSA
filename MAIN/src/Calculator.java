import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);

        // ! Take input from user till user press X or x
        while (true) {
            System.out.println("Enter oprator to perform");
            char op = in.next().trim().charAt(0);
            int ans = 0;
            System.out.println("Enter nums");
            int n1 = in.nextInt();
            int n2 = in.nextInt();

            if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
                if (op == '+') {
                    ans = n1 + n2;
                }

                if (op == '-') {
                    ans = n1 - n2;
                }
                if (op == '*') {
                    ans = n1 * n2;
                }
                if (op == '/') {
                    if (n2 != 0) {
                        ans = n1 / n2;
                    }
                }
                if (op == '%') {
                    ans = n1 % n2;
                }
            } else if (op == 'x' || op == 'X') {
                break;
            } else {
                System.out.println("Invalid");
            }
            System.out.println(ans);

        }
    }
}
