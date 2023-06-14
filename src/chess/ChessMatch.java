package chess;

import boardGame.Board;
import boardGame.Position;
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
	public void initialSetup() {
		board.PlacePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.PlacePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.PlacePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
