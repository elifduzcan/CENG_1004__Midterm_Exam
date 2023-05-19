import model.*;

public class Main {

    public static void main(String[] args) {
        //1. satranç tahtasını yarat
        ChessBoard board = new ChessBoard();

        //2. tahtaya taşları koy
        board.initialize();


        //3. oyun hazırsa, ekrana tahtanın mevcut halini bas
        //board.printBoard();
        printBoard(board);

        //4. while döngüsü ile oyunu oynat
        while (!board.isGameEnded()){

        }

    }


    private static void printBoard(ChessBoard board) {     // prints the initial version of the chessboard
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


