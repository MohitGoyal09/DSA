public class EvenDigits {
    public static void main(String[] args) {
        int[] arr = { 2345 , 3 , 45 , 234};

        // Call the findnums function and store the result in ans
        int ans = findnums(arr);

        // Print the number of even-digit numbers in the array
        System.out.println(ans);
    }

    // Function to count the number of even-digit numbers in an array
    static int findnums(int[] nums) {
        int c = 0; // Initialize a counter for even-digit numbers

        // Iterate through each number in the array
        for (int num : nums) {
            if (even(num)) { // Check if the number has an even number of digits
                c++; // Increment the counter if the number has an even number of digits
            }
        }
        return c; // Return the count of even-digit numbers
    }

    // Function to check if a number has an even number of digits
    static boolean even(int num) {
        int numofdigits = digits(num); // Get the number of digits in the number

        // Check if the number of digits is even
        return numofdigits % 2 == 0;
    }

    // Function to count the number of digits in a number
    static int digits(int num) {
        if (num < 0) {
            num *= -1; // If the number is negative, make it positive for counting digits
        }

        if (num == 0) {
            return 1; // Special case: zero has one digit
        }
        int count = 0; // Initialize a counter for digits

        // Count the digits using a loop
        while (num > 0) {
            num /= 10; // Remove the last digit
            count++; // Increment the digit count
        }
        return count; // Return the total number of digits
    }
}

