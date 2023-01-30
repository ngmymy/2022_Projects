// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class SmallestCardAI extends AI {
    // an AI that plays the lowest-rank valid card in its hand.
    public SmallestCardAI(){}

    @Override
    /**
     * Return the smallest rank valid card in hand
     * @param hand represents cards in hands
     * @param cardPile represents drawable pile
     * @return smallest card in hand
     */
    public Card getPlay(Hand hand, CardPile cardPile){
        Card smallestCard = null;

        for(int i = 0; i < hand.getSize(); i++){
            Card handCard = hand.get(i);
            if( cardPile.canPlay(handCard) && (smallestCard == null || handCard.getRankNum() < smallestCard.getRankNum())){
                smallestCard = handCard;
            }
        }
        return smallestCard;
    }

    /**
     * toString method for SmallestCardAi that returns "Smallest Card AI"
     */
    public String toString(){
        return "Smallest Card AI";
    }

}