public class functions {
    public static void main(String[] args) {

    hello();
    int ans = sum3( 20 , 30);
        System.out.println(ans);
     String name = greet("YO");
        System.out.println(name);
    }

    //VOID Function
    static void  hello() {
        String message = "hello";
        System.out.println(message);

    }

    //INT RETURN
    static int sum3( int a , int b) {
        int sum = a + b;
        return sum;
    }

    //STRING RETURN
    static String greet(String name){
        String mess = "hello" + name;
        return mess;
    }

    //
}
