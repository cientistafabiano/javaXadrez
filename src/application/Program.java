package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while (true) {
			try {
				//chamando para limpar
				UI.clearScreen();
				//fpo trocado o printBoard por printMatch
				UI.printMatch(chessMatch, captured);
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
				//se ao movimentar a piece o local nao for nulo, quer dizer q uma piece foi capturada e add a lista
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
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