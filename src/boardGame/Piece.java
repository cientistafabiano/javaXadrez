package boardGame;

public class Piece {
	//não queremos q a posição seja visivel no tabuleiro
	protected Position position;
	//associate a piece with o board
	private Board board;
	//constructor
	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	//ninguem de fora pode alterar o board
	protected Board getBoard() {
		return board;
	}
}
