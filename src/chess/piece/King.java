package chess.piece;

import boardGame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	//constructor
	public King(Board board, Color color) {
		super(board, color);
	}
	public String toString() {
		return "K";
	}
	//foi add pq chessPiece é abstract
	@Override
	public boolean[][] possibleMoves() {
		//criar uma matrix com todas as posiçoes do board
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
		//neste caso todas as posiçoes do King sao falsas
	}
}
