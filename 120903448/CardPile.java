// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class CardPile{
    //class represents a pile of playing cards
    private int size;
    private Card topCard;

    /**
     * Constructor of CardPile and initializes the size
     * @param topCard of the deck
     */
    public CardPile(Card topCard){
        this.topCard = topCard;
        size = 1;
    }
    
    /**
     * Returns if the card is playable
     * @param card a specific card
     * @return boolean if card is playable
     */
    public boolean canPlay(Card card){
        return card != null && (card.getRankNum() >= topCard.getRankNum() || card.getSuitName().equals(topCard.getSuitName()));
    }
    
    /**
     * Playing a card
     * @param card a specific card
     */
    public void play(Card card){
        if(canPlay(card)){
            topCard = card;
            size++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }
    
    /**
     * Return number of cards
     * @return int size
     */
    public int getNumCards(){
        return size;
    }

    /**
     * Return the top card
     * @return top card of the deck
     */
    public Card getTopCard(){
        return topCard;
    }
}