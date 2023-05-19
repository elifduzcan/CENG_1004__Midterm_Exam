package model;

public class Knight extends Piece {
    public Knight(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) {
        int columnDistance = targetSquare.getColumn() - this.getColumn();
        int rowDistance = targetSquare.getRow() - this.getRow();
        Piece pieceInTargetSquare = targetSquare.piece;

        if (Math.abs(columnDistance) == 1 && Math.abs(rowDistance) == 2) {
            if (pieceInTargetSquare == null) {
                return true;
            } else return pieceInTargetSquare.getColor() != getColor();
        } else {
            return false;
        }

    }

    @Override
    public void move(String destination) {
        // TODO: 19.05.2023 fonksiyonu yaz

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
