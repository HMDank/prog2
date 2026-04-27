package Assignment_03.JumpNRun;

/**
 * Represents the player character and its movement state.
 *
 * @author @HMDank
 * @version 2026 April 27
 */
public class NPC {
    private int xCoordinate;
    private boolean isCrouching;

    public NPC() {
        this.xCoordinate = 0;
        this.isCrouching = false;
    }

    /**
     * Sets the NPC to a standing position.
     */
    public void standUp() {
        this.isCrouching = false;
    }

    /**
     * Sets the NPC to a crouching position.
     */
    public void crouch() {
        this.isCrouching = true;
    }

    /**
     * Moves the NPC one tile to the right.
     */
    public void walkRight() {
        this.xCoordinate++;
    }

    /**
     * Moves the NPC two tiles to the right when it is not crouching.
     */
    public void dashRight() {
        if (!this.isCrouching)
            this.xCoordinate += 2;
    }

    /**
     * Returns the horizontal position of the NPC.
     *
     * @return the x-coordinate of the NPC
     */
    public int getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Indicates whether the NPC is currently crouching.
     *
     * @return true if crouching, otherwise false
     */
    public boolean isCrouching() {
        return isCrouching;
    }
}
