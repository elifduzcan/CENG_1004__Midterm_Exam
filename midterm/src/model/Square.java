package model;

public class Square {
    private int column;
    private int row;

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
        } else {
            return color == 0 && getRow() == 1;
        }
    }

    public boolean isEmpty() {  // checks if the square is empty
        return piece == null;
    }

    public boolean isAtSameColumn(Square s) {  // checks if the square is in the same column with the other square
        return s.getColumn() == column;
    }

    public void putNewQueen(int color) {
        Queen newQueen = new Queen(color, getColumn(), getRow());

        // Yeni vezirin konumunu ayarla
        newQueen.setRow(this.getRow());
        newQueen.setColumn(this.getColumn());

        // Eski piyonu tahtadan kaldır
        this.setPiece(null);

        // Yeni veziri tahtaya yerleştir
        this.setPiece(newQueen);

    }

    public void setPiece(Piece piece1) {
        this.piece = piece1;
    }
}
