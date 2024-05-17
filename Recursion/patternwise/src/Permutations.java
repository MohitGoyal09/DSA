import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(premutationsList("" , "abc"));
    }
    static void  premutations(String p , String up){
         if (up.isEmpty()){
             System.out.println(p);
             return;
         }
         char c = up.charAt(0);
         for (int i = 0 ; i <= p.length() ; i++){
             String f = p.substring(0,i);
             String e = p.substring(i , p.length());
             premutations(f + c + e , up.substring(1));
         }
    }

    static ArrayList<String> premutationsList(String p , String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char c = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0 ; i <= p.length() ; i++){
            String f = p.substring(0,i);
            String e = p.substring(i , p.length());
            ans.addAll((premutationsList(f + c + e , up.substring(1))));
        }
        return ans;
    }
}
