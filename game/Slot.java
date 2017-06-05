package game;

import java.util.Stack;

/**
 * Created by Tom on 11/11/2016.
 */
public class Slot {
    /**
     * The static stack of cards
     */
    static Stack<Card> stkCards;

    /**
     * Static constructor.
     */
    static {
        stkCards = new Stack<>();
    }

    /**
     * Run the slot
     * @param pack - Cards pack
     */
    public void run(CardPack pack) {
        Card card = pack.getRandom();
        stkCards.push(card);
    }

    /**
     * Get the cards
     * @return Stack of cards
     */
    public Stack<Card> getCards() {
        return this.stkCards;
    }
}
