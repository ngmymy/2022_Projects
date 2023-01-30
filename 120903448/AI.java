// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class AI {
    //class acts as both as a Random AI, and the parent class for all other AIs.

    /**
     * Constructor for AI
     */
    public AI(){}

    /**
     * @param hand list of cards
     * @param cardPile the pile of card that is able to be drawn from
     * @return returns the card in hand, otherwise null
     */
    public Card getPlay(Hand hand, CardPile cardPile){
        for(int i = 0; i < hand.getSize(); i++){
            Card handCard = hand.get(i);
            if(cardPile.canPlay(handCard)){
                return handCard;
            }
        }
        return null;

    }

    /**
     * Given string toString
     */
    public String toString(){
        return "Random Card AI";
    }
}