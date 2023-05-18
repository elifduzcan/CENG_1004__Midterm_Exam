package model;

public class Knight extends Piece {
    public Knight(int color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "N" : "n";
    }
}
