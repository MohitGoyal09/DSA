import java.util.ArrayList;

// ! SubSeQ For Intger
public class Main {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        ArrayList<Integer> list = new ArrayList<>();
        printSub(0, arr, list);
    }
    private static void printSub(int i, int[] arr, ArrayList<Integer> list) {
        if (i == arr.length) {
            System.out.println(list.toString());
            return;
        }
        printSub(i + 1, arr, list);
        list.add(arr[i]);
        printSub(i + 1, arr, list);
        list.remove(list.size() - 1);

    }
}