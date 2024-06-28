import java.util.HashMap;

public class Minimum_Window_Substring {
    public static void main(String[] args) {

    }
    class Solution {
        public String minWindow(String s, String t) {
            int l=0;
            int r=0;
            HashMap<Character,Integer> mpp=new HashMap<>();
            int cnt=0;
            int sindex=-1;
            int minlen=Integer.MAX_VALUE;
            String st="";
            for(int i=0;i<t.length();i++){
                mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
            }
            while(r<s.length()){
                char ch=s.charAt(r);
                if(mpp.containsKey(ch) && mpp.get(ch)>0){
                    cnt++;
                }
                mpp.put(ch,mpp.getOrDefault(ch,0)-1);
                while(cnt==t.length()){
                    if(r-l+1<minlen){
                        minlen=r-l+1;
                        sindex=l;
                    }
                    mpp.put(s.charAt(l),mpp.get(s.charAt(l))+1);
                    if(mpp.get(s.charAt(l))>0){
                        cnt--;
                    }
                    l++;
                }
                r++;
            }
            return sindex==-1?"":s.substring(sindex,sindex+minlen);
        }
    }
}
