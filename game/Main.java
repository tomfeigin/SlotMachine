package game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    /**
     * The number of seconds each slot spins before stopping
     */
    static int SLOT_DELAY= 2;

    /**
     * The number of seconds the slots turn before they start stoping.
     */
    static int START_DELAY= 3;

    /**
     * Frame rate per second.
     */
    static int FRAME_RATE = 1;

    /**
     * The number of slots in the slot machine.
     */
    static int NUM_OF_SLOTS = 3;

    public static void main(String[] args) {
        SlotMachine machine = new SlotMachine();
        CardPack pack = new CardPack(getCardData());
        Stack<Card> results = machine.pull(pack, NUM_OF_SLOTS);
        ArrayList<Card> outCards = new ArrayList<Card>(results);
        ScoreCalculator calc = new ScoreCalculator();
        int score = calc.calculate(results);
        GUI graphics = new GUI();
        graphics.display(pack,outCards, score, SLOT_DELAY, START_DELAY, FRAME_RATE);
    }

    /**
     * Get card data for the card pack.
     * In this function you can create the cards that will be in the deck.
     * @return Linked list of cards.
     */
    static LinkedList<Card> getCardData() {
        LinkedList<Card> result = new LinkedList<Card>();

        result.push(new Card(3, 10, "0"));
        result.push(new Card(10, 8, "5"));
        result.push(new Card(20, 6, "J"));
        result.push(new Card(30, 4, "Q"));
        result.push(new Card(40, 2, "K"));
        result.push(new Card(50, 1, "A"));
        return result;
    }
}
