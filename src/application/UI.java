package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	//codigo especiais das cores p imprimir no sonsole
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	//cores do texto
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	//cores de fundo
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	//limpando a tela do git bash depois das entradas do source e target
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush(); 
	}
	
	//ler uma posição 
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			//criar uma variavel para receber o q for digitaado pelo gamer
			String s = sc.nextLine();
			//pegar a primeira posicao pois é a coluna a segunda é a linha 
			char column = s.charAt(0);
			//recortar a positção 0, e transformar p inteiro
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("Erro lendo a posicao do xadre: Valores validos sao de a1 a h8.");
		}
	}
	//o que é imprimir a partida
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		//imprimir a peca capturada
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turno: " + chessMatch.getTurn());
		System.out.println("Esperando jogador: " + chessMatch.getCurrentPlayer());
	}

	// print the board
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				//se for imprimir o board sem o fundo da piece colorido 
				printPiece(pieces[i][j], false);
			}
			// quebra de linha
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	// print the board - sobrecarga
		public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
			for (int i = 0; i < pieces.length; i++) {
				System.out.print((8 - i) + " ");
				for (int j = 0; j < pieces.length; j++) {
					// com o possibleMoves eu pinto o fundo da piece no board
					printPiece(pieces[i][j], possibleMoves[i][j]);
				}
				// quebra de linha
				System.out.println();
			}
			System.out.println("  a b c d e f g h");
		}

	// imprimir uma unica piece
	//mudar o metodo e add um boolean background q dira se pinta o fundo ou nao da piece
	private static void printPiece(ChessPiece piece, boolean background) {
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
    	if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
	//imprimir uma lista de pecas capturadas
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());	
		System.out.println("Captured pieces: ");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("bLACK: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.print(ANSI_RESET);
	}
}
