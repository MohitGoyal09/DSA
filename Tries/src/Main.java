import java.util.*;
public class Main {
    class Node{
        Node[] children = new Node[26];
        boolean flag = false;
        boolean containskey(char ch){
            return children[ch-'a']!=null;
        }
        void put(char ch , Node node){
            children[ch-'a'] = node;
        }
        Node get(char ch){
            return children[ch-'a'];
        }
        void setEnd(){
            flag = true;
        }
        boolean isEnd(){
            return flag;
        }
    }
    private Node root;
    public Main(){
        root = new Node();
    }
    public void insert(String word){
        Node node =root;
        for ( int i = 0 ; i < word.length() ; i++){
            if (!node.containskey(word.charAt(i))){
                node.put(word.charAt(i) , new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean search(String word){
        Node node = root;
        for ( int i = 0 ; i < word.length() ; i++){
            if (!node.containskey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    public boolean startsWith(String prefix){
        Node node = root;
        for ( int i = 0 ; i < prefix.length() ; i++){
            if (!node.containskey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}