// CSCI 1913 Spring 2022 Project 3
// AUTHOR: My My Nguyen

public class Trie<T>{
    private TrieNode<T> root;

    /**
     * Constructor that initializes the root to a new node
     */
    public Trie(){
        root = new TrieNode<>();
    }

    /**
     * Takes a string and return the appropriate trieNode associated.
     * @param s string b
     * @return the child node
     */
    private TrieNode<T> getNode(String s){
        TrieNode<T> returnNode = root;
        for (int i = 0; i < s.length(); i++) {
            returnNode = returnNode.getChild(s.charAt(i));
        }
        return returnNode;
    }

    /**
     * Gets data currently stored on the TrieNode associated with the input string
     * @param string input
     * @return data in terms of type T
     */
    public T get(String string){
        return getNode(string).getData();
    }

    /**
     * Gets the data currently stored on the trieNode associated with string to the T value
     */
    public T put(String string, T t){
        getNode(string).setData(t);
        return getNode(string).getData();
    }

    /**
     * Returns the root node
     * @return the root node
     */
    public TrieNode<T> getRoot(){
        return root;
    }
}