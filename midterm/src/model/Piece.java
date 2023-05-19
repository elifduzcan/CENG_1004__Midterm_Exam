package model;

public class Piece {
    private int color;

    public Piece(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public boolean canMove(String destination){
        return true;
    }

    public void move(String destination){
    }

    @Override
    public String toString() {
        return "";
    }
}
