package model;

public class Queen extends Piece {
    public Queen(int color) {
        super(color);
    }

    @Override
    public String toString() {
        if (getColor() == 1) {
            return "Q";
        } else {
            return "q";
        }
    }
}