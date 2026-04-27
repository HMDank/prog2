package conway.game;

import conway.component.CellType;;

public class GameOfLife {
    private CellType[][] generation;
    private long iteration;

    public GameOfLife(int size) {
        this.generation = new CellType[size][size];
        iteration = 0L;

        // init of the grid
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < generation[i].length; j++) {
                generation[i][j] = CellType.DEAD;
            }
        }
    }

    public int countLivingNeighbors(int x, int y) {
        int count = 0;
        for (int index_x = -1; index_x <= 1; index_x++) {
            for (int index_y = -1; index_y <= 1; index_y++) {
                if (index_x == 0 && index_y == 0)
                    continue;
                if (generation[(x + index_x + generation.length)
                        % generation.length][(y + index_y + generation[0].length)
                                % generation[0].length] == CellType.LIVING)
                    count++;
            }
        }
        return count;
    }

    public void calculateNextGeneration() {
        iteration++;
        CellType[][] nextGeneration = new CellType[generation.length][generation[0].length];

        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < generation[i].length; j++) {
                int livingNeighbours = countLivingNeighbors(i, j);

                if (generation[i][j] == CellType.DEAD && livingNeighbours == 3) {
                    // 3 living neighbours and dead cell
                    nextGeneration[i][j] = CellType.LIVING;
                } else if (generation[i][j] == CellType.LIVING && (livingNeighbours < 2 || livingNeighbours > 3)) {
                    // living cell dies
                    nextGeneration[i][j] = CellType.DEAD;
                } else {
                    // case cell is dead and not exactly 3 living neighbours -> cell dead in next
                    // step
                    // case cell lives but has 2 or 3 living neighbours -> cell does not die
                    nextGeneration[i][j] = generation[i][j];
                }

            }
        }

        generation = nextGeneration;
    }

    public CellType[][] getGeneration() {
        return this.generation;
    }

    public Long getIteration() {
        return iteration;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < generation[i].length; j++) {
                result += generation[i][j];
                if (j + 1 != generation.length)
                    result += " ";
            }
            result += "\n";
        }
        return result;
    }
}