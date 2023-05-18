package model;

public class ChessBoard {
    private int player; // white 1, black 0
    private Square[] squares;

    public ChessBoard() {
        squares = new Square[64];
        int index = 0;
        for (int column = 1; column <= 8; column++) {
            for (int row = 1; row <= 8; row++) {
                squares[index] = new Square(column, row, null);
                index++;
            }
        }
    }

//    public boolean isWhitePlaying() {
//        if (player == 1) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean isGameEnded() {
        return true;
    }

    public void initialize() {

    }

    public Piece getPieceFromGivenSquare(int x, int y) {
        for (Square square : squares) {
            if (square.column == x && square.row == y) {
                return square.piece;
            }
        }
        return null;
    }

    public Piece updateSpecificSquare(int x, int y, Piece updatedPiece) {
        for (Square square : squares) {
            if (square.column == x && square.row == y) {
                square.piece = updatedPiece;

                return updatedPiece;
            }
        }
        return updatedPiece;
    }





}

