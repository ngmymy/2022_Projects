// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class BiggestCardAI extends AI {
    // an AI that plays the highest-rank valid card in its hand.

    /**
     * BiggestCardAI Constructor
     */
    public BiggestCardAI(){}

    @Override
    /**
     * Return the biggest rank valid card in hand
     * @param hand represents cards in hands
     * @param cardPile represents drawable pile
     * @return biggest card in hand
     */
    public Card getPlay(Hand hand, CardPile cardPile){
        Card biggestCard = null;

        for(int i = 0; i < hand.getSize(); i++){
            Card handCard = hand.get(i);
            if(cardPile.canPlay(handCard) && (biggestCard == null ||  handCard.getRankNum() > biggestCard.getRankNum())){
                biggestCard = handCard;
            }
        }
        return biggestCard;
    }

    @Override
    /**
     * toString method for BiggestCardAi that returns "Biggest Card AI"
     */
    public String toString(){
        return "Biggest Card AI";
    }
}