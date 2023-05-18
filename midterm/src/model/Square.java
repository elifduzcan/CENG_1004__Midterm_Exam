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
        if(column== getColumn()){
            return true;
        }else{
            return false;
        }

    }


}
