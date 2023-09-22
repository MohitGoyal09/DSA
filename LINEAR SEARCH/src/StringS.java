public class StringS {

    public static void main(String[] args) {
        String name = "ZYSXA";
        char Target = 'x';
        boolean ans = Search( name , Target);
        System.out.println(ans);
    }
    static boolean Search( String Str , char Target){
        if ( Str.length() == 0){
            return false;
        }
        for  ( char chr : Str.toCharArray()){
            if ( chr == Target){
                return true;
            }
        }
        return false;
    }
}
