import java.util.*;

public class Arraylist {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(10);
//        list.add(1);
        Scanner in = new Scanner(System.in);
        for ( int i = 0 ; i < 10 ; i++ ) {
            list.add(in.nextInt());
        }
        for ( int i : list ) {
            System.out.println(list.get(i));
        }
        list.set(0,99);

    }
}
