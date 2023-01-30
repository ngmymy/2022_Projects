// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class Hand { //class represents a hand of playing cards
    private Card [] hand;
    private Deck deck;
    
    /**
     * Initializes size of hand, and draws the amount of cards that the hand can hold.
     * @param deck
     * @param size
     */
    public Hand(Deck deck, int size){
        hand = new Card[size];
        this.deck = deck;
        for (int i = 0; i < size; i++){
            hand[i] = deck.draw();
        }
    }

    /**
     * Retrieves the size of hand
     * @return int 
     */
    public int getSize(){
        return hand.length;
    }

    /**
     * Get card at given index in hand, otherwise if index is out of bound then return first card in hand
     * @param i
     * @return Card
     */
    public Card get(int i){
        if(i > hand.length-1 || i < 0){
            System.out.println("Invalid hand index!");
            return hand[0];
        } else {
            return hand[i];
        }
    }

    /**
     * Searches through hand to see if card is in hand
     * @return boolean
     */
    public boolean remove(Card card){
        if(card != null){
            for (int i = 0; i < hand.length; i++){
                if (hand[i] == card){
                    hand[i] = deck.draw();
                    return true;
                }
            }
        }
        return false;
    }
}
