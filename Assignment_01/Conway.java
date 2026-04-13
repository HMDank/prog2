package Assignment_01;

class Conway {
    public static void main(String[] args) {
        int[][] board;
        board = new int[10][10];
        board[1][2] = 1;
        board[2][3] = 1;
        board[3][1] = 1;
        board[3][2] = 1;
        board[3][3] = 1;
        printGeneration(board);
        for (int index = 0; index < 5; index++) {
            board = calculateNextGeneration(board);
            printGeneration(board);
        }
    }

    public static void printGeneration(int[][] board) {
        int width, height;
        width = height = board[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int countLivingNeighbors(int[][] board, int x, int y) {
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

    public static int[][] calculateNextGeneration(int[][] board) {
        int width, height;
        width = height = board[0].length;
        int[][] next_board;
        next_board = new int[10][10];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int LivingNeighbors = countLivingNeighbors(board, row, col);
                if ((LivingNeighbors == 2 && board[row][col] == 1) || LivingNeighbors == 3) {
                    next_board[row][col] = 1;
                } else
                    next_board[row][col] = 0;
            }
        }
        return next_board;
    }
}