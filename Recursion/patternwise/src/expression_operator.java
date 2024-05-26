import java.util.List;

public class expression_operator {
    public static void main(String[] args) {

    }
    private void dfs(int index , String path , long resSofar , long prevnum , String s ,int target, List<String> ans){
        if (index == s.length()){
            if (resSofar == target) ans.add(path);
            return;
        }
        for (int i = index ; i < s.length() ; i++){
            if ( i > index && s.charAt(index) == '0') break;
            long currNum = Long.parseLong(s.substring(index , i+1));
            if (index == 0) dfs(i+1 , path + currNum , currNum , currNum , s,target , ans);
            else {
                dfs(i+1, path + "+" + currNum , resSofar + currNum , currNum , s, target , ans);
                dfs(i+1 , path + "-" + currNum , resSofar - currNum , -currNum , s , target , ans);
                dfs(i+1 , path + "*" + currNum , resSofar  - prevnum + prevnum * currNum ,
                        prevnum * currNum, s ,target , ans);
            }
        }
    }
}
