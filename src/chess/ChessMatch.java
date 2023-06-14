package chess;

import boardGame.Board;

public class ChessMatch {
	private Board board;
	
	//methods para definir o tamanho do board
	public ChessMatch() {
		board = new Board(8,8);
	}
	
	//methods que return uma Piece[][] correspondente a chessMatch
	public ChessPiece[][] getPieces() {
		//criar uma matriz temporaria
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		//percorrer a matriz de piece de board e para cada piece de board 
		//fazer um downcasting p ChessPiece 
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
}
