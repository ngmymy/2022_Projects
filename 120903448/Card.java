// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class Card {
    //class represents one playing card

    private int rank;
    private int suit;
    final static String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
    final static String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    
    /**
     * Sets new card values
     * @param rank
     * @param suit
     */
    public Card(int rank, int suit){
        if (suit <= 0 || suit > 4 || rank <= 0 || rank > 13){
            System.out.println("Invalid Card");
            this.rank = 1;
            this.suit = 1;
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    /**
     * Grabs the number of the card
     * @return (this) value of card
     */
    public int getRankNum(){
        return this.rank;
    }

    /**
     * If card is out of range then return "Invalid Card" otherwise return str number of card
     * @return String card number name (not #)
     */
    public String getRankName(){
        return ranks[this.rank-1];
    }

    /**
     * If card is out of range then return "Invalid Card" otherwise return name of card's suit
     * @return suit name
     */
    public String getSuitName(){
        return suits[this.suit-1];
    }

    /**
     * Prints the readable and complete name of card
     * @return if card is out of range returns "Invalid Card" and defaults to Ace of Spades
     */
    public String toString(){
        return ranks[rank-1] + " of " + suits[suit-1];
    }
    
    /**
     * Compares two cards to see if they are the same
     * @param obj of card
     * @return true the card is the same, else false
     */
    public boolean equals(Object obj){
        Card object = (Card) obj;
        if(object instanceof Card){
            if(rank == object.getRankNum() && suits[suit-1].equals(object.getSuitName())){
                return true;
            }
        }
        return false;
    }
    
}