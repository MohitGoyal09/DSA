import java.util.Collections;

public class book_allocation {
    public static void main(String[] args) {

        int books[] = {25, 46, 28, 49, 24};
        int m = 4;
        System.out.println(bs(books , m));

    }
    static int book_allocation(int[] books , int m){
        int n = books.length;
        int max = Integer.MIN_VALUE , sum =  0;
        if ( m > n) return -1;
        for ( int i = 0 ; i < n ; i++){
            max = Math.max(max,books[i]);
            sum += books[i];
        }
        int low = max , high = sum;
        for ( int i = low ; i <= high ; i++){
            if (canAllocate(books , i) == m) return i;
        } return low;
    }
    static int canAllocate(int[] books , int pages){
        int stu = 1;
        int pages_student = 0;
        int n = books.length;
        for ( int i = 0 ; i < n ; i++){
            if ( pages_student + books[i] <= pages ){
                 pages_student += books[i];
            } else {
                stu++;
                pages_student = books[i];
            }
        }
        return stu;
    }

    static int bs(int[] books , int m){
        int n = books.length;
        int max = Integer.MIN_VALUE , sum =  0;
        if ( m > n) return -1;
        for ( int i = 0 ; i < n ; i++){
            max = Math.max(max,books[i]);
            sum += books[i];
        }
        int low = max , high = sum;
        while ( low <= high){
            int mid = (low + high)/2;
            int stu = canAllocate(books , mid);
            if (stu > m) low = mid +1;
            else high = mid -1;
        }
       return low;
    }
}
