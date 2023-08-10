import javax.swing.*;

public class kingPiece extends Piece {
    public kingPiece(boolean bIsRed) {
        pieceType = "king";
        isRed = bIsRed;
        if (isRed) {
            checkersPiece = new ImageIcon("w"+pieceType.toLowerCase()+".gif");
        }
        else {
            checkersPiece = new ImageIcon("b"+pieceType.toLowerCase()+".gif");
        }
    }
    public boolean canMove(int startX, int startY, int endX, int endY) {
        int dX = Math.abs(endX - startX);
        int dY = Math.abs(endY - startY);

        return (dX == 1 && dY == 1);
    }
}
