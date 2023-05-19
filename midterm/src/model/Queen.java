package model;

public class Queen extends Piece {
    public Queen(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) { //taşların üzerinden atlayamama işinin kontrol edilmesi gerek
        int columnDistance = targetSquare.getColumn() - this.getColumn();
        int rowDistance = targetSquare.getRow() - this.getRow();
        Piece pieceInTargetSquare = targetSquare.piece;

        if (Math.abs(columnDistance) > 0 || Math.abs(rowDistance) > 0 || (Math.abs(columnDistance) == Math.abs(rowDistance))){
            if(pieceInTargetSquare==null){
                return true;
            }else return pieceInTargetSquare.getColor() != getColor();
        }else {
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
            return "Q";
        } else {
            return "q";
        }
    }
}