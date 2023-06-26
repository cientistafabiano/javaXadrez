package chess.piece;

import boardGame.Board;
import boardGame.Position;
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
	// function para testar se o movimento é possivel
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		//ou a casa ta vazia ou tem uma piece de cor diferente
		return p == null || p.getColor() != getColor();
	}
	//foi add pq chessPiece é abstract
	@Override
	public boolean[][] possibleMoves() {
		//criar uma matrix com todas as posiçoes do board
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		//iniciar a piece em um posicao para mover para as direçoes conforme a regra
		Position p = new Position(0,0);
		//above
		// anda na linha e mantem a coluna
		p.setValues(position.getRow() - 1, position.getColumn());
		//se a posicao no tabuleiro exisate e for possivel o movimento
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//abaixo
		// anda na linha e mantem a coluna
		p.setValues(position.getRow() + 1, position.getColumn());
		// se a posicao no tabuleiro exisate e for possivel o movimento
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//left
		// anda na linha e mantem a coluna
		p.setValues(position.getRow(), position.getColumn() - 1);
		// se a posicao no tabuleiro exisate e for possivel o movimento
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//right
		// anda na linha e mantem a coluna
		p.setValues(position.getRow(), position.getColumn() + 1);
		// se a posicao no tabuleiro exisate e for possivel o movimento
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		} 
		//nw
		// anda na linha e mantem a coluna
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		// se a posicao no tabuleiro exisate e for possivel o movimento
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//ne
		// anda na linha e mantem a coluna
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		// se a posicao no tabuleiro exisate e for possivel o movimento
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//sw
		// anda na linha e mantem a coluna
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		// se a posicao no tabuleiro exisate e for possivel o movimento
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//se
		// anda na linha e mantem a coluna
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		// se a posicao no tabuleiro exisate e for possivel o movimento
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
		//neste caso todas as posiçoes do King sao falsas
	}
}
