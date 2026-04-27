package Assignment_03.JumpNRun;

/**
 * Renders and runs a simple side-scrolling Jump'n'Run simulation.
 *
 * @author @HMDank
 * @version 2026 April 27
 */
public class GameView {
    private GameObject[][] game;
    private int width = 20;
    private int height = 3;
    private NPC npc;

    public GameView() {
        this.game = new GameObject[height][width];
        this.npc = new NPC();
        initializeGame();
    }

    /**
     * Initializes the game board with ground, lava tiles, air obstacles, and a goal
     * tile.
     */
    private void initializeGame() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                game[y][x] = GameObject.EMPTY;
            }
        }
        game[2][0] = GameObject.GROUND;
        for (int index = 1; index < width; index++) {
            game[2][index] = GameObject.GROUND;
            if (index % 4 == 0) {
                game[2][index] = GameObject.LAVA;
                game[0][index + 2] = GameObject.AIROBSTACLE;
                game[0][index - 2] = GameObject.AIROBSTACLE;
            }
        }
        game[2][19] = GameObject.GOAL;
    }

    /**
     * Builds a textual representation of the current game state.
     *
     * @return the current board as a multi-line string
     */
    public String str() {
        StringBuilder stringbuilder = new StringBuilder();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col == npc.getXCoordinate()) {
                    if (row == 0 && !npc.isCrouching())
                        stringbuilder.append('P');
                    else if (row == 1)
                        stringbuilder.append('P');
                    else
                        stringbuilder.append(game[row][col].getSymbol());
                } else {
                    stringbuilder.append(game[row][col].getSymbol());
                }
            }
            stringbuilder.append("\n");
        }
        return stringbuilder.toString();
    }

    /**
     * Runs the game loop until the NPC reaches lava, reaches the goal, or leaves
     * the board.
     */
    public void play() {
        while (true) {
            System.out.println(str());
            int coordinate = npc.getXCoordinate();

            if (coordinate >= width || game[2][coordinate] == GameObject.LAVA
                    || game[2][coordinate] == GameObject.GOAL) {
                System.out.println("gg");
                break;
            }

            if (coordinate + 1 < width && game[0][coordinate + 1] == GameObject.AIROBSTACLE) {
                npc.crouch();
            }
            if (coordinate + 1 < width && game[2][coordinate + 1] == GameObject.LAVA) {
                if (npc.isCrouching()) {
                    npc.standUp();
                } else
                    npc.dashRight();
                continue;
            } else {
                npc.walkRight();
            }
        }
    }

    public static void main(String[] args) {
        GameView game = new GameView();
        game.play();
    }
}
