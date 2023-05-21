package model;

public class Pawn extends Piece {
    public boolean initialLocation = true;
    Piece piece;

    public Pawn(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) {
        // TODO: 21.05.2023 Taşların başlangıç lokasyonu güncellenmiyor
        boolean validMove = false;
        // taşın şu anki konumunu bul
        int targetColumn = targetSquare.getColumn();
        int targetRow = targetSquare.getRow();
        int columnDistance = targetSquare.getColumn() - this.getColumn();
        int rowDistance = targetSquare.getRow() - this.getRow();
        Piece pieceInTargetSquare = targetSquare.piece;
        System.out.println("targetSquare.getRow() " + targetSquare.getRow() + " getRow() " + this.getRow());

        // ilk olarak yapılacak hamlenin hareket etme mi yeme mi old karar ver
        if (targetSquare.isEmpty()) { // targetSquare de taş yoksa düz hareket etcek
            System.out.println("target taş null");
            if (targetColumn == this.getColumn()) {
                System.out.println("target col this.columna eşit");// düz hareket edebilmesi için target ve şu anki columnlar aynı olmalı, değilse çık

                if (getColor() == 1 && rowDistance > 0 && rowDistance <= 2) {
                    System.out.println("taş beyaz, row distance 1 ya da 2");// taş beyazsa ve target ve şu anki rowları arası fark 2 ya da 1 ise
                    if (rowDistance == 2) {
                        // TODO: 21.05.2023 PAWNIN ATLADIĞI TAŞIN YOLUNDA BAŞKA TAŞ VAR MI BAK
                        // initialLocation değeri true ise pawn 2 kare hareket edebilir
                        System.out.println("row distance 2");
                        if (initialLocation) {
                            setRow(targetSquare.getRow());
                            setColumn(targetSquare.getColumn());
                        }
                        return initialLocation;
                    } else {
                        System.out.println("row distance 1");
                        if (targetSquare.isAtLastRow(getColor())) {
                            targetSquare.putNewQueen(getColor());
                        }
                        setRow(targetSquare.getRow());
                        setColumn(targetSquare.getColumn());
                        return true;
                    }

                } else if (getColor() == 0 && rowDistance < 0 && rowDistance >= -2) {
                    System.out.println("taş siyah, row distance -1 ya da -2");
                    if (rowDistance == -2) {
                        // initialLocation değeri true ise pawn 2 kare hareket edebilir
                        System.out.println("row distance -2");
                        if (initialLocation) {
                            setRow(targetSquare.getRow());
                            setColumn(targetSquare.getColumn());
                        }
                        return initialLocation;
                    } else {
                        System.out.println("row distance -1");
                        setRow(targetSquare.getRow());
                        setColumn(targetSquare.getColumn());
                        return true;
                    }
                } else {
                    return validMove;
                }
            } else {
                System.out.println("target col this.col dan farklı");
                return validMove;
            }

        } else {
            System.out.println("target col this.coldan farklı");
            if ((getColor() == 1 && Math.abs(columnDistance) == 1 && rowDistance == 1) || (getColor() == 0 && Math.abs(columnDistance) == 1 && rowDistance == -1)) {// taş yiyecekse sütunlar arası fark 1 ya da -1 olabilir
                System.out.println("taş beyazsa, |coldistance| 1 rowdistance1; taş siyahsa |coldistance| 1 rowdistance -1");
                if (getColor() != pieceInTargetSquare.getColor()) { // yiyecekse taşın rengi farklı olmalı
                    System.out.println("targettaki taş oynanandan farklı renkte");

                    setRow(targetSquare.getRow());
                    setColumn(targetSquare.getColumn());

                    return true;
                } else {
                    return validMove;
                }
            } else {
                return validMove;
            }
        }
    }

    private Piece promoteQueen(int column, int row) {
        return new Queen(getColor(), column, row);
    }

    @Override
    public String toString() {
        if (getColor() == 1) {
            return "P";
        } else {
            return "p";
        }
    }
}



