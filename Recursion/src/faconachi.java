
    public class faconachi {
        public static void main(String[] args) {
            int n = 6;
            System.out.println(fibonacci(n));
        }

        static int fibonacci(int N){
            // Base Condition.
            if(N <= 1) return N;
            return fibonacci(N-1) + fibonacci(N-2);
        }
    }
