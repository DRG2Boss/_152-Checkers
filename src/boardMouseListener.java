// This object will listen for mouse presses and releases within "board" and respond to them.

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Must implement MouseListener

public class boardMouseListener implements MouseListener {
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    String invalid = "Invalid move - ";

    public void mousePressed(MouseEvent e) {
        // Track the coordinates anywhere the user mouse presses within the board.
        // These coordinates need to be divided by 44 to fit within the position array index correctly.
        int possibleStartX = e.getX()/44;
        int possibleStartY = e.getY()/44;

        if (possibleStartX < 0 || possibleStartX > 7 || possibleStartY < 0 || possibleStartY > 7) {
            System.out.println(invalid+"cannot select something outside of the board.");
            return;
        }
        if (Checkers.position[possibleStartX][possibleStartY] == null) {
            System.out.println(invalid+"cannot select an empty tile.");
        }

        // If the tile selected contains a piece, track that tile using variables startX and startY.
       else {
            startX = possibleStartX;
            startY = possibleStartY;
            System.out.println("Start: "+startX+","+startY);
        }
    }
    public void mouseReleased(MouseEvent e) {
        // Do the same for releasing the mouse click.
        int possibleEndX = e.getX()/44;
        int possibleEndY = e.getY()/44;

        // If area selected is out of bounds OR the same tile as the starting piece.
        if (possibleEndX > 7 || possibleEndY > 7 || possibleEndX < 0 || possibleEndY < 0) {
            System.out.println(invalid+"cannot move piece outside of the board.");
            return;
        }
        // If area selected is the same tile as the starting piece.
        else if (startX == possibleEndX && startY == possibleEndY) {
            System.out.println(invalid+"must move piece.");
            return;
        }
        // If you attempt to move a black piece.
        else if (!Checkers.position[startX][startY].isRed) {
            System.out.println(invalid+"you only control the red pieces.");
            return;
        }
        // If you attempt to move a checker on top of another checker on your team.
        else if (Checkers.position[possibleEndX][possibleEndY] != null && Checkers.position[possibleEndX][possibleEndY].isRed) {
            System.out.println(invalid+"cannot move piece on top of another piece of your team.");
            return;
            }

        // If the tile selected is a normal move for that pieceType.
        if (Checkers.position[startX][startY].canMove(startX, startY, possibleEndX, possibleEndY)) {
            // Track this tile using endX and endY, and print coordinates the piece moved to.
            System.out.println("End: "+endX+ ","+endY);

            // Reassign that piece's starting tile to the one we released the mouse over.
            Checkers.position[endX][endY] = Checkers.position[startX][startY];
            // Make the starting position empty.
            Checkers.position[startX][startY] = null;

            // If a checker reaches the opposite side of the board, turn that piece into a kingPiece.
            if (endY == 0) {
                Checkers.position[endX][endY] = new kingPiece(true);
            }
        }
        else {
            System.out.println(invalid+"the selected piece cannot move there.");
            return;
        }
        // Now redraw the board to see the new position updated graphically.
        Checkers.board.repaint();

        // Computer player setup.
        while(true) {
            // Assign startX, startY, endX, and endY values using Math.random().
            Checkers.player.possibleStartX = (int) (Math.random() * 8);
            Checkers.player.possibleStartY = (int) (Math.random() * 8);
            Checkers.player.possibleEndX = (int) (Math.random() * 8);
            Checkers.player.possibleEndY = (int) (Math.random() * 8);

            // If the computer selects a null space, call continue to try again.
            if (Checkers.position[Checkers.player.possibleStartX][Checkers.player.possibleStartY] == null) {
                continue;
            }
            // If the piece selected is red, call continue to try again
            if (Checkers.position[Checkers.player.possibleStartX][Checkers.player.possibleStartY].isRed) {
                continue;
            }
            // If the movement desired is to the same tile, call continue to try again.
            if (Checkers.player.possibleStartX == Checkers.player.possibleEndX && Checkers.player.possibleStartY == Checkers.player.possibleEndY) {
                continue;
            }
            // If the movement desired is to a position where a piece of the same team exists.
            if (Checkers.position[Checkers.player.possibleEndX][Checkers.player.possibleEndY] != null && !Checkers.position[Checkers.player.possibleEndX][Checkers.player.possibleEndY].isRed) {
                continue;
            }
            // If the movement desired is not allowed for that specific pieceType, call continue to try again.
            if (Checkers.position[Checkers.player.possibleStartX][Checkers.player.possibleStartY].canMove(Checkers.player.possibleStartX, Checkers.player.possibleStartY, Checkers.player.possibleEndX, Checkers.player.possibleEndY)) {
                // Add one to computer's number of moves.
                Checkers.player.playerNumberOfMoves++;
                // Reassign that pieces starting tile to the one we released the mouse over.
                Checkers.position[endX][endY] = Checkers.position[startX][startY];
                // Make the starting position empty.
                Checkers.position[startX][startY] = null;

                // If the checker reaches opposite side of the board, turn that piece into a kingPiece.
                if (endY == 7) {
                    Checkers.position[endX][endY] = new kingPiece(false);
                }
                Checkers.board.repaint();
                break;
            }
        }
    }
    // Don't need these, just need to define them as an implementation action requirement.
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}