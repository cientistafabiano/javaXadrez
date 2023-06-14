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
}
