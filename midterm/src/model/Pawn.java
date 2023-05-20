package model;

public class Pawn extends Piece {
    // TODO: 19.05.2023 initial location ekle ki iki adımlı hamleyi daha kolay kontrol ile yaptırt
    public boolean initialLocation = true;

    public Pawn(int color, int column, int row) {
        super(color, column, row);
    }

    @Override
    public boolean canMove(Square targetSquare) {

        boolean validMove = false;
        // taşın şu anki konumunu bul
        int targetColumn = targetSquare.getColumn();
        int columnDistance = targetSquare.getColumn() - this.getColumn();
        int rowDistance = targetSquare.getRow() - this.getRow();
        Piece pieceInTargetSquare = targetSquare.piece;

        // ilk olarak yapılacak hamlenin hareket etme mi yeme mi old karar ver
        if (pieceInTargetSquare == null) { // targetSquare de taş yoksa düz hareket etcek
            if (targetColumn == this.getColumn()) { // düz hareket edebilmesi için target ve şu anki columnlar aynı olmalı, değilse çık
                if (getColor() == 1 && rowDistance > 0 && rowDistance <= 2) { // taş beyazsa ve target ve şu anki rowları arası fark 2 ya da 1 ise
                    if (rowDistance == 2) {
                        // initialLocation değeri true ise pawn 2 kare hareket edebilir
                        return initialLocation;
                    } else {
                        return true;
                    }

                } else if (getColor() == 0 && rowDistance < 0 && rowDistance >= -2) {
                    if (rowDistance == -2) {
                        // initialLocation değeri true ise pawn 2 kare hareket edebilir
                        return initialLocation;
                    } else {
                        return true;
                    }
                }
            } else {
                return validMove;
            }

        } else if (targetColumn != this.getColumn()) { // target squarede taş varsa aynı columnda hareket edemez, taş yer
            if (Math.abs(columnDistance) == 1) { // taş yiyecekse sütunlar arası fark 1 ya da -1 olabilir
                if (getColor() != pieceInTargetSquare.getColor()) { // yiyecekse taşın rengi farklı olmalı
                    return true;
                } else {
                    return validMove;
                }

            } else {
                return validMove;
            }
        } else {
            return validMove;
        }

        // taşın şu anki konumunda oynayan tarafın taşı varsa, destination lokasyonu boş mu kontrol et


        // destination taş ile aynı sütunda ise arada kalan iki kare boş mu kontrol et, boşsa hareket ettir
        // destination ve taş komşu sütunlarda ise, destinationda karşı taraf  taşı var mı ve aradaki satır farkı 1 mi kontrol et, ikisi de sağlanırsa taşı oynat

        return true;

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



