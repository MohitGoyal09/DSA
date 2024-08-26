import java.util.*;
public class page_faults {
    class Solution{
        static int pageFaults(int N, int C, int pages[]){
            // code here
            LinkedList<Integer> list=new LinkedList<Integer>();
            HashSet<Integer> hash=new HashSet<>();

            int fault=0;

            for(int i=0;i<N;i++){

                if(hash.contains(pages[i])){
                    list.remove((Integer)pages[i]);
                    list.add(pages[i]);

                }
                else {
                    fault++;
                    if(list.size()==C){
                        int item=list.removeFirst();
                        hash.remove(item);
                    }
                    list.add(pages[i]);
                    hash.add(pages[i]);
                }
            }
            return fault;


        }
    }
}
