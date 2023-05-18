package model;

public class King extends Piece {
    public King(int color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "K" : "k";
    }
}