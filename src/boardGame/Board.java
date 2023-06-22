package boardGame;

public class Board {
	//um tabuleiro tem a qde de linha e coluna
	private int rows;
	private int columns;
	//matriz de piece
	private Piece[][] pieces;
	//constructor
	public Board(int rows, int columns) {
		//programação defensiva
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar o board: é necessario q haja ao menos 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}
	/*evitar q rows sejam alteradas assim como columns
	 * public void setRows(int rows) {
	 
		this.rows = rows;
	}*/
	public int getColumns() {
		return columns;
	}
	/*
	public void setColumns(int columns) {
		this.columns = columns;
	}*/
	//retornar uma peça dada uma linha e uma coluna - peça iniciando
	//type Piece
	public Piece piece (int row, int column) {
		//programação defensiva
		if (!positionExists(row, column)) {
			throw new BoardException("Posição fora do tabuleiro/board.");
		}
		return pieces[row][column];
	}
	//criar uma sobrecarga - peça em movimento
	public Piece piece (Position position) {
		//programação defensiva
		if (!positionExists(position)) {
			throw new BoardException("Posição fora do tabuleiro/board.");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//colocando piece in the board
	public void placePiece (Piece piece, Position position) {
		//testar se ja existe uma piece nesta posição
		if (thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça nesta posição" + position);
		}
		//pegar a matriz de piece e add a piece
		pieces[position.getRow()][position.getColumn()] = piece;
		//position deixou de ser null
		piece.position = position;
	}
	//methods auxiliar
	//aqui dentro da class vai ser mais facil testar pela row and column do q pela position
	//essa position sera valida se estiver dentro do board
	private boolean positionExists(int row, int column) {
		//altura do board == rows && qde de columns
		return row >= 0 && row < rows && column >= 0 && column < columns;		
	}
	//verificar se uma position existe
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	//como testar se tem uma piece em dada position?
	public boolean thereIsAPiece(Position position) {
		//programação defensiva
		if (!positionExists(position)) {
			throw new BoardException("Posição fora do tabuleiro/board.");
		}
		return piece(position) != null;
	}
}
