// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class Tournament {
    //a driver class with a main method that reports the win-rate for every possible pair of AIs.
    public static void main(String args[]){
        AI randomAi1 = new AI();
        AI randomAi2 = new AI();
        AI smallestAi1 = new SmallestCardAI();
        AI smallestAi2 = new SmallestCardAI();
        AI biggestAi1 = new BiggestCardAI();
        AI biggestAi2 = new BiggestCardAI();

        output(randomAi1, randomAi2); // Random Card AI vs. Random Card AI winRate: double
        
        output(randomAi1, smallestAi1); // Random Card AI vs. Smallest Card AI winRate: double
        
        output(randomAi1, biggestAi2); // Random Card AI vs. Biggest Card AI winRate: double
        
        output(smallestAi1, randomAi2); // Smallest Card AI vs. Random Card AI winRate: double
        
        output(smallestAi1, smallestAi2); // Smallest Card AI vs. Smallest Card AI winRate: double
        
        output(smallestAi1, biggestAi2); // Smallest Card AI vs. Biggest Card AI winRate: double

        output(biggestAi1, randomAi1); // Biggest Card AI vs. Random Card AI winRate: double
        
        output(biggestAi1, smallestAi2); // Biggest Card AI vs. Smallest Card AI winRate: double

        output(biggestAi1, biggestAi2); // Biggest Card AI vs. Biggest Card AI winRate: double
    }
    /**
     * Helper function to output winRate
     * @param ai1
     * @param ai2
     */
    public static void output(AI ai1, AI ai2){
        Deck deck = new Deck();
        Hand hand = new Hand(deck, 5);
        CardPile pile = new CardPile(deck.draw());
        
        UnoWarMatch match = new UnoWarMatch(ai1, ai2);
        System.out.println(ai1 + " vs. " + ai2 + " winRate: " + match.winRate(2000));
    }
}