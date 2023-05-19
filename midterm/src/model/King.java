package model;

public class King extends Piece {
    public King(int color) {
        super(color);
    }

    @Override
    public String toString() {
        if (getColor() == 1) {
            return "K";
        } else {
            return "k";
        }
    }
}