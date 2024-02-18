public class longest_prefix {
    public static void main(String[] args) {
        String[] words = {"a","ab","abc"};
        System.out.println(longest(words));
    }
    static String longest(String[] words){
        String res = words[0];
        for (int i = 0 ; i < words.length ; i++){
            res = common(res,words[i]);
        }
        return res;
    }
    static String common(String S1, String S2){
        int n = Math.min(S1.length(),S2.length());
        StringBuilder sb = new StringBuilder();
        for ( int i = 0 ; i < n ; i++){
            if (S1.charAt(i) == S2.charAt(i)){
                sb.append(S1.charAt(i));
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}
