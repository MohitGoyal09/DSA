import java.util.*;

public class world_ladder_2 {
    public ArrayList<ArrayList<String>> word(String start , String end , String[] wordlist){
        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set<String> st = new HashSet<>();
        int len = wordlist.length;
        for (int i = 0 ; i < len ; i++){
            st.add(wordlist[i]);
        }
        // Creating a queue ds which stores the words in a sequence which is
        // required to reach the targetWord after successive transformations.
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(start);
        q.add(ls);
        ArrayList<String> usedonlevel = new ArrayList<>();
        usedonlevel.add(start);
        int  level = 0;

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int cnt = 0;
        while (!q.isEmpty()){
            cnt++;
            ArrayList<String> vec = q.peek();
            q.remove();

            if (vec.size() > level){
                level++;
                for (String it : usedonlevel){
                    st.remove(it);
                }
            }
            String word = vec.get(vec.size() - 1);
            // store the answers if the end word matches with targetWord.
            if (word.equals(end)){
                if (ans.size() == 0 ){
                    ans.add(vec);
                }
                else if (ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }
            }
           for (int i = 0 ; i < word.length() ; i++) {
               for (char c = 'a'; c <= 'z'; c++) {
                   char replacedCharArray[] = word.toCharArray();
                   replacedCharArray[i] = c;
                   String replacedWord = new String(replacedCharArray);
                   if (st.contains(replacedWord) == true) {
                       vec.add(replacedWord);
                       // Java works by reference, so enter the copy of vec
                       // otherwise if you remove word from vec in next lines, it will
                       // remove from everywhere
                       ArrayList<String> temp = new ArrayList<>(vec);
                       q.add(temp);
                       // mark as visited on the level
                       usedonlevel.add(replacedWord);
                       vec.remove(vec.size() - 1);
                   }
               }
           }
        }
        return ans;
    }

}

