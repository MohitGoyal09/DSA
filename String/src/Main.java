// CHECK IF STRING IS PALINDROME OR NOT
public class Main {
    public static void main(String[] args) {

        String name = "ABCDEF";
        String sh = "NITIN";
      System.out.println(checkPalindrome2(0,sh));
        boolean ans = checkPalindrome(name);

        if ( ans == true) System.out.println("Palindrome");
        else{
            System.out.println("Not Palindrome");
        }
    }
    static boolean checkPalindrome(String s){
        int left = 1; int right = s.length() -1;

        while(left<right){
            char l =s.charAt(left);
            char r = s.charAt(right);
            if (!Character.isLetterOrDigit(l)){
                left++;
            }
            else if (!Character.isLetterOrDigit(r)){
                right--;
            }
            else if ( Character.valueOf(l) != Character.valueOf(r)){
                return false;
            }
            else{
                left++;
                right--;
            }

        }
        return true;
    }

    //RECURSIVE APPROCH
    static boolean checkPalindrome2(int i ,String s){
        if ( i >= s.length()/2) return true;

        if ( s.charAt(i) != s.charAt(s.length()-1-i)) return false;

        return checkPalindrome2( i+1 , s);
    }
}