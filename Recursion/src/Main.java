
 public class  Main {
     public static void main(String[] args) {
         print();
     }

     static int cnt = 0;

     static void print() {

         // Base Condition.
         if (cnt == 3) return;
         System.out.println(cnt);

         // Count incremented.
         cnt = cnt + 1;
         print();

     }
 }