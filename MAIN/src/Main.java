
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int n =3;
        System.out.println(fac(n));
        System.out.println(sum(n));
    }
    static int fac(int n){
        if (n < 1) return 1;
        return n * fac(n-1);
    }
    static int sum(int n){
        if (n < 1) return 0;
        return n + sum(n-1);
    }
}