// This is an abstract object that tracks the actions every piece should take.

import javax.swing.*;
import java.awt.*;

public abstract class Piece {
    public ImageIcon checkersPiece;
    public boolean isRed;
    public String pieceType;

    public abstract boolean canMove(int startX, int startY, int endX, int endY);

    public void drawPiece(int x, int y, Graphics g) {
        g.drawImage(checkersPiece.getImage(), x, y, null);
    }
}