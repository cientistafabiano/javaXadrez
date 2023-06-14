package boardGame;

public class Board {
	//um tabuleiro tem a qde de linha e coluna
	private int rows;
	private int columns;
	//matriz de piece
	private Piece[][] pieces;
	//constructor
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	//retornar uma peça dada uma linha e uma coluna - peça iniciando
	//type Piece
	public Piece piece (int row, int column) {
		return pieces[row][column];
	}
	//criar uma sobrecarga - peça em movimento
	public Piece piece (Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
}
