package model;

public class ChessBoard {
    private int currentColor;
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

/*    public boolean isWhitePlaying() {
        if (player == 1) {
            return true;
        } else {
            return false;
        }
    }*/

    public boolean isGameEnded() {
        return isAllOpponentPiecesCaptured();
    }

    private boolean isAllOpponentPiecesCaptured() {
        int opponentColor = (currentColor == 1) ? 0 : 1;
        for (Square square : squares) {
            Piece piece = getPieceFromGivenSquare(square.column, square.row);
            if (piece != null && piece.getColor() == opponentColor) {
                return false;
            }
        }
        return true;
    }


    public void initialize() {  //sets the positions of the pieces on the board
        //region placing whites aka 1
        updateSpecificSquare(1, 1, new Rook(1));
        updateSpecificSquare(1, 2, new Knight(1));
        updateSpecificSquare(1, 3, new Bishop(1));
        updateSpecificSquare(1, 4, new Queen(1));
        updateSpecificSquare(1, 5, new King(1));
        updateSpecificSquare(1, 6, new Bishop(1));
        updateSpecificSquare(1, 7, new Knight(1));
        updateSpecificSquare(1, 8, new Rook(1));
        for (int column = 1; column <= 8; column++) {
            int row = 2;
            updateSpecificSquare(row, column, new Pawn(1));
        }
        //endregion

        //region placing blacks aka 0
        for (int column = 1; column <= 8; column++) {
            int row = 7;
            updateSpecificSquare(row, column, new Pawn(0)); // 0 black
        }
        updateSpecificSquare(8, 1, new Rook(0));
        updateSpecificSquare(8, 2, new Knight(0));
        updateSpecificSquare(8, 3, new Bishop(0));
        updateSpecificSquare(8, 4, new Queen(0));
        updateSpecificSquare(8, 5, new King(0));
        updateSpecificSquare(8, 6, new Bishop(0));
        updateSpecificSquare(8, 7, new Knight(0));
        updateSpecificSquare(8, 8, new Rook(0));
        //endregion
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

