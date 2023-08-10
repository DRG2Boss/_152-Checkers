import javax.swing.*;

public class normalPiece extends Piece {
    public normalPiece(boolean bIsRed) {
        pieceType = "normal";
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
        int dY = (endY - startY);
        if(isRed) {
            return (dX == 1 && dY == -1);
        }
        else {
            return (dX == 1 && dY == 1);
        }
    }
}
