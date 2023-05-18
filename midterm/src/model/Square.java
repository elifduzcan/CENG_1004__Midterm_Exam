package model;

public class Square {
    public int column;
    public int row;

    public Piece piece;

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

    public boolean isAtLastRow(int color) {
        return true;
    }

    public boolean isEmpty() {
        if (piece == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAtSameColumn(Square s) {
        return true;

    }


}
