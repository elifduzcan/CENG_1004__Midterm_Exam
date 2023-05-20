package model;

public class Bishop extends Piece {

    public Bishop(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) { // taşların üzerinden atlayamama işinin kontrol edilmesi gerek
        int targetColumn = targetSquare.getColumn();
        int targetRow = targetSquare.getRow();
        int columnDistance = targetSquare.getColumn() - this.getColumn();
        int rowDistance = targetSquare.getRow() - this.getRow();
        Piece pieceInTargetSquare = targetSquare.piece;

        if (Math.abs(columnDistance) == Math.abs(rowDistance)) {
            int startRow = Math.min(this.getRow(), targetRow);
            int endRow = Math.max(this.getRow(), targetRow) - 1;

            for (int row = startRow + 1; row < endRow; row++) {
                Square square = getSquareAt(targetColumn, row);
                if (square.piece != null) {
                    return false; // Yol üzerinde bir taş var
                }
            }
            if (pieceInTargetSquare == null) {
                return true;
            } else return pieceInTargetSquare.getColor() != getColor();
        } else {
            return false;
        }

    }

    private Square getSquareAt(int column, int row) {
        return new Square(column, row, new Bishop(column, row, getColor()));
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