package model;

public class Bishop extends Piece{
    public Bishop(int color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "B" : "b";
    }
}