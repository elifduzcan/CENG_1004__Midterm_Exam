package model;

public class Knight extends Piece {
    public Knight(int color) {
        super(color);
    }

    @Override
    public String toString() {
        if (getColor() == 1) {
            return "N";
        } else {
            return "n";
        }
    }
}
