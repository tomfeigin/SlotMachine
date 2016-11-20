package game;

import java.util.ArrayList;

/**
 * Created by Tom on 13/11/2016.
 */
public class GUI {

    /**
     * Display the slot machine
     * @param pack - The game pack
     * @param winning - The winning cards
     * @param score - The game score
     * @param slotDelay - The delay in seconds, each slot waits before it stops
     * @param startDelay - The delay in seconds, before the slots are signled to stop
     * @param sleep - The rate in milliseconds of printing the slots.
     */
    public void display(CardPack pack, ArrayList<Card> winning, int score, int slotDelay, int startDelay, int sleep) {
        if(sleep <= 0) {
            sleep = 1;
        }

        GUINode first = this.createChain(pack, winning, slotDelay, sleep);
        if(first == null) {
            System.out.println("Internal corruption error");
            return;
        }
        this.printWelcome();
        int nanoStartDelay = startDelay * 1000 / sleep;
        first.start(nanoStartDelay);
        this.printSlots(first, sleep);
        this.printScore(score);
    }

    /**
     * Construct a chain of GUINodes to be displayed in order.
     * @return The first Node of the GUINode chain.
     */
    protected GUINode createChain(CardPack pack, ArrayList<Card> winning, int slotDelay, int sleep) {
        int nanoSlotDelay = slotDelay * 1000 / sleep;
        GUINode next = null;
        for (Card current : winning) {
            GUINode newNode = new GUINode(pack, current, nanoSlotDelay, next);
            next = newNode;
        }
        return next;
    }

    /**
     * Run the graphics of the slot in the slot machine.
     * @param first - The first GUINode of the chain.
     * @param sleep - The value in milliseconds for the duration of thread sleep
     *                between printing a random card in each slot.
     */
    protected void printSlots(GUINode first, int sleep) {
        while (first.display() > 0) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
            }
            System.out.print('\r');
        }
    }

    /**
     * Print the score of the slot machine game.
     * @param score - The score achieved in the slot machine game.
     */
    protected void printScore(int score) {
        System.out.println();
        String dollars = Float.toString((float)score / 100) + "$";
        System.out.println("Score is: " + dollars);
    }

    /**
     * Print the welcome message to the slot machine game
     */
    protected void printWelcome() {
        System.out.println("Slot machine game!");
        System.out.println("- - - - - - - - - -");
    }
}
