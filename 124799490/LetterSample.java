// CSCI 1913 Spring 2022 Project 3
// AUTHOR: My My Nguyen

public class LetterSample{
    private String segment;
    private char nextLetter;
    public static final char STOP = '.';

    /**
     * Constructor for LetterSample class
     * @param s string segment
     * @param c the next letter 
     */
    public LetterSample(String s, char c){
        segment = s;
        nextLetter = c;
    }

    /**
     * Gets the segment string
     * @return the string segment
     */
    public String getSegment(){
        return segment;
    }

    /**
     * Gets the nextLetter
     * @return the next letter in the object
     */
    public char getNextLetter(){
        return nextLetter;
    }

    /**
     * Generates the string output for LetterSample
     * Ex: "segment" -> nextLetter 
     */
    public String toString(){
        return "\"" + segment + "\" -> " + nextLetter;
    }

    /**
     * Generates letter samples from the string given
     * @param input given string
     * @param segmentSize represents how long the size of segment is
     * @return the letterSample array sample
     */
    public static LetterSample [] toSamples (String input , int segmentSize){
        input += STOP;
        LetterSample[] sample = new LetterSample[input.length()];

        for(int i=0; i < input.length(); i++){
            char character = input.charAt(i); //index at character index i+segmentSize
            String seg = input.substring(Math.max(0, i-segmentSize), i); //creates new string segment that covers from index 
            sample[i] = new LetterSample(seg, character);
        }
        return sample;
    }
}