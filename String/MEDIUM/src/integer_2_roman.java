public class integer_2_roman {
    public static void main(String[] args) {

        int num = 1994;
        System.out.println(new Solution2().intToRoman(num));
    }

}
class Solution2 {
    public String intToRoman(int num) {
        StringBuilder Sb = new StringBuilder();
        process(Sb , "M" , "M", "M",num / 1000);
        num = num % 1000;
        process(Sb , "M" , "D", "C",num / 100);
        num = num % 100;
        process(Sb , "C" , "L", "X",num / 10);
        num = num % 10;
        process(Sb , "X" , "V", "I",num );
        return Sb.toString();
    }
    void process(StringBuilder Sr , String max , String mid , String min , int val){
        if (val <= 3){
            for (int i = 0 ; i < val ; i++){
                Sr.append(min);
            }
        } else if (val == 4 ) {
            Sr.append(min);
            Sr.append(mid);
        } else if (val == 5) Sr.append(mid);
        else if (val <= 8){
            Sr.append(mid);
            for (int i = 0 ; i < val - 5 ; i++){
                Sr.append(min);
            }
        } else if (val == 9){
            Sr.append(min);
            Sr.append(max);
        }
    }
}
