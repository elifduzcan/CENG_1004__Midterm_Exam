package model;

public abstract class Piece {
    private int color;
    private int column;
    private int row;

    public Piece(int color, int column, int row) {
        this.color = color;
        this.column = column;
        this.row = row;
    }

    public int getColor() {
        return color;
    }

    public int getColumn() {
        return column;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public abstract boolean canMove(Square targetSquare);

    @Override
    public String toString() {
        return "";
    }


}

