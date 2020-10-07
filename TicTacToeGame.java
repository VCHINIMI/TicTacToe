import java.util.Scanner;

public class TicTacToeGame {
	// Initializing TicTacToeBoard
	public static char[] ticTacToeBoard() {
		char[] ticTacToeBoard = new char[10];
		for (int i = 0; i < ticTacToeBoard.length; i++) {
			ticTacToeBoard[i] = ' ';
		}
		return ticTacToeBoard;
	}

	// Choosing character
	public static char chooseGameCharacter() {
		int flag = 0;
		char userCharacter = ' ';
		Scanner scanner = new Scanner(System.in);
		while (flag == 0) {
			System.out.println("Choose Game Character X or O");
			userCharacter = scanner.next().charAt(0);
			if (!(userCharacter == 'X' || userCharacter == 'O'))
				System.out.println("Invalid Character");
			else
				flag = 1;
		}
		scanner.close();
		return userCharacter;
	}

	// Displaying Board
	public static void displayBoard(char[] board) {
		System.out.println("\n");
		System.out.println(board[1] + "|" + board[2] + "|" + board[2]);
		System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
		System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
	}

	// Main Method
	public static void main(String[] args) {
		char[] ticTacToeBoardMain = ticTacToeBoard();
		char userGameCharacter = chooseGameCharacter();
		displayBoard(ticTacToeBoardMain);
	}
}
