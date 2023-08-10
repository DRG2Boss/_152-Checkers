// This creates a big graphical object I can add to the window.
// This object will create a chess board and fill it with the defined chest pieces.

import javax.swing.*;
import java.awt.*;

public class boardComponent extends JComponent {
    public void paintComponent(Graphics g) {
        // Nested for loop to track x and y position.
        for(int y = 0; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                // If both x AND y are even, OR x AND y are odd, paint the lighter rectangle.
                if((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(x * Checkers.TILE_SIZE, y * Checkers.TILE_SIZE, Checkers.TILE_SIZE, Checkers.TILE_SIZE);
                }
                // Otherwise, paint the darker rectangle.
                else {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * Checkers.TILE_SIZE, y * Checkers.TILE_SIZE, Checkers.TILE_SIZE, Checkers.TILE_SIZE);
                }
                // If the position within the array is NOT null, run method drawPiece within the Piece class.
                if(Checkers.position[x][y] != null) {
                    Checkers.position[x][y].drawPiece(x * 44, y * 44, g);
                }
            }
        }
    }
}