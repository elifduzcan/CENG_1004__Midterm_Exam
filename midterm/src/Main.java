import model.*;

public class Main {

    public static void main(String[] args) {
        //1. satranç tahtasını yarat
        ChessBoard board = new ChessBoard();

        //2. tahtaya taşları koy
        setupChessboard(board);


        //3. oyun hazırsa, ekrana tahtanın mevcut halini bas
        //board.printBoard();
        printBoard(board);

        //4. while döngüsü ile oyunu oynat

    }

    public static void setupChessboard(ChessBoard board) {
        //region placing whites aka 1
        board.updateSpecificSquare(1, 1, new Rook(1));
        board.updateSpecificSquare(1, 2, new Knight(1));
        board.updateSpecificSquare(1, 3, new Bishop(1));
        board.updateSpecificSquare(1, 4, new Queen(1));
        board.updateSpecificSquare(1, 5, new King(1));
        board.updateSpecificSquare(1, 6, new Bishop(1));
        board.updateSpecificSquare(1, 7, new Knight(1));
        board.updateSpecificSquare(1, 8, new Rook(1));
        for (int column = 1; column <= 8; column++) {
            int row = 2;
            board.updateSpecificSquare(row, column, new Pawn(1));
        }
        //endregion

        //region placing blacks aka 0
        for (int column = 1; column <= 8; column++) {
            int row = 7;
            board.updateSpecificSquare(row, column, new Pawn(0)); // 0 black
        }
        board.updateSpecificSquare(8, 1, new Rook(0));
        board.updateSpecificSquare(8, 2, new Knight(0));
        board.updateSpecificSquare(8, 3, new Bishop(0));
        board.updateSpecificSquare(8, 4, new Queen(0));
        board.updateSpecificSquare(8, 5, new King(0));
        board.updateSpecificSquare(8, 6, new Bishop(0));
        board.updateSpecificSquare(8, 7, new Knight(0));
        board.updateSpecificSquare(8, 8, new Rook(0));

        //endregion
    }

    private static void printBoard(ChessBoard board) {
        System.out.println("   A   B   C   D   E   F   G   H");
        System.out.println(" ---------------------------------");
        for (int row = 8; row >= 1; row--) {
            System.out.print(row + "| ");
            for (int column = 1; column <= 8; column++) {
                Piece piece = board.getPieceFromGivenSquare(row, column);
                if (piece != null) {
                    System.out.print(piece + " | ");
                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println(row);
            System.out.println(" ---------------------------------");
        }
        System.out.println("   A   B   C   D   E   F   G   H");
    }
}


