package model;

public class Queen extends Piece {
    public Queen(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) { //taşların üzerinden atlayamama işinin kontrol edilmesi gerek
        // TODO: 21.05.2023 Uçan taşları tekrar kontrol et
        int targetColumn = targetSquare.getColumn();
        int targetRow = targetSquare.getRow();
        int columnDistance = targetSquare.getColumn() - this.getColumn();
        int rowDistance = targetSquare.getRow() - this.getRow();
        Piece pieceInTargetSquare = targetSquare.piece;
        System.out.println("thiscol " + this.getColumn() + "thicrow" + this.getRow() + "col dis " + columnDistance + " row distance " + rowDistance);
        if ((columnDistance != 0 && rowDistance == 0) || (rowDistance != 0 && columnDistance == 0) || (Math.abs(columnDistance) == Math.abs(rowDistance))) {

            int startRow = Math.min(this.getRow(), targetRow);
            int endRow = Math.max(this.getRow(), targetRow) - 1;

            for (int row = startRow + 1; row < endRow; row++) {
                Square square = getSquareAt(targetColumn, row);
                if (square.piece != null) {
                    return false; // Yol üzerinde bir taş var
                }
            }
            if (targetSquare.isEmpty()) {
                setRow(targetSquare.getRow());
                setColumn(targetSquare.getColumn());
                return true;
            } else {
                if(pieceInTargetSquare.getColor()!= getColor()){
                    setRow(targetSquare.getRow());
                    setColumn(targetSquare.getColumn());
                }
                return pieceInTargetSquare.getColor() != getColor();
            }

        } else {
            return false;
        }

    }

    private Square getSquareAt(int column, int row) {
        return new Square(column, row, new Queen(column, row, getColor()));
    }


    @Override
    public String toString() {
        if (getColor() == 1) {
            return "Q";
        } else {
            return "q";
        }
    }
}