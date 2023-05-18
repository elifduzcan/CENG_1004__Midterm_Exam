package model;

public class Rook extends Piece {
    public Rook(int color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "R" : "r";
    }
}