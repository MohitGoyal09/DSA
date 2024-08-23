public class trie_2 {
    class Node {
        Node[] link;
        int cntEndWith;
        int cntPrefix;
        Node(){
            link = new Node[26];
            cntPrefix = 0;
            cntEndWith = 0;
        }
        public boolean containsKey(char ch){
            return link[ch-'a']!=null;
        }
        public Node get(char ch){
            return link[ch-'a'];
        }
        public void put(char ch, Node node){
            link[ch-'a'] = node;
        }
        public void incrementPrefix(){
            cntPrefix++;
        }
        public void incrementEndWith(){
            cntEndWith++;
        }
        public void decrementPrefix(){
            cntPrefix--;
        }
        public void decrementEndWith(){
            cntEndWith--;
        }
        public int getPrefix(){
            return cntPrefix;
        }
        public int getEndWith(){
            return cntEndWith;
        }
    }
    private Node root;
    public trie_2(){
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for ( int i = 0 ; i < word.length() ; i++){
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i) , new Node());
            }
            node = node.get(word.charAt(i));
            node.incrementPrefix();
        }
        node.incrementEndWith();
    }
    public int countWordsEqualTo(String word){
        Node node = root;
        for ( int i = 0 ; i < word.length() ; i++){
            if (!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEndWith();
    }
    public int countWordsStartingWith(String word){
        Node node = root;
        for ( int i = 0 ; i < word.length() ; i++){
            if (!node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));

            } else {
                return 0;
            }
        }
        return node.cntPrefix;
    }
    public void earse(String word){
        Node node = root;
        for ( int i = 0 ; i < word.length() ; i++){
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.decrementPrefix();

            } else return;
        }
        node.decrementEndWith();
    }
}
