//                         !!!!!!!!!!!!!!!! DRY RUN CENTRE  !!!!!!!!!!!!!!!!
import java.util.*;

public class TND {
    public static void main(String[] args) {
//        int[][] arr = new int[3][3];
//        Scanner in = new Scanner(System.in);
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = in.nextInt();
//            }
//
//        }
//        int arr[] = {13, 46, 24, 52, 20, 9};
//        int n = arr.length;
//        System.out.println("Array before Sort: ");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//      sort(arr, n);
//        System.out.println("Array after selection sort: ");
//        for ( int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String s = in.next();
//        int[] hash = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            hash[s.charAt(i) - 'a'] += 1;
//        }
//        while (n-- != 0) {
//            char c = in.next().charAt(0);
//            System.out.println(hash[c - 'a']);
            int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = sum(a, k);
        System.out.println("The length of the longest subarray is: " + len);

        }
//      int arr[]  = new int[n];
//      for ( int i = 0 ;  i  < n ; i++){
//          arr[i] = in.nextInt();
//      }
//      int[] hash = new int[ 13];
//      for ( int i = 0 ; i < n ;i++){
//          hash[arr[i]]++;
//      }
//      int q = in.nextInt();
//      while ( q-- !=0){
//          int num = in.nextInt();
//          System.out.println(hash[num]);
//      }
      static int sum(int[] a , long k){
        int n = a.length;
       long sum = 0;
        int maxlen = 0;
        HashMap<Long,Integer> map = new HashMap<>();
        for ( int i = 0 ; i < n ; i++){
            sum +=a[i];
           if ( sum == k) maxlen = Math.max(maxlen , i+1);
           long rem = sum - k;
          if (map.containsKey(rem)){
              int len = i - map.get(rem);
              maxlen = Math.max(maxlen  , len);
          }
          if (!map.containsKey(sum)){
              map.put(sum , i);
          }



        }
        return maxlen;
      }
    }
//}

//    static boolean Armstrongg(int n){
//        int temp = n;
//        int count = 0;
//        int sumofpower = 0;
//        int og = n;
//        while ( temp != 0){
//            count++;
//            temp = temp/10;
//            while ( n!=0){
//                int digit = n % 10;
//                sumofpower += Math.pow(digit,count);
//                n/=10;
//            }
//        }
//        return ( og == sumofpower);
//    }
//    static void sort(int[] arr , int n){
//        for ( int i = 0 ; i <  n -1; i++){
//            int mini = i;
//            for ( int j = i+1 ; j < n ; j++){
//                if (arr[j] < arr[mini]){
//                    mini = j;
//                }
//            }
//            int temp = arr[mini];
//            arr[mini] = arr[i];
//            arr[i] = temp;
//        }
//    }


//    static void pattern( int n){
//        int count = 1;
//        for ( int i = 0 ; i< n ; i++){
//
//            for ( int j = n  ; j>i ; j--){
//                count++;
//                System.out.print(count   + "");
//            }
//            System.out.println();
//        }
//    }

// static void p2( int n){
//        for ( int i = 0 ; i < n ; i++){
//
//            for ( int  j = 0; j < n-i-1 ; j++){
//                System.out.print(" ");
//            }
//            for ( int j = 0; j < 2*i +1 ; j++){
//                System.out.print("*");
//            }
//            for ( int  j = 0; j < n-i-1 ; j++){
//                System.out.print(" ");
//            }
//            System.out.println();
//
//        }
// }

// static void p3(int n){
//        for ( int i = 0; i < n ; i++){
//
////            for ( int j = )
//        }
// }
//
// static void r( int i ,int n){
//        if ( i < 1) return;
//       System.out.println(i);
//       r( i -1 , n);
//
// }
//    static void sum( int i , int sum) {
//
//
//        if (i < 1) {
//            System.out.println(sum);
//            sum(i-1 , sum + i);
//        }
//    }



//    static void ss(int[] arr , int n){
//        for ( int i = 0; i <=n-1 ; i++){
//            int mini = i;
//            for ( int j =0 ; j <= n ; j++){
//                if ( arr[j] < arr[mini]){
//                    mini = j;
//                }
//                int temp = arr[mini];
//                arr[mini] = arr[i];
//                arr[i] = temp;
//            }
//        }
//    }
//}
