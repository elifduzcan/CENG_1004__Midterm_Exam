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
        board.printBoard();

        //4. while döngüsü ile oyunu oynat
        while (!board.isGameEnded()) {
            //1 rengin sırasının geldiğini yaz
            System.out.println("It is " + (board.isWhitePlaying() ? "White" : "Black") + "'s turn");

            //2 kullanıcıdan oynatmak istediği taşı iste, yanlışsa bir daha zor
            Piece piece = null;
            int fromRow;
            int fromColumn;
            do {
                System.out.print("Enter the location of the piece:");
                String from = reader.next();
                fromColumn = ChessBoard.convertCharToInteger(from.charAt(0));
                fromRow = Integer.parseInt(from.substring(1, 2));
                piece = board.getPieceFromGivenSquare(fromColumn, fromRow);
            } while (piece == null || piece.getColor() != (board.isWhitePlaying() ? 1 : 0));

            //3 kullanıcıdan taşı süreceği yeri iste. yanlışsa gene sor
            String to = null;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();
            } while (!piece.canMove(board.castStringToSquare(to)));

            int toColumn = ChessBoard.convertCharToInteger(to.charAt(0));
            int toRow = Integer.parseInt(to.substring(1, 2));
            board.changePieceInSquare(toColumn, toRow, board.getPieceFromGivenSquare(fromColumn, fromRow));
            board.changePieceInSquare(fromColumn, fromRow, null);
            board.setWhitePlaying();
            //piece.move(to);
            board.printBoard();
        }
        reader.close();
    }

}



