package application;

import chess.ChessPiece;

public class UI {
	//print the board
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i=0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			//quebra de linha
			System.out.println();
		}
		System.out.println("  a b c d e f g h");

	}
	//imprimir uma unica piece
	public static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print("-");
		} 
		else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

}
