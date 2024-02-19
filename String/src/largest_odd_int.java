// ! Intuition
//* The goal is to find the largest odd number within a given integer represented as a string.
// * We need to identify the largest odd substring or return an empty string if no odd number exists.
//
// ! Approach
//* Iterate through the string from right to left.
//* If the last digit is odd, return the entire string as it is already the largest odd number.
//* If the last digit is even, keep moving left until an odd digit is found.
//* Return the substring from the beginning of the string to the index where the first odd digit is encountered.
// !       Complexity
//* The time complexity is O(n), where n is the length of the input string num.
//* The space complexity is O(1) since we are not using any extra space that scales with the input size.


public class largest_odd_int {
    public static void main(String[] args) {

        String num = "1524";
        System.out.println(sol(num));

    }
    static String sol(String S){
        if ((int)S.charAt(S.length()-1) %2==1) return S;
        int i = S.length()-1;
        while (i >= 0){
            int num = S.charAt(i);
            if (num % 2 == 1) return S.substring(0,i+1);
            i--;
        }
        return "";
    }
}
