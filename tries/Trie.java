package tries;

/*
    File Name : Trie.java
    
    @author Mayank Sharma
    First Created on 23-10-2020 at 12:36
*/

class TrieNode{

    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        for(int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

public class Trie {

    static TrieNode root;

    int CountChildren(TrieNode node){
        int count = 0;
        for(int i=0;i<26;i++){
            if(node.children[i]!=null){
                count++;
            }
        }
        return count;
    }

    static String getPrefix(TrieNode node){
        TrieNode traversal = node;
        return "";
    }
        
    static void Insert(String key){
        int len = key.length();
        TrieNode traversal = root;
        for(int currLevel = 0; currLevel < len; currLevel++){
            int index = key.charAt(currLevel) - 'a';
            if(traversal.children[index]==null){
                traversal.children[index] = new TrieNode();
            }
            traversal = traversal.children[index];
        }
        traversal.isEndOfWord = true;
    }

    static boolean searchInTrie(String key){
        int len = key.length();
        TrieNode traversal = root;
        for(int currLevel = 0; currLevel < len; currLevel++){
            int index = key.charAt(currLevel) - 'a';
            if(traversal.children[index]==null)
                return false;
            traversal = traversal.children[index];
        }
        return traversal!=null && traversal.isEndOfWord;
    }

    public static void main(String[] args) {

        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        root = new TrieNode();

        for(int i=0;i<keys.length;i++)
            Insert(keys[i]);

        boolean found1 = searchInTrie("the");
        System.out.println(found1);
    }

}
