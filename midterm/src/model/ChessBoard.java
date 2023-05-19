package model;

public class ChessBoard {
    // TODO: 19.05.2023 aşağıdaki değişken whitePlaying ismiyle olmalı
    private Boolean whitePlaying;
    private Square[] squares;

    public ChessBoard() {
        //creating and filling square list
        squares = new Square[64];
        int index = 0;
        for (int column = 1; column <= 8; column++) {
            for (int row = 1; row <= 8; row++) {
                squares[index] = new Square(column, row, null);
                index++;
            }
        }
    }

    public void initialize() {  //sets the positions of the pieces on the board
        // region initialize white pieces
        changePieceInSquare(1, 1, new Rook(1, 1, 1));
        changePieceInSquare(1, 2, new Knight(1, 1, 2));
        changePieceInSquare(1, 3, new Bishop(1, 1, 3));
        changePieceInSquare(1, 4, new Queen(1, 1, 4));
        changePieceInSquare(1, 5, new King(1, 1, 5));
        changePieceInSquare(1, 6, new Bishop(1, 1, 6));
        changePieceInSquare(1, 7, new Knight(1, 1, 7));
        changePieceInSquare(1, 8, new Rook(1, 1, 8));
        for (int column = 1; column <= 8; column++) {
            int row = 2;
            changePieceInSquare(row, column, new Pawn(1, 2, column));
        }

        // endregion

        //region initialize black pieces

        for (int column = 1; column <= 8; column++) {
            int row = 7;
            changePieceInSquare(row, column, new Pawn(0, 7, column));
        }
        changePieceInSquare(8, 1, new Rook(0, 8, 1));
        changePieceInSquare(8, 2, new Knight(0, 8, 2));
        changePieceInSquare(8, 3, new Bishop(0, 8, 3));
        changePieceInSquare(8, 4, new Queen(0, 8, 4));
        changePieceInSquare(8, 5, new King(0, 8, 5));
        changePieceInSquare(8, 6, new Bishop(0, 8, 6));
        changePieceInSquare(8, 7, new Knight(0, 8, 7));
        changePieceInSquare(8, 8, new Rook(0, 8, 8));
        // endregion
    }

    public boolean isGameEnded() {  // checks whether oppponent's pieces all gone
        int opponentColor = (whitePlaying ? 0 : 1);

        for (int i = 0; i < squares.length; i++) {
            Piece piece = getPieceFromGivenSquare(squares[i].getColumn(), squares[i].getRow());
            if (piece != null && piece.getColor() == opponentColor) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("    A   B   C   D   E   F   G   H");
        System.out.println("  ---------------------------------");
        for (int row = 8; row >= 1; row--) {
            System.out.print(row + " | ");
            for (int column = 1; column <= 8; column++) {
                Piece piece = this.getPieceFromGivenSquare(column, row);
                if (piece != null) {
                    System.out.print(piece + " | ");
                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println(row);
            System.out.println("  ---------------------------------");
        }
        System.out.println("    A   B   C   D   E   F   G   H");
    }

    public Piece getPieceFromGivenSquare(int column, int row) {
        for (Square square : squares) {
            if (square.getColumn() == column && square.getRow() == row) {
                return square.piece;
            }
        }
        return null;
    }

    public void changePieceInSquare(int column, int row, Piece updatedPiece) {
        for (Square square : squares) {
            if (square.getColumn() == column && square.getRow() == row) {
                square.piece = updatedPiece;
            }
        }
    }

    public boolean isWhitePlaying() {
        if (whitePlaying) {
            return true;
        } else {
            return false;
        }
    }

    public Square castStringToSquare(String location) {
        int locationCol = convertCharToInteger(location.charAt(0));
        int locationRow = Integer.parseInt(location.substring(1, 2));
        for (Square square : squares) {
            if (square.getColumn() == locationCol && square.getRow() == locationRow) {
                return square;
            }
        }
        return null;
    }

    public static Integer convertCharToInteger(Character c) {
        // TODO: 19.05.2023  charlar lowercase yapılacak
        int col = 0;
        if (c == 'a') {
            col = 1;
        } else if (c == 'b') {
            col = 2;
        } else if (c == 'c') {
            col = 3;
        } else if (c == 'd') {
            col = 4;
        } else if (c == 'e') {
            col = 5;
        } else if (c == 'f') {
            col = 6;
        } else if (c == 'g') {
            col = 7;
        } else if (c == 'h') {
            col = 8;
        } else {
            col = 0;
        }
        return col;
    }
}

