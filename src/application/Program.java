package application;

import boardGame.Board;
import boardGame.Position;

public class Program {

	public static void main(String[] args) {

		Position position = new Position(2, 5);
		System.out.print(position);
		Board board = new Board(8, 8);
	}

}
