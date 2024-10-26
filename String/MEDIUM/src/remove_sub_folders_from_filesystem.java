import java.util.*;
public class remove_sub_folders_from_filesystem {
    //Approach-1 (Using set and substring find)
//T.C : O(n*L^2)
//S.C : O(n) //You can consider the length of each character as well - O(n*L)
    public ArrayList<String> removeSubfolders(String[] folders) {
        Set<String> Folderset = new HashSet<>(Arrays.asList(folders));
        ArrayList<String> result = new ArrayList<>();

        for (String currFloder : folders) {
            boolean isSubFolder = true;
            String temp = currFloder;
            while (!currFloder.isEmpty()){
                int position = currFloder.lastIndexOf('/');
                if (position == -1) break;
                currFloder = currFloder.substring(0, position);
                if (!Folderset.contains(currFloder)) {
                    isSubFolder = false;
                    break;
                }
            }
            if (isSubFolder) result.add(temp);
        }

        return result;
    }

    //Approach-2 (Using Sorting)
//T.C : O(n*logn) //You can consider the length of each character as well - O(n*L*logn)
//S.C : O(1)
    public ArrayList<String> removeSubfolders2(String[] folders) {
        Arrays.sort(folders);
        ArrayList<String> result = new ArrayList<>();
        result.add(folders[0]);

        for (int i = 1; i < folders.length; i++) {
            String currFolder = folders[i];
            String lastFolder = result.get(result.size() - 1);
            lastFolder += '/';
            if (!lastFolder.equals(currFolder)) result.add(currFolder);
        }

        return result;
    }
}
