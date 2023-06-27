package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true) {
			try {
				//chamando para limpar
				UI.clearScreen();
				//fpo trocado o printBoard por printMatch
				UI.printMatch(chessMatch);
				System.out.println();
				//pedir a posição inicial da peça
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				//imprimir as possiveis posicao a partir da origem
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				//criar uma sobrecarga de printBoard
				UI.printBoard(chessMatch.getPieces(), possibleMoves);			
				
				System.out.println();
				//pedir a posição final da peça
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch (ChessException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
	}

}