package model;

public class Rook extends Piece {
    public Rook(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) { //taşların üzerinden atlayamama işinin kontrol edilmesi gerek
        boolean validMove = false;
        Piece pieceInTargetSquare = targetSquare.piece;

        if (targetSquare.getColumn() == this.getColumn() || targetSquare.getRow() == this.getRow()) {
            if (pieceInTargetSquare == null) {
                return true;
            } else return pieceInTargetSquare.getColor() != getColor();
        }else{
            return validMove;
        }

    }

    @Override
    public void move(String destination) {
        // TODO: 19.05.2023 fonksiyonu yaz

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