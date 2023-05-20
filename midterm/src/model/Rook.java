package model;

public class Rook extends Piece {
    public Rook(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) {
        int targetColumn = targetSquare.getColumn();
        int targetRow = targetSquare.getRow();

        // Aynı sütunda hareket edecekse
        if (targetColumn == this.getColumn()) {
            int startRow = Math.min(this.getRow(), targetRow);
            int endRow = Math.max(this.getRow(), targetRow) - 1;

            for (int row = startRow + 1; row < endRow; row++) {
                Square square = getSquareAt(targetColumn, row);
                if (square.piece != null) {
                    return false; // Yol üzerinde bir taş var
                }
            }
        }
        // Aynı satırda hareket edecekse
        else if (targetRow == this.getRow()) {
            int startColumn = Math.min(this.getColumn(), targetColumn);
            int endColumn = Math.max(this.getColumn(), targetColumn) - 1;

            for (int column = startColumn + 1; column < endColumn; column++) {
                Square square = getSquareAt(column, targetRow);
                if (square.piece != null) {
                    return false; // Yol üzerinde bir taş var
                }
            }
        }
        // Geçersiz hareket
        else {
            return false;
        }

        // Hedef kare boş ise veya rakip bir taş varsa hareket geçerli
        Piece pieceInTargetSquare = targetSquare.piece;
        return pieceInTargetSquare == null || pieceInTargetSquare.getColor() != getColor();
    }

    private Square getSquareAt(int column, int row) {
        return new Square(column, row, new Rook(column, row, getColor()));
    }


    @Override
    public String toString() {
        if (getColor() == 1) {
            return "R";
        } else {
            return "r";
        }
    }
}