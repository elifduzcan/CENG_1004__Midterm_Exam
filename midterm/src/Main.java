import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //1. satranç tahtasını yarat
        ChessBoard board = new ChessBoard();

        //2. tahtaya taşları koy
        board.initialize();


        //3. oyun hazırsa, ekrana tahtanın mevcut halini bas
        //board.printBoard();
        printBoard(board);
        ChessBoard.Color colorBlack = ChessBoard.Color.BLACK;
        ChessBoard.Color colorWhite = ChessBoard.Color.WHITE;

        //4. while döngüsü ile oyunu oynat
        while (!board.isGameEnded()) {
            System.out.println("It is " + (board.isWhitePlaying() ? "White" : "Black") + "'s turn");
            Piece piece = null;
            do {
                System.out.print("Enter the location of the piece:");
                String from = reader.next();
                piece = board.convertInputToCoordinates(from);
            } while ((piece == null) || (piece.getColor() != (board.isWhitePlaying() ? ChessBoard.WHITE : ChessBoard.BLACK)));
            String to = null;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();
            } while (!piece.canMove(to));
            piece.move(to);
            System.out.println(board);
        }
        reader.close();
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


