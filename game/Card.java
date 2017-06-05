package game;

/**
 * Created by Tom on 11/11/2016.
 */
public class Card {
    /**
     * Score value of the card
     */
    int _value;

    /**
     * Range value.
     */
    int _commonness;

    /**
     * Face value of the card
     */
    String _face;

    /**
     * Create a new instance of the card object
     * @param value - The score value of a card
     * @param commonness - The nominal "commonness" of the card
     * @param face - The face value of the card
     */
    public Card(int value, int commonness, String face) {
        if(value < 0) {
            value = 1;
        }
        if(commonness < 0) {
            commonness = 1;
        }
        this._value = value;
        this._commonness = commonness;
        this._face = face;
    }

    /**
     * Get the range value of the card
     * @return int
     */
    public int getCommonness() {
        return this._commonness;
    }

    /**
     * Get the score value of the card
     * @return int
     */
    public int getValue() {
        return this._value;
    }

    /**
     * Get the face value
     * @return string
     */
    public String getFace() {
        return _face;
    }

    /**
     * Check if this card is equal to another card
     * @param other - Card to check against this card
     * @return true if the cards are equal.
     */
    public boolean equals(Card other) {
        if(null == other) {
            return true;
        }

        boolean commonnessCompare = this._commonness == other.getCommonness();
        boolean valueCompare = this._value == other.getValue();
        boolean faceCompare = this._face.equals(other.getFace());
        return valueCompare && faceCompare && commonnessCompare;
    }
}
