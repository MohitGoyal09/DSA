import java.util.*;
public class roman_2_integer {
    public static void main(String[] args) {

    }
}

class Solution1 {
    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;
        for ( int i = 0 ; i < n ; i++){
            char c1 = s.charAt(i);
            if ((i+1) < n && getvalue(c1) < getvalue(s.charAt(i+1))){
                sum -= getvalue(c1);
            } else sum += getvalue(c1);
        }
        return sum;
    }
    public int getvalue(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
