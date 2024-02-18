import java.util.Arrays;

public class anagram {
    public static void main(String[] args) {

        String str1 = "anagram";
        String str2 = "nagaram";
        System.out.println(checkAnagrams(str1,str2));
        System.out.println(ca(str1,str2));

    }
    public static String SortString(String str) {
        char c[] = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    public static boolean checkAnagrams(String str1, String str2) {
        // Case 1: when both of the strings have different lengths
        if (str1.length() != str2.length()) return false;
        str1 = SortString(str1);
        str2 = SortString(str2);
        // Case 2: check if every character of str1 and str2 matches with each other
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static boolean ca(String str1, String str2){
        if (str1.length() != str2.length()) return false;
        int[] freq = new int[26];
        for (int i = 0 ; i < str1.length(); i++){
            freq[str1.charAt(i) - 97]++;
        }
        for (int i = 0 ; i < str2.length(); i++){
            freq[str1.charAt(i) - 97]--;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}
