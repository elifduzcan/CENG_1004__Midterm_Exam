package model;

public class Rook extends Piece {
    public Rook(int color) {
        super(color);
    }

    @Override
    public String toString() {
        if (getColor() == 1) {
            return "R";
        } else {
            return "r";
        }
    }
}