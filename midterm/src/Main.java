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
            Piece piece = null;

            do {
                System.out.print("Enter the location of the piece:");
                String from = reader.next();
                int fromColumn = ChessBoard.convertCharToInteger(from.charAt(0));
                int fromRow = Integer.parseInt(from.substring(1, 2));
                piece = board.getPieceFromGivenSquare(fromColumn, fromRow);
            } while (piece == null || piece.getColor() != (board.isWhitePlaying() ? ChessBoard.WHITE : ChessBoard.BLACK)); // TODO: 20.05.2023 enumları değiştir 

            String to = null;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();
            } while (!piece.canMove(board.castStringToSquare(to)));
            piece.move(to);
            System.out.println(board);
        }
        reader.close();

        //2 kullanıcıdan oynatmak istediği taşı iste, yanlışsa bir daha zor
        Piece pieceToMove = board.getPieceFromGivenSquare(2, 2);

        //3 kullanıcıdan taşı süreceği yeri iste. yanlışsa gene sor

        //can move'un yapması gereken işler:
        //piyon bu hamleyi yapabilri mi?
        //yapabilirse, hamle yapacağı yerdeki taş kendi renginden nmi?

        //kendi rengindense hamle yapması FALSE dönmeli
        //eğer yapabilirse TRUE dönmeli

        //sonra update et


        //4 döngü şeklinde ilk 3 maddeyi tekrar ettir. döngüyü kırdıracak koşul en üstte yazılı. unutma dolayısıyla, 4'e geldiğinde, en üstteki sorgu
        //otomatik olarak kendiliğinden değişiyor zaten. 1'e gelip kendi kendini kıracak. dert etme.
    }

}



