package chess;

import boardGame.Board;
import boardGame.Piece;
//como Piece virou abstract chessPiece q é subclass de Piece deve ser abstract
public abstract class ChessPiece extends Piece {
	private Color color;
	//constructor
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	// apenas o methods get para que não seja possivel trocar a cor
	public Color getColor() {
		return color;
	}	
}