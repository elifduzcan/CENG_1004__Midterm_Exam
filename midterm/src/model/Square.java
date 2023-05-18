package model;

public class Square {
    public int column;
    public int row;

    public Piece piece;
    private ChessBoard board;


    public Square(int column, int row, Piece piece) {
        this.column = column;
        this.row = row;
        this.piece = piece;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isAtLastRow(int color) {  // checks if the pieces at the last row
        if (color == 1 && getRow() == 8) {
            return true;
        } else if (color == 0 && getRow() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (piece == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtSameColumn(Square s) {  // checks if the square is in the same column with the other one
        int column = s.getColumn();
        if (column == getColumn()) {
            return true;
        } else {
            return false;
        }

    }

    public void putNewQueen(int color) {
        Piece newQueen = new Queen(color);
        setPiece(newQueen);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        piece.setLocation(this);
    }

    public Piece getPiece() {
        return piece;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean isNeighborColumn(Square targetSquare) { // checks if a Square object is in the column adjacent to the other target Square object
        int targetColumn = targetSquare.getColumn();
        int currentColumn = this.getColumn();
        return Math.abs(targetColumn - currentColumn) == 1;
    }


    public int getRowDistance(Square targetLocation) {  // finds row distance with target square
        int currentRow = this.getRow();
        int targetRow = targetLocation.getRow();
        return targetRow - currentRow;
    }

}
