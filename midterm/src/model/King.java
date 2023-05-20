package model;

public class King extends Piece {
    public King(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) {
        int columnDistance = targetSquare.getColumn() - this.getColumn();
        int rowDistance = targetSquare.getRow() - this.getRow();
        Piece pieceInTargetSquare = targetSquare.piece;
        if ((Math.abs(columnDistance) == 1 && targetSquare.getRow() == getRow()) || (Math.abs(rowDistance) == 1 && targetSquare.getColumn() == this.getColumn()) || (Math.abs(columnDistance) == 1 && Math.abs(rowDistance) == 1)) {
            if (pieceInTargetSquare == null) {
                return true;
            } else return pieceInTargetSquare.getColor() != getColor();
        } else {
            return false;
        }

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