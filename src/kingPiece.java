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
    public boolean canMove(int startX, int startY, int possibleEndX, int possibleEndY) {
        int dX = possibleEndX - startX;
        int dY = possibleEndY - startY;
        boolean okNormalMove = Math.abs(dX) == 1 && Math.abs(dY) == 1;

        if(isRed) {
            // Possible jump move - You are moving diagonally in any direction and the normal end position contains a black piece.
            if (Math.abs(dX) == 1 && Math.abs(dY) == 1 && Checkers.position[possibleEndX][possibleEndY] != null && !Checkers.position[possibleEndX][possibleEndY].isRed) {
                // You are jumping top-left.
                if (dX == -1 && dY == -1 && Checkers.position[possibleEndX - 1][possibleEndY - 1] == null) {
                    // Null out opponent piece, assign final endX/endY to one more space in that diagonal direction. Return true (ok to do). 
                    Checkers.position[possibleEndX][possibleEndY] = null;
                    boardMouseListener.endX = possibleEndX - 1;
                    boardMouseListener.endY = possibleEndY - 1;
                    return true;
                }
                // You are jumping top-right.
                else if (dX == 1 && dY == -1 && Checkers.position[possibleEndX + 1][possibleEndY - 1] == null) {
                    Checkers.position[possibleEndX][possibleEndY] = null;
                    boardMouseListener.endX = possibleEndX + 1;
                    boardMouseListener.endY = possibleEndY - 1;
                    return true;
                }
                // You are jumping bottom-left.
                else if (dX == -1 && dY == 1 && Checkers.position[possibleEndX - 1][possibleEndY + 1] == null) {
                    Checkers.position[possibleEndX][possibleEndY] = null;
                    boardMouseListener.endX = possibleEndX - 1;
                    boardMouseListener.endY = possibleEndY + 1;
                    return true;
                }
                // You are jumping bottom-right.
                else if (dX == 1 && dY == 1 && Checkers.position[possibleEndX + 1][possibleEndY + 1] == null) {
                    Checkers.position[possibleEndX][possibleEndY] = null;
                    boardMouseListener.endX = possibleEndX + 1;
                    boardMouseListener.endY = possibleEndY + 1;
                    return true;
                }
            }
            // Otherwise, normal move if end position is null.
            else {
                if(Checkers.position[possibleEndX][possibleEndY] != null) {
                    return false;
                }
                else {
                    boardMouseListener.endX = possibleEndX;
                    boardMouseListener.endY = possibleEndY;
                    return okNormalMove;
                }
            }
        }
        else {
            // Possible jump move - Computer is moving diagonally in any direction and the normal end position contains a red piece.
            if (Math.abs(dX) == 1 && Math.abs(dY) == 1 && Checkers.position[possibleEndX][possibleEndY] != null && Checkers.position[possibleEndX][possibleEndY].isRed) {
                // Jumping top-left.
                if (dX == -1 && dY == -1 && Checkers.position[possibleEndX - 1][possibleEndY - 1] == null) {
                    // Null out opponent piece, assign final endX/endY to one more space in that diagonal direction. Return true (ok to do). 
                    Checkers.position[possibleEndX][possibleEndY] = null;
                    boardMouseListener.startX = startX;
                    boardMouseListener.startY = startY;
                    boardMouseListener.endX = possibleEndX - 1;
                    boardMouseListener.endY = possibleEndY - 1;
                    return true;
                }
                // Jumping top-right.
                else if (dX == 1 && dY == -1 && Checkers.position[possibleEndX + 1][possibleEndY - 1] == null) {
                    Checkers.position[possibleEndX][possibleEndY] = null;
                    boardMouseListener.startX = startX;
                    boardMouseListener.startY = startY;
                    boardMouseListener.endX = possibleEndX + 1;
                    boardMouseListener.endY = possibleEndY - 1;
                    return true;
                }
                // Jumping bottom-left.
                else if (dX == -1 && dY == 1 && Checkers.position[possibleEndX - 1][possibleEndY + 1] == null) {
                    Checkers.position[possibleEndX][possibleEndY] = null;
                    boardMouseListener.startX = startX;
                    boardMouseListener.startY = startY;
                    boardMouseListener.endX = possibleEndX - 1;
                    boardMouseListener.endY = possibleEndY + 1;
                    return true;
                }
                // Jumping bottom-right.
                else if (dX == 1 && dY == 1 && Checkers.position[possibleEndX + 1][possibleEndY + 1] == null) {
                    Checkers.position[possibleEndX][possibleEndY] = null;
                    boardMouseListener.startX = startX;
                    boardMouseListener.startY = startY;
                    boardMouseListener.endX = possibleEndX + 1;
                    boardMouseListener.endY = possibleEndY + 1;
                    return true;
                }
            }
            // Otherwise, normal move if end position is null.
            else {
                if(Checkers.position[possibleEndX][possibleEndY] != null) {
                    return false;
                }
                else {
                    boardMouseListener.endX = possibleEndX;
                    boardMouseListener.endY = possibleEndY;
                    return okNormalMove;
                }
            }
        }
        return false;
    }
}