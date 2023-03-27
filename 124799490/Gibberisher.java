// CSCI 1913 Spring 2022 Project 3
// AUTHOR: My My Nguyen
public class Gibberisher{
    private Trie<CharBag> letterCounts;
    private int segLength;
    private int processed;

    /**
     * Takes the value of the segment length and initializes Trie and sample count variables
     */
    public Gibberisher(int segLength){
        letterCounts = new Trie<>(); 
        this.segLength = segLength;
        processed = 0;
    }

    /**
     * Uses LetterSample class to generate LetterSamples, and then for each adds the sample into the model.
     *      Using string from the LetterSample to get appropriate CharBag, then adding the char from LetterSample to charBag
     * Deals with the possibility that it is the first sample for a given string segment
     *      make new CharBag and add it
     * @param args String array being used by letterSample class
     */
    public void train(String[] args){
        for(String s: args){
            LetterSample[] samples = LetterSample.toSamples(s, segLength);
            for(LetterSample ls: samples){
                //find index, if doesnt exist becomes -1
                if(letterCounts.get(ls.getSegment()) == null){
                    letterCounts.put(ls.getSegment(), new CharBag());
                }
                letterCounts.get(ls.getSegment()).add(ls.getNextLetter()); //adding in next letter
                processed++;
            }
        }
    }
    /**
     * Gets the number of samples used so far to train the model
     */
    public int getSampleCount(){
        return processed;
    }

    /**
     * Generates a string
     */
    public String generate(){
        String outString = "";
        boolean isMakingWord = true; //checks if done making word

        while(isMakingWord){ //while not done making word get last four characters of string
            String lastFour = outString.substring(Math.max(0, outString.length()-segLength)); //Substring: Gets string with set amount of characters
            CharBag bag = letterCounts.get(lastFour); //charbag that corresponds to those lastFour
            char nextChar = bag.getRandomChar();
            if(nextChar == LetterSample.STOP){ //if its a stop then stop making word
                isMakingWord = false;
            } else {
                outString += nextChar; //otherwise add to final string
            }
        }
        return outString;
    }
}