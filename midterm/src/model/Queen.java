package model;

public class Queen extends Piece {
    public Queen(int color) {
        super(color);
    }

    @Override
    public String toString() {
        return getColor() == ChessBoard.WHITE ? "Q" : "q";
    }
}