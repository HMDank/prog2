package conway;

import conway.gui.ConwayGUI;
import conway.component.CellType;
import conway.game.GameOfLife;

public class Main {
    private GameOfLife gameOfLife = new GameOfLife(15);

    public void setup(int[] x, int[] y) {
        CellType[][] generation = this.gameOfLife.getGeneration();

        for (int index = 0; index < x.length; index++) {
            int row = x[index];
            int col = y[index];
            if (row >= 0 && row < generation.length && col >= 0 && col < generation[row].length) {
                generation[row][col] = CellType.LIVING;
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] x = { 1, 2, 3, 3, 3 };
        int[] y = { 2, 3, 1, 2, 3 };
        main.setup(x, y);
        // Start configuration

        // Optional graphical interface
        ConwayGUI gui = new ConwayGUI(main.gameOfLife);

        /**
         * for (int i = 0; i < 10; i++) {
         * gameOfLife.calculateNextGeneration();
         * System.out.println("Iteration: " + gameOfLife.getIteration());
         * System.out.println(gameOfLife);
         * System.out.println("-----------------------------------------");
         * }
         */
    }

}
