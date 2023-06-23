package chess.piece;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
	//constructor
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		//o que é converter uma rook/torre para string?
		return "R";
		//in Board aparece-ra o R na position de rook
	}
	
	//foi add pq chessPiece é abstract
	@Override
	public boolean[][] possibleMoves() {
		// criar uma matrix com todas as posiçoes do board
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
		// neste caso todas as posiçoes do Hook sao falsas
	}
	
}
