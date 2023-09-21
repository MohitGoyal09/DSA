public class shift {
    public static void main(String[] args) {
        int n = 23567;

        int ans=0;
        while ( n > 0 ){
            int rem = n % 10;
            n /=10;

            ans = ans * 10 + rem;
        }
        System.out.println(ans);
    }
}
