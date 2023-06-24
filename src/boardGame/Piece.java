package boardGame;

public abstract class Piece {
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
	
	//movimentos possiveis - como essa funcao é abstract a class Piece need to be abstract
	public abstract boolean[][] possibleMoves();
	//metodo concreto q usa o abstract
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	//se existe apenas um movimento possivel
	public boolean isThereAnyPossibleMove() {
		//criar uma variavel
		boolean[][] mat = possibleMoves();
		//percorrer essa matrix para verificar se existe
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
