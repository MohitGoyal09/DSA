public class Main {
    public static void main(String[] args) {

        String s = "babad";
        System.out.println(expand(s));
    }

    // ! Time Complexity : O(N^3)
    static String burutte(String S){
        if (S.length() <= 1) return S;
        int maxLen = 1;
        String mxstr = S.substring(0,1);
        for (int i = 0 ; i < S.length() ; i++){
            for ( int j = i + maxLen ; j < S.length() ; j++){
                if (j-i > maxLen && isPalindrome(S.substring(i,j))){
                    maxLen =  j - i;
                    mxstr = S.substring(i,j);
                }
            }
        }
        return mxstr;
    }
    static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // * Expand from centre Approach

    // ! Time Complexity : O(N^2)
    static String expand(String s){
      if (s.length() <= 1) return s;
      String str = s.substring(0,1);
      for (int i = 0 ; i < s.length() ; i++){
          String odd = expandfromcentre(s,i,i);
          String even = expandfromcentre(s,i,i+1);

          if (odd.length() > str.length()) {
              str = odd;
          }
          if (even.length() > str.length()) {
              str = even;
          }
      }
      return str;
    }
    static String expandfromcentre(String str , int start, int end){
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }
        return str.substring(start+1,end);
    }


}