package game;
import java.util.*;

/**
 * Created by Tom on 11/11/2016.
 */
public class CardPack {
    /**
     * Dictionary for all the cards
     */
    Dictionary<Integer, Card> _cards;

    /**
     * The aggregated range of the cards in the pack.
     */
    int aggRange;

    /**
     * Create a new instance of the Card Pack object
     * @param cards - List of possible cards.
     */
    public CardPack(LinkedList<Card> cards) {
        this._cards = new Hashtable<Integer, Card>();

        // Go thorugh the cards.
        for (Card c : cards) {
            // Add the card range to the aggregated value
            this.aggRange += c.getCommonness();

            // Store the card along with the aggregated range value.
            this._cards.put(this.aggRange, c);
        }
    }

    /**
     * Get a random card
     * @return
     */
    public Card getRandom() {
        int rand = new Random().nextInt(this.aggRange) % this.aggRange;

        Enumeration ranges = this._cards.keys();
        List<Integer> rangeList = Collections.list(ranges);
        Collections.sort(rangeList);

        for(Integer val : rangeList) {
            if(val > rand) {
                return this._cards.get(val);
            }
        }

        // Return null
        return null;
    }
}
