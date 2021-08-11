package connectFour;

import java.util.*;

public class ConnectFourTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] gameBoard = new char[6][6];
		// [column] [row]
		char p1 = '*';
		char p2 = 'o';
		int index = 0;

		printBoard(gameBoard);
		gameBoard = addPiece(p1, 3, gameBoard);

//		{
//			if (index == 0) {
//				System.out.println("Player 1, Please pick a slot (1 - 6) to drop a piece:");
//				int slot = sc.nextInt() - 1;
//				gameBoard = addPiece(p1, slot, gameBoard);
//
//				index = (index + 1) % 2;
//			} else {
//				System.out.println("Player 2, Please pick a slot (1 - 6) to drop a piece:");
//				int slot = sc.nextInt() - 1;
//				gameBoard = addPiece(p2, slot, gameBoard);
//
//				index = (index + 1) % 2;
//
//			}
//
//		}
//		while (winningCondition(gameBoard));
//
	}

	public static boolean winningCondition(char[][] board) {
		char p1;

		return false;
	}

	public static char[][] addPiece(char player, int slot, char[][] board) {
		int col = 6;
		int row = 6;
		
		for (int i = 0; i < 6; i++) {
			if (board[slot][i] == player) {
				System.out.println(board[slot][i]);
			}
		}

		return board;
	}

	public static char[][] printBoard(char[][] board) {
		int col = board.length;
		int row = board[1].length;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
					System.out.print("[ "+ board[i][j]+" ] ");
			}
			System.out.println();
		}

		return null;
}

}
