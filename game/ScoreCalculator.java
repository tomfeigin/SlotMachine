package game;

import java.util.Stack;

/**
 * Created by Tom on 11/11/2016.
 */
public class ScoreCalculator {
    public int calculate(Stack<Card> cards) {
        int score = 0;
        float factor = 1;
        Card next,last = null;

        // Go through the cards.
        while(!cards.empty()) {
            next = cards.pop();
            // Check that the cards are the same in a row.
            if(!next.equals(last)) {
                break;
            }

            last = next;
            score += next.getValue();
            score *= factor;
            factor += 0.7;
        }

        if(score == 0) {
            score = 1;
        }
        return score;
    }
}
