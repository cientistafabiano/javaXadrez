package chess;

import boardGame.Board;
import chess.piece.King;
import chess.piece.Rook;

public class ChessMatch {
	private Board board;
	
	//methods para definir o tamanho do board
	public ChessMatch() {
		//cria o board e chama a função q inicia o jogo
		board = new Board(8,8);
		initialSetup();
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
	
	//informar a posição pelas coordenadas do xadrez para colocar a peça no board
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	
	//function that start the piece in the game
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
