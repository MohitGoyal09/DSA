import java.util.*;

public class Arraylist {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.set(0,99);
        System.out.println(list);
    }
}
