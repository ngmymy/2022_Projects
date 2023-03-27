// CSCI 1913 Spring 2022 Project 3
// AUTHOR: My My Nguyen

public class TrieNode<T>{
    private T data;
    private TrieNode<T>[] children;

    /**
     * Constructor that initializes data to null, and children to an array with 26 null spaces
     */
    public TrieNode(){
        data = null;
        children = new TrieNode[26];
    }
    
    /**
     * Gets the data
     * @return data type T
     */
    public T getData(){
        return data;
    }

    /**
     * Sets the data
     * @param d type T
     */
    public void setData(T d){
        data = d;
    }

    /**
     * Returns the TrieNode<T> associated with the given letter
     * @param letter
     * @return children at specific index type TrieNode<T>
     */
    public TrieNode<T> getChild(char letter){
        //if not lowercase english letter than return null
        if (!Character.isLowerCase(letter)){
            return null;
        }else if (children[letter-'a'] == null){ // if correct array element == null
            // new trieNode added to array and returned
            children[letter-'a'] = new TrieNode<>();
            return children[letter-'a'];
        } else { //else return node from children
            return children[letter -'a'];
        }
    }

    /**
     * Returns the number of nodes in the tree
     */
    public int getTreeSize(){
        // returns number of nodes in the tree
        int count = 0;
        for (int i = 0; i < children.length; i++) {
            if(children[i] != null){
                count += children[i].getTreeSize();
            }
        }
        return count += 1; // accounting for starting node
    }
}