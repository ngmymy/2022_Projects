// CSCI 1913 Spring 2022 Project 3
// AUTHOR: My My Nguyen

public class CharBag{

    private int[] charCount = new int[27];
    public final int ASCII_OFFSET = 97;

    /**
     * Default constructor for CharBag that creates an empty CharBag
     */
    public CharBag(){}

    /**
     * Adds character c to the charBag
     * @param c character that is being added
     */
    public void add(char c){
        c = Character.toLowerCase(c);
        if(Character.isAlphabetic(c)){
            charCount[c-ASCII_OFFSET]++;
        } else{
            charCount[26]++;
        }
    }

    /**
     * Removes a character from the charBag
     * @param c character that is being removed
     */
    public void remove(char c){
        c = Character.toLowerCase(c);
        if(Character.isAlphabetic(c)){
            charCount[c-ASCII_OFFSET] = Math.max(charCount[c-ASCII_OFFSET]-1, 0);
        } else{
            charCount[26] = Math.max(charCount[26]-1, 0);
        }
    }

    /**
     * Gets how many times a given character is in the charBag
     * @param c character being checked
     * @return a number representing how many times a character is in the charBag
     */
    public int getCount(char c){
        c = Character.toLowerCase(c);
        if(Character.isAlphabetic(c)){
            return charCount[c-ASCII_OFFSET];
        } else{
           return charCount[26];
        }
    }

    /**
     * Returns the total size of the charBag
     * @return size
     */
    public int getSize(){
        int total = 0;
        for(int i = 0; i< charCount.length; i++){
            total += charCount[i];
        }
        return total;
    }

    /**
     * toString method for CharBag
     * Ex: "CharBag{a:1, b:1, c:0, d:0, e:0, f:0, g:0, h:0, i:0, j:0, k:0, l:0, m:0, n:0, o:0, p:0, q:0, r:0, s:0, t:0, u:0, v:0, w:0, x:0, y:0, z:0, .:0}"
     */
    public String toString(){
        String out = "CharBag{";
        for (int i = 0; i < charCount.length; i++) {
            if(i != charCount.length-1){
                out+= (char) (i + ASCII_OFFSET) + ":" + charCount[i] + ", ";
            } else{
                out+= LetterSample.STOP + ":" + charCount[i] + "}";
            }
        }
        return out;
    }

    /**
     * Returns a randomly chosen character from the characters in the charBag
     * @return a randomly chosen character 
     */
    public char getRandomChar(){
        if(getSize() == 0){
            return LetterSample.STOP;
        } 
        int index = -1;
        int random = (int) (Math.random() * getSize());
        char retValue;
        while(random >= 0){ //randomize side and then subtract in order until is negative and then whatever char ends on the moment that hits 0 that is the randomChar
            index++;
            random -= charCount[index];
        }
        if(index < 26){
            retValue = (char) (index + ASCII_OFFSET);
        } else{
            retValue = LetterSample.STOP;
        }
        return retValue;
    }
}