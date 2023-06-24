package chess.piece;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
	//constructor
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		//o que é converter uma rook/torre para string?
		return "R";
		//in Board aparece-ra o R na position de rook
	}
	
	//foi add pq chessPiece é abstract
	@Override
	public boolean[][] possibleMoves() {
		// criar uma matrix com todas as posiçoes do board
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		//variavel p iniciar
		Position p = new Position(0,0);
		
		//above/a cima
		//mantem a coluna e anda na linha
		p.setValues(position.getRow() - 1, position.getColumn());
		//enquanto a posicao p existir e nao houver uma peca la -> a posicao mat recebe true
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			//continua a subir na linha
			p.setRow(p.getRow() - 1);
		}
		//se a posicao existir e houver um oponente -> a posicao recebe true
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// left/esquerda
		// mantem a linha e anda na coluna
		p.setValues(position.getRow(), position.getColumn() - 1);
		// enquanto a posicao p existir e nao houver uma peca la -> a posicao mat recebe
		// true
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			// continua a subir na linha
			p.setColumn(p.getColumn() - 1);
		}
		// se a posicao existir e houver um oponente -> a posicao recebe true
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// right/direita
		// mantem a coluna e anda na linha
		p.setValues(position.getRow(), position.getColumn() + 1);
		// enquanto a posicao p existir e nao houver uma peca la -> a posicao mat recebe
		// true
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			// continua a subir na linha
			p.setColumn(p.getColumn() + 1);
		}
		// se a posicao existir e houver um oponente -> a posicao recebe true
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// below/a baixo
		// mantem a linha e anda na coluna
		p.setValues(position.getRow() + 1, position.getColumn());
		// enquanto a posicao p existir e nao houver uma peca la -> a posicao mat recebe
		// true
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			// continua a subir na linha
			p.setRow(p.getRow() + 1);
		}
		// se a posicao existir e houver um oponente -> a posicao recebe true
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
		// neste caso todas as posiçoes do Hook sao falsas
	}
	
}
