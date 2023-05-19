package model;

public class Bishop extends Piece{
    public Bishop(int color) {
        super(color);
    }

    @Override
    public String toString() {
        if (getColor() == 1) {
            return "B";
        } else {
            return "b";
        }
    }
}