import java.util.List;

public class generate_parathesis {
    public static void main(String[] args) {

    }
    private void generateParenthesisHelper(List<String> ans, StringBuilder sb, int n, int open, int close){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return ;
        }
        if(open<n){
            sb.append('(');
            generateParenthesisHelper(ans,sb,n,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }if(open>close){
            sb.append(')');
            generateParenthesisHelper(ans,sb,n,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
