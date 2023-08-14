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
    public boolean canMove(int startX, int startY, int possibleEndX, int possibleEndY) {
        int dX = possibleEndX - startX;
        int dY = possibleEndY - startY;
        if(isRed) {
            // If you're jumping a piece to the left.
            if (dX == -1 && dY == -1 && Checkers.position[possibleEndX][possibleEndY] != null && !Checkers.position[possibleEndX][possibleEndY].isRed && Checkers.position[possibleEndX-1][possibleEndY-1] == null) {
                Checkers.position[possibleEndX][possibleEndY] = null;
                boardMouseListener.endX = possibleEndX - 1;
                boardMouseListener.endY = possibleEndY - 1;
                return true;
            }
            // If you're jumping a piece to the right.
            else if (dX == 1 && dY == -1 && Checkers.position[possibleEndX][possibleEndY] != null && !Checkers.position[possibleEndX][possibleEndY].isRed && Checkers.position[possibleEndX+1][possibleEndY-1] == null) {
                Checkers.position[possibleEndX][possibleEndY] = null;
                boardMouseListener.endX = possibleEndX + 1;
                boardMouseListener.endY = possibleEndY - 1;
                return true;
            }
            // Normal move.
            else {
                if(Checkers.position[possibleEndX][possibleEndY] != null) {
                    return false;
                }
                else {
                    boardMouseListener.endX = possibleEndX;
                    boardMouseListener.endY = possibleEndY;
                    return (Math.abs(dX) == 1 && dY == -1);
                }
            }
        }
        else {
            // If computer is jumping piece to the left.
            if (dX == -1 && dY == 1 && Checkers.position[possibleEndX][possibleEndY] != null && Checkers.position[possibleEndX][possibleEndY].isRed && Checkers.position[possibleEndX-1][possibleEndY+1] == null) {
                Checkers.position[possibleEndX][possibleEndY] = null;
                boardMouseListener.startX = startX;
                boardMouseListener.startY = startY;
                boardMouseListener.endX = possibleEndX - 1;
                boardMouseListener.endY = possibleEndY + 1;
                return true;
            }
            // If computer is jumping piece to the right.
            else if (dX == 1 && dY == 1 && Checkers.position[possibleEndX][possibleEndY] != null && Checkers.position[possibleEndX][possibleEndY].isRed && Checkers.position[possibleEndX+1][possibleEndY+1] == null) {
                Checkers.position[possibleEndX][possibleEndY] = null;
                boardMouseListener.startX = startX;
                boardMouseListener.startY = startY;
                boardMouseListener.endX = possibleEndX + 1;
                boardMouseListener.endY = possibleEndY + 1;
                return true;
            }
            // Normal computer move.
            else {
                if(Checkers.position[possibleEndX][possibleEndY] != null) {
                    return false;
                }
                else {
                    boardMouseListener.startX = startX;
                    boardMouseListener.startY = startY;
                    boardMouseListener.endX = possibleEndX;
                    boardMouseListener.endY = possibleEndY;
                    return (Math.abs(dX) == 1 && dY == 1);
                }
            }
        }
    }
}
