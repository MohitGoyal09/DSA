public class fraction_add_sub {
    class Solution {
        public String fractionAddition(String expr) {
            int nume = 0; // Numerator
            int deno = 1; // Denominator

            int i = 0;
            int n = expr.length();
            while (i < n) {
                int currNume = 0; // Current fraction numerator
                int currDeno = 0; // Current fraction denominator

                boolean isNeg = (expr.charAt(i) == '-');

                // Skip '+' or '-'
                if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                    i++;
                }

                // Build the current numerator
                while (i < n && Character.isDigit(expr.charAt(i))) {
                    int val = expr.charAt(i) - '0';
                    currNume = (currNume * 10) + val;
                    i++;
                }

                i++; // Skip the division character '/'

                if (isNeg) {
                    currNume *= -1; // Apply negative sign if needed
                }

                // Build the current denominator
                while (i < n && Character.isDigit(expr.charAt(i))) {
                    int val = expr.charAt(i) - '0';
                    currDeno = (currDeno * 10) + val;
                    i++;
                }

                // Update the accumulated numerator and denominator
                nume = nume * currDeno + currNume * deno;
                deno = deno * currDeno;
            }

            // Simplify the fraction using the greatest common divisor (GCD)
            int gcd = gcd(Math.abs(nume), deno);

            nume /= gcd;
            deno /= gcd;

            // Return the result in the form "numerator/denominator"
            return nume + "/" + deno;
        }

        // Helper method to calculate the greatest common divisor (GCD) using Euclidean algorithm
        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }
}
