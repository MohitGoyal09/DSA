public class reverse_words {
    public static void main(String[] args) {
        String st = "TUF is great for interview preparation";
        System.out.println("Before reversing words: ");
        System.out.println(st);
        System.out.println("After reversing words: ");
        System.out.println(better(st));
    }
    // ! Time Complexity : O(N ^ 2)
    static String bf(String S){
        if (S.length() == 0 || S == null) return "";
        int i = 0 ;
        int n = S.length();
        String res = "";
        while (i < n){
          while (i < n && S.charAt(i) == ' ') i++;
          if (i >= n) break;
          int j = i + 1;
          while (j < n && S.charAt(j) != ' ') j++;
          String w = S.substring(i,j);
          if (res.length() == 0) res = w;
          else res = w + " " + res;
          i = j+1;
        }
        return res;
    }

    // ! Time Complexity : 0(N)
    static String better(String S){
        if (S.length() == 0 || S == null) return "";
        String[] s = S.split(" ");
        String res = "";
        for (int i = s.length - 1; i >= 0; i--){
            if (s[i].length() == 0) continue;
            if (res.length() == 0) res = s[i];
            else res = res + " " + s[i];
        }
        return res;
    }
    // ! Time Complexity: O(N) but still takes less time buz of StringBuilder
    public String reverseWords(String s) {

        if(s.length()==0 || s==null) return "";

        StringBuilder sb = new StringBuilder();
        String[] str_arr = s.split(" ");
        int n=str_arr.length-1;
        for(int i=n;i>=0;i--){
            if(!str_arr[i].equals("")){
                sb.append(str_arr[i]).append(" ");
            }
        }
        return sb.length()==0 ? "": sb.substring(0,sb.length()-1);
    }

}
