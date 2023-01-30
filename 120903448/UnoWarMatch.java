// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class UnoWarMatch {
    /* class represents a match-up of two AIs at UnoWar (one match-up may be settled by
    thousands of actual games, this object handles both single games, and multiple game series) 
    */
    private AI aiOne;
    private AI aiTwo;
    private final int ROUNDS = 10;
    private final int HAND_SIZE = 5;
    
    /**
     * Constructor for UnoWarMatch
     * @param ai1
     * @param ai2
     */
    public UnoWarMatch(AI ai1, AI ai2){
        aiOne = ai1;
        aiTwo = ai2;
    }
    /**
     * Plays UnoWar game until either AI has won 10 rounds
     * @return a boolean which is true if aiOne wins
     */
    public boolean playGame(){
        Deck deck = new Deck();
        Hand hand1 = new Hand(deck, HAND_SIZE);
        Hand hand2 = new Hand(deck, HAND_SIZE);
        CardPile pile = new CardPile(deck.draw());
        int ai1Wins = 0;
        int ai2Wins = 0;
        boolean aiOneWon = false;

        while(ai1Wins < ROUNDS && ai2Wins < ROUNDS){
          if(aiOneWon){ // loser ai goes first
            if(playRound(pile, hand2, hand1, aiTwo, aiOne)){ //flips hand and ais
                ai2Wins++;
                aiOneWon = false;
            } else {
                ai1Wins++;
            }
          } else {
            if(playRound(pile, hand1, hand2, aiOne, aiTwo)){
              ai1Wins++;
              aiOneWon = true;
            } else {
              ai2Wins++;
            }
          }
        }
        return ai1Wins > ai2Wins; // true if a1 wins and false 
    }

    /**
     * Computes the winRate 
     * @param nTrials number of trials run
     * @return a percentage between 0-1 inclusive where 1 means ai1 always won and 0 means ai2 always won.
     */
    public double winRate(int nTrials){
        double ai1Wins = 0.0;
        for(int i = 0; i < nTrials; i++){
            if(playGame()){
              ai1Wins++;
            }
        }
        return (ai1Wins / (double) nTrials);
    }

    /**
     * Plays one round
     * @param pile card pile
     * @param hand1 hand of AI one
     * @param hand2 hand of AI two
     * @param aiOne ai one player
     * @param aiTwo ai two player
     * @return
     */
    private boolean playRound(CardPile pile, Hand hand1, Hand hand2, AI aiOne, AI aiTwo){
        while(true){
          if(!playTurn(pile, hand1, aiOne)){
              return false;
          }
          if(!playTurn(pile, hand2, aiTwo)){
              return true;
          }
        }
      }
    /**
     * Plays one turn
     * @param pile card pile
     * @param hand player hand
     * @param ai ai player
     * @return true or false is card is able to be played
     */
    private boolean playTurn(CardPile pile, Hand hand, AI ai){
        Card cardCanPlay = ai.getPlay(hand, pile);
        if(cardCanPlay != null){ // if card isnt null play the card from pile and take it away from the hand
            pile.play(cardCanPlay);
            hand.remove(cardCanPlay);
            return true;
        }
        return false;
    }

}