package chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
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
	//verificar se ha uma peca do oponente nesta posicao
	protected boolean isThereOpponentPiece(Position position) {
		//pegar a peca q esta nesta posicao no board - fazer downcasting
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		//verificar se a posicao é null e se a cor da peca é diferente, ou seja, peca adversaria
		return p != null && p.getColor() != color;
 	}
	
}