package Assignment_02.conway;

import Assignment_02.conway.game.GameOfLife;
import Assignment_02.conway.gui.ConwayGUI;

public class Main {
    public static void main(String[] args) {
        GameOfLife gameoflife = new GameOfLife(15);
        int[][] board = gameoflife.board;
        board[1][2] = 1;
        board[2][3] = 1;
        board[3][1] = 1;
        board[3][2] = 1;
        board[3][3] = 1;

        new ConwayGUI(gameoflife);
    }
}
