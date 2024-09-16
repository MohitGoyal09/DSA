import java.util.*;
public class find_longest_substring_wtih_even_vowels {
    public int findTheLongestSubstring(String s) {
        Map<String, Integer> mp = new HashMap<>();

        // Initialize an array to track the count of each vowel
        int[] vowelCount = new int[5]; // Count of 'a', 'e', 'i', 'o', 'u'

        String currentState = "00000";  // Initial state where all vowels have even counts
        mp.put(currentState, -1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); ++i) {
            // Update count for the vowel encountered
            if (s.charAt(i) == 'a')      vowelCount[0] = (vowelCount[0] + 1) % 2;
            else if (s.charAt(i) == 'e') vowelCount[1] = (vowelCount[1] + 1) % 2;
            else if (s.charAt(i) == 'i') vowelCount[2] = (vowelCount[2] + 1) % 2;
            else if (s.charAt(i) == 'o') vowelCount[3] = (vowelCount[3] + 1) % 2;
            else if (s.charAt(i) == 'u') vowelCount[4] = (vowelCount[4] + 1) % 2;

            // Create a string representing the current parity state of vowels
            currentState = "";
            for (int j = 0; j < 5; ++j) {
                currentState += vowelCount[j];
            }

            // Check if we've seen this state before
            if (mp.containsKey(currentState)) {
                // Calculate the length of the substring
                maxLength = Math.max(maxLength, i - mp.get(currentState));
            } else {
                // Store the first occurrence of this state
                mp.put(currentState, i);
            }
        }

        return maxLength;
    }
    public int findTheLongestSubstring2(String s) {
        // Map to store the first occurrence of a state of vowel parities
        Map<String, Integer> mp = new HashMap<>();

        // Initialize an array to track the parity of each vowel
        int[] state = new int[5]; // [a, e, i, o, u] initialized to 0 (even count)

        String currentState = "00000";  // Start with all vowels having an even count
        mp.put(currentState, -1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); ++i) {
            // Update state based on the vowel encountered
            if (s.charAt(i) == 'a') state[0] ^= 1;  // Flip between even/odd for 'a'
            else if (s.charAt(i) == 'e') state[1] ^= 1; // Flip for 'e'
            else if (s.charAt(i) == 'i') state[2] ^= 1; // Flip for 'i'
            else if (s.charAt(i) == 'o') state[3] ^= 1; // Flip for 'o'
            else if (s.charAt(i) == 'u') state[4] ^= 1; // Flip for 'u'

            // Create a string representation of the current state
            currentState = "";
            for (int j = 0; j < 5; ++j) {
                currentState += state[j];
            }

            // Check if we've seen this state before
            if (mp.containsKey(currentState)) {
                // Calculate the length of the substring
                maxLength = Math.max(maxLength, i - mp.get(currentState));
            } else {
                // Store the first occurrence of this state
                mp.put(currentState, i);
            }
        }

        return maxLength;
    }

    public int findTheLongestSubstring3(String s) {
        Map<Integer, Integer> mp = new HashMap<>();
        int mask = 0;
        mp.put(mask, -1);
        int maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = 0;
            if (s.charAt(i) == 'a')      val = (1);
            else if (s.charAt(i) == 'e') val = (1 << 1);
            else if (s.charAt(i) == 'i') val = (1 << 2);
            else if (s.charAt(i) == 'o') val = (1 << 3);
            else if (s.charAt(i) == 'u') val = (1 << 4);

            mask ^= val; //xor nikala

            if (!mp.containsKey(mask)) //agar past me nahi dekha to map me daaldo
                mp.put(mask, i);

            maxL = Math.max(maxL, i - mp.get(mask)); //maxL nikaal lo
        }
        return maxL;
    }
}
