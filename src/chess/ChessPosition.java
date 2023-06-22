package chess;

import boardGame.Position;

public class ChessPosition {
	private char column;
	private int row;
	//constructor
	public ChessPosition(char column, int row) {
		//criar uma programação defensiva
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException ("Erro instanciando chessPosition: Valores válidos de ai até h8");
		}
		this.column = column;
		this.row = row;
	}
	//getters and setters
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	
	//methods converte chessPosition para comumPosition
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	//methods converte comumPosition para chessPosition
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	@Override
	public String toString() {
		//o "" faz ele entender q é uma concatenação de string
		return "" + column + row;
	}
}