public class valid_parathensis {
    public boolean checkValidString(String s) {
        int max = 0 ;
        int min = 0 ;
        int n = s.length();
        for( int i = 0 ; i < n ; i++){
            if (s.charAt(i) == '('){
                min = min + 1;
                max = max + 1;
            } else if (s.charAt(i) == ')'){
                min = min - 1;
                max = max  - 1;
            } else {
                min = min - 1;
                max = max + 1;
            }
            if ( min < 0) min = 0;
            if ( max < 0) return false;
        }
        return ( min == 0);
    }
}
