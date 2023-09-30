public class name {
    public static void main(String[] args) {
        func(1,5);
    }
    static void func( int i , int N){
        if ( i>N) return;
        System.out.println("lol" + " ");
        func(i+1,N);
    }
}
