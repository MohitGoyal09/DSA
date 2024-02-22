public class atoi_problem{
    public static void main(String[] args) {
        String s = "  -42";
        System.out.println(atoi(s));
    }
    static int atoi(String s) {
        s = s.trim();
        long ans = 0;
        if (s.length() == 0) return 0;
        boolean neg = false;
        for ( int i = 0 ; i < s.length() ; i++ ){
            char c = s.charAt(i);
            if (i == 0){
                if (c == '-'){
                    neg = true;
                    continue;
                } else if (c == '+') {
                    neg = false;
                    continue;
                }
            }
            if (c >= '0' && c <= '9'){
                int dig = c - '0';
                ans = ans * 10 + dig;
                if (neg){
                    if (-ans < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (ans > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
            } else break;
        }
        if (neg) {
            ans = -ans;
        }
        return (int) ans;
    }
}

