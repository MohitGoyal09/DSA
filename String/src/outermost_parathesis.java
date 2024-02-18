public class outermost_parathesis {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
    // ! Time & Space complexity  : O(N)

       static String removeOuterParentheses(String s) {
            StringBuilder res = new StringBuilder();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' && count == 0) {
                    count++;
                } else if (s.charAt(i) == '(' && count >= 1) {
                    res.append(s.charAt(i));
                    count++;
                } else if (s.charAt(i) == ')' && count > 1) {
                    res.append(s.charAt(i));
                    count--;
                } else if (s.charAt(i) == ')' && count == 1) {
                    count--;
                }
            }
            return res.toString();
        }

}
