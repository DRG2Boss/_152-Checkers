// Main class for Checkers game
// Hold the storage for the program
// Set up storage and graphics

import javax.swing.*;

public class Checkers {

    // Dimension of full board and each tile.
    public static final int BOARD_SIZE = 352, TILE_SIZE = BOARD_SIZE / 8;

    // Initialize needed variables from other classes.
    public static Player player = new Player();
    public static boardComponent board;
    public static Piece[][] position = new Piece[8][8];

    public static void main(String[] args) {
        // Draw pieces in appropriate starting positions.
        // Black Pieces
        for(int y = 0; y <= 1; y++) {
            for(int x = 0; x < 8; x++) {
                position[x][y] = new normalPiece(false);
            }
        }
        // Red Pieces
        for(int y = 6; y <= 7; y++) {
            for (int x = 0; x < 8; x++) {
                position[x][y] = new normalPiece(true);
            }
        }

        // Basic window setup.
        JFrame myWindow = new JFrame("Checkers");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(BOARD_SIZE+16, BOARD_SIZE+39);

        // Create a graphical object that will represent the board using earlier defined variable.
        board = new boardComponent();

        // Now add board object to the window.
        // This will take up the entire window, no Panels needed.
        myWindow.add(board);

        // Make an object that operates on mouse presses and releases.
        boardMouseListener boardMouse = new boardMouseListener();
        board.addMouseListener(boardMouse);

        // Last thing to run, make myWindow visible.
        myWindow.setVisible(true);
    }
}