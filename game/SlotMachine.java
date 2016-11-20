package game;

import java.util.Stack;

/**
 * Created by Tom on 11/11/2016.
 */
public class SlotMachine {

    /**
     * Pull the lever
     * @param pack - Card pack to play with
     * @param numberOfSlots - Number of slots
     * @return Resulting card pack
     */
    public Stack<Card> pull(CardPack pack, int numberOfSlots) {
        Slot current = new Slot();
        for (int i = 0; i < numberOfSlots; i++) {
            current.run(pack);
        }
        return current.getCards();
    }
}
