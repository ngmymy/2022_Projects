// CSCI 1913 Project 2 Spring 2022
// AUTHOR: My My Nguyen

public class Deck{
    //class represents a deck of playing cards
    private final int NUM_OF_CARDS = 52;
    private Card [] cardDeck;
    private int remainingCards;

    /**
     * Initializes the size of cardDeck, and creates 52 different cards.
     */
    public Deck(){
        cardDeck = new Card[NUM_OF_CARDS];
        remainingCards = NUM_OF_CARDS;
        int i = 0;
        for (int suit = 1; suit <= 4; suit++){
            for(int rank = 1; rank <= 13; rank++){
                cardDeck[i++] = new Card(rank, suit);
            }
        }
        shuffle();
    }
    /**
     * shuffles the deck using the Durstenfeld-Fisher-Yates algorithm
     */
    public void shuffle(){
        for(int i = cardDeck.length-1; i > 0 ; i--){
            double j = Math.random() * NUM_OF_CARDS; //let j be a random integer between 0-i, inclusive
            Card hold = cardDeck[i];
            cardDeck[i] = cardDeck[(int) j];
            cardDeck[(int) j] = hold;
        }
    }

    /**
     * Draws a card from the deck
     *      Once card is drawn, it shouldn't be drawn again until deck has been reshuffled.
     *      If no cards remain, shuffle the cards and draw from the top of the deck
     * @return Card drawn from cardDeck array
     */
    public Card draw(){
        if (!isEmpty()){
            Card cardDrawn = cardDeck[remainingCards-1];
            remainingCards--;
            return cardDrawn;
        } else { // If the deck is empty it should shuffle the cards and then deal the new top of the deck.
            shuffle();
            remainingCards = NUM_OF_CARDS;           
            return draw();
        }
    }

    /**
     * Returns number of cards left
     * @return number of cards remaining
     */
    public int cardsRemaining(){
        return remainingCards;
    }

    /**
     * Checks if there are any cards left
     * @return true if deck is empty, otherwise false
     */
    public boolean isEmpty(){
        if (remainingCards == 0){
            return true;
        } else {
            return false;
        }
    }
}