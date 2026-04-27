package Assignment_03.JumpNRun;

/**
 * Enum of all tile/object types that can appear in the Jump'n'Run board.
 *
 * @author @HMDank
 * @version 2026 April 27
 */
public enum GameObject {

    GROUND('G'), LAVA('L'), AIROBSTACLE('O'), EMPTY(' '), GOAL('Z');

    private char symbol;

    GameObject(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the character used to render this game object.
     *
     * @return the display symbol of the object
     */
    public char getSymbol() {
        return symbol;
    }
}
