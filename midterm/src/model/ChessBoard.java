package model;

public class ChessBoard {
    // TODO: 19.05.2023 aşağıdaki değişken whitePlaying ismiyle olmalı
    private Boolean whitePlaying = true;
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
        changePieceInSquare(2, 1, new Knight(1, 2, 1));
        changePieceInSquare(3, 1, new Bishop(1, 3, 1));
        changePieceInSquare(4, 1, new Queen(1, 4, 1));
        changePieceInSquare(5, 1, new King(1, 5, 1));
        changePieceInSquare(6, 1, new Bishop(1, 6, 1));
        changePieceInSquare(7, 1, new Knight(1, 7, 1));
        changePieceInSquare(8, 1, new Rook(1, 8, 1));
        for (int column = 1; column <= 8; column++) {
            int row = 2;
            changePieceInSquare(column, row, new Pawn(1, column, 2));
        }

        // endregion

        //region initialize black pieces

        for (int column = 1; column <= 8; column++) {
            int row = 7;
            changePieceInSquare(column, row, new Pawn(0, column, 7));
        }
        changePieceInSquare(1, 8, new Rook(0, 1, 8));
        changePieceInSquare(2, 8, new Knight(0, 2, 8));
        changePieceInSquare(3, 8, new Bishop(0, 3, 8));
        changePieceInSquare(4, 8, new Queen(0, 4, 8));
        changePieceInSquare(5, 8, new King(0, 5, 8));
        changePieceInSquare(6, 8, new Bishop(0, 6, 8));
        changePieceInSquare(7, 8, new Knight(0, 7, 8));
        changePieceInSquare(8, 8, new Rook(0, 8, 8));
        // endregion
    }

    public boolean isGameEnded() {  // checks whether oppponent's pieces all gone
        int opponentColor = (whitePlaying ? 0 : 1);

        for (Square square : squares) {
            Piece piece = getPieceFromGivenSquare(square.getColumn(), square.getRow());
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
        int col;
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

    public boolean isWhitePlaying() {
        return whitePlaying;
    }

    public boolean setWhitePlaying() {
        if (whitePlaying) {
            return whitePlaying = false;
        } else return whitePlaying = true;
    }


}

