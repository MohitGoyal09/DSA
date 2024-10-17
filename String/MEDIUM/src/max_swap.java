public class max_swap {
    //Approach-1 (using space to store maxRight Indices)
    //T.C : O(n)
    //S.C : O(n)
    public int maximumSwap(int num) {
        String s = Integer.toString(num); // Convert num to string
        int n = s.length();

        // Array to store the index of the maximum element to the right
        int[] maxRight = new int[n];

        // Initialize the last element of maxRight
        maxRight[n - 1] = n - 1;

        // Fill the maxRight array, starting from the second last element
        for (int i = n - 2; i >= 0; i--) {
            int rightMaxIdx = maxRight[i + 1];
            char rightMaxElement = s.charAt(rightMaxIdx);

            // Update maxRight with the index of the maximum element
            if (s.charAt(i) > rightMaxElement) {
                maxRight[i] = i;
            } else {
                maxRight[i] = rightMaxIdx;
            }
        }

        // Find the first position where swapping will maximize the number
        for (int i = 0; i < n; i++) {
            int maxRightIdx = maxRight[i];
            char maxRightElement = s.charAt(maxRightIdx);

            // If there is a bigger digit to the right, swap and return the result
            if (s.charAt(i) < maxRightElement) {
                char[] charArray = s.toCharArray();
                char temp = charArray[i];
                charArray[i] = charArray[maxRightIdx];
                charArray[maxRightIdx] = temp;

                // Convert back to integer and return
                return Integer.parseInt(new String(charArray));
            }
        }

        return num; // If no swap is possible, return the original number
    }
    //Approach-2 (using constant space)
    //T.C : O(n)
    //S.C : O(1)
    public int maximumswap(int num){
        String s = Integer.toString(num);
        int n = s.length();
        int[] maxRight = new int[10];
        for (int i = 0; i < 10; i++) {
            maxRight[i] = -1;
        }
        for (int i = 0 ; i < n ; i++){
            int idx = s.charAt(i) - '0';
            maxRight[idx] = i;
        }
        for (int i = 0 ; i < n ; i++){
            int currDigit = s.charAt(i) - '0';
            for (int digit = 9 ; digit > currDigit ; digit--){
                if (maxRight[digit] > i ){
                    char[] charArray = s.toCharArray();
                    char temp = charArray[i];
                    charArray[i] = charArray[maxRight[digit]];
                    charArray[maxRight[digit]] = temp;

                    // Return the modified number
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;
    }
}

