package model;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(int xDistance, int yDistance){
        this.x+= xDistance;
        this.y+= yDistance;
    }

    public double distanceFromOrigin(){
        return Math.sqrt((this.x*this.x)+(this.y*this.y));

    }

    


}
