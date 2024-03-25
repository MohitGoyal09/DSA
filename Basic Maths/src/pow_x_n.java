public class pow_x_n {
    public static void main(String[] args) {

    }
    public double myPow(double x, int n) {
        long m = n; // Use long to handle negation of Integer.MIN_VALUE
        if (m < 0) {
            x = 1 / x; // Invert x if n is negative
            m = -m; // Make m positive
        }
        double ans = 1;
        while (m > 0) {
            if (m % 2 == 1) {
                ans *= x;
                m -= 1;
            } else {
                x *= x;
                m /= 2;
            }
        }
        return ans;
    }
}
