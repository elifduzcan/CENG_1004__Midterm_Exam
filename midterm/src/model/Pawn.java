package model;

public class Pawn extends Piece {
    public Pawn(int color) {
        super(color);
    }

    @Override
    public boolean canMove(String destination) {
return true;
    }

    @Override
    public String toString() {
        if (getColor() == 1) {
            return "P";
        } else {
            return "p";
        }
    }
}



