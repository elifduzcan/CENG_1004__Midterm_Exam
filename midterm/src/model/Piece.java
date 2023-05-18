package model;

public class Piece {
    private int color;
    protected Square location;
    protected boolean initialLocation;

    public Piece(int color, Square location) {
        this.color = color;
        this.location = location;
        this.initialLocation = true;
    }

    public int getColor() {
        return color;
    }

    public Square getLocation() {
        return location;
    }

    public boolean canMove(String destination) {
        return true;
    }

    public void move(String destination) {
    }

    @Override
    public String toString() {
        return "";
    }

    public void setLocation(Square square) {
        this.location = square;
    }

    public boolean isInitialLocation() {
        return initialLocation;
    }

    public void setInitialLocation(boolean initialLocation) {
        this.initialLocation = initialLocation;
    }

}
