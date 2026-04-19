package Assignment_02.conway.game;

public class GameOfLife {
    public int[][] board;
    public long generation;

    public GameOfLife(int size) {
        this.board = new int[size][size];
        this.generation = 0;
    }

    public int countLivingNeighbors(int x, int y) {
        int count = 0;
        for (int index_x = -1; index_x <= 1; index_x++) {
            for (int index_y = -1; index_y <= 1; index_y++) {
                if (index_x == 0 && index_y == 0)
                    continue;
                if (x + index_x < 0)
                    continue;
                if (y + index_y < 0)
                    continue;
                if (x + index_x >= board.length)
                    continue;
                if (y + index_y >= board[0].length)
                    continue;
                if (board[x + index_x][y + index_y] == 1)
                    count++;
            }
        }
        return count;
    }

    public void calculateNextGeneration() {
        int size = board.length;
        int[][] next_board = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int LivingNeighbors = countLivingNeighbors(row, col);
                if ((LivingNeighbors == 2 && board[row][col] == 1) || LivingNeighbors == 3) {
                    next_board[row][col] = 1;
                } else
                    next_board[row][col] = 0;
            }
        }
        board = next_board;
    }

    public int[][] getGeneration() {
        return board;
    }

    public long getIteration() {
        return generation;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        for (int[] row : board) {
            for (int cell : row) {
                stringbuilder.append(cell);
            }
            stringbuilder.append("\n");
        }
        return stringbuilder.toString();
    }

}
