package game;

/**
 * Created by Tom on 13/11/2016.
 */
public class GUINode {

    /**
     * The nest GUINode in line.
     */
    GUINode _next;

    /**
     * The games card pack
     */
    CardPack _pack;

    /**
     * The chosen card
     */
    Card _chosen;

    /**
     * The last displayed card
     */
    Card _last = null;

    /**
     * The number of cycles left to display
     */
    int _cycles;

    /**
     * If true, the GUINode starts the process of stopping
     */
    boolean stop;

    /**
     * Create a new instance of a GUI Node object.
     * @param pack - The game's pack of cards
     * @param chosen - The chosen card of the slot which this node represents.
     * @param cycles - The number of cycles that this node should display a random number before it <b>starts</b>to stops.
     */
    public GUINode(CardPack pack, Card chosen, int cycles, GUINode next) {
        this._next = next;
        this._cycles = cycles;
        this._chosen = chosen;
        this._pack = pack;
        this._last = chosen;
        this.stop = false;
    }

    /**
     * Signal the first node of the list to start.
     * @param cycles - Number of cycles to be added to the current cycles value.
     *                 This allows for the graphic display to create a short delay between
     *                 starting the graphics, and <b>starting</b> to stop.
     */
    public void start(int cycles) {
        this._cycles += cycles;
        this.stop = true;
    }

    /**
     * Display a signal random card.
     */
    protected void displayRandom() {
        Card random = this._pack.getRandom();
        while(random.equals(this._last)) {
            random = this._pack.getRandom();
        }
        this._last = random;
        System.out.print(random._face);
        if(this.stop) {
            this._cycles--;
        }
    }

    /**
     * Signal stop
     */
    public void Stop() {
        this.stop = true;
    }

    /**
     * Display the node and the next node
     * @return The aggregated number of cycles left for the nodes
     */
    public int display() {
        if(this._cycles == 0) {
            System.out.print(this._chosen._face);
        } else {
            this.displayRandom();
        }
        int cycles = this._cycles;
        if(this._next != null) {
            if(cycles == 0) {
                this._next.Stop();
            }

            // Display delimiter
            System.out.print('-');
            cycles += this._next.display();
        }
        return cycles;
    }
}
