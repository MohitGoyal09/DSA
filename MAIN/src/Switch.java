import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String fruit = in.next();

        switch (fruit){
            case "mango" -> System.out.println("aqsdfgr");
            case "apple" -> System.out.println("ddvzfvZXzxffv.zmvxc");
            default -> throw new IllegalStateException("Unexpected value: " + fruit);
        }
    }
}
