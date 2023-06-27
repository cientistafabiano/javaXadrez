package chess;

import java.util.ArrayList;
import java.util.List;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.piece.King;
import chess.piece.Rook;

public class ChessMatch {
	private int turn;
    private Color currentPlayer;
	private Board board;
	
	//listas p organizar as pieces - tanto faz instanciar aqui ou contructor
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	//methods para definir o tamanho do board
	public ChessMatch() {
		//cria o board e chama a função q inicia o jogo
		board = new Board(8,8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	public int getTurn() {
		return turn;
	}
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	//methods que return uma Piece[][] correspondente a chessMatch
	public ChessPiece[][] getPieces() {
		//criar uma matriz temporaria
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		//percorrer a matriz de piece de board e para cada piece de board 
		//fazer um downcasting p ChessPiece 
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	//implementar para q seja mostrado no board os possiveis movimentos de uma piece
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
	//converter a posicao dew xadrez para uma posicao comum
		Position position = sourcePosition.toPosition();
		//validar a posicao
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	
	//performar o movimento de uma posicao de origem/source p uma posicao final/target
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		//capturar a peça e mover da origem para o destino
		Piece capturedPiece = makeMove(source, target);
		//depois da jogada chama o 
		nextTurn();
		//como capturePiece é do tipo Piece - fazer downcasting p ChessPiece
		return (ChessPiece) capturedPiece;
	}
	//methods realizar o movimento
	private Piece makeMove(Position source, Position target) {	
		//remover a peça da posição original
		Piece p = board.removePiece(source);
		//remover a possivel peça q estiver na posição final 
		//q por padrao sera a peça capturedPiece
		Piece capturedPiece = board.removePiece(target);
		//colocar a peça da posiçao de origem no destino
		board.placePiece(p, target);
		//se a piece captured for do adversario, remove da listBoard e add a listCaptured
		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	//validar a posição
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("Nao ha peca na posicao de origem.");
		}
		//verificar de qual cor é a jogada --- o getColor é uma propriedade do ChessPiece
		//testo se a peca é uma peca do adversario, sendo?
		if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("A peca escolhida nao e sua");
		}
		//validar se ha movimentos possiveis para a piece
		//acessar o board -> piece na posicao de origem -> chamar: isThereAnyPossibleMove
		//se nao tiver nenhum movimento possivel? lanca uma exception
		if (!board.piece(position).isThereAnyPossibleMove()){
			throw new ChessException("Nao existe movimentos possiveis para a peca");			
		}
	}	
	//validar a posicao destino
	private void validateTargetPosition(Position source, Position target) {
		//se para a peca de origem a posicao de destino nao é um movimento possivel
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("A peca escolhida nao pode mover se para a posicao desejada");
		}
	}
	//troca de turno
	private void nextTurn() {
		turn++;
		//					se for igual a branco, troca para preto, senao é branco
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	//inFormar a posição pelas coordenadas do xadrez para colocar a peça no board
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		//alem de colocar a piece no board colocaremos na lista tbem
		piecesOnTheBoard.add(piece);
	}
		
	//function that start the piece in the game
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
