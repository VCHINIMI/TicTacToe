import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	public static Scanner userInputScanner = new Scanner(System.in);

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
		while (flag == 0) {
			System.out.println("Choose Game Character X or O");
			userCharacter = userInputScanner.next().charAt(0);
			if (!(userCharacter == 'X' || userCharacter == 'O'))
				System.out.println("Invalid Character");
			else
				flag = 1;
		}
		return userCharacter;
	}

	// Displaying Board
	public static void displayBoard(char[] gameBoard) {
		System.out.println("\n");
		System.out.println(gameBoard[1] + "|" + gameBoard[2] + "|" + gameBoard[2]);
		System.out.println("-----");
		System.out.println(gameBoard[4] + "|" + gameBoard[5] + "|" + gameBoard[6]);
		System.out.println("-----");
		System.out.println(gameBoard[7] + "|" + gameBoard[8] + "|" + gameBoard[9]);
	}

	// Getting User move
	private static int userMove(char[] board) {
		Integer[] validCellsIntegers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		while (true) {
			System.out.println("What is next Move?");
			int index = userInputScanner.nextInt();
			userInputScanner.nextLine();
			if (Arrays.asList(validCellsIntegers).contains(index) && moveAvailabile(board, index)) {
				userInputScanner.close();
				return index;
			}
			else {
				System.out.println("Move not Available");
			}
		}
	}

// Checking if move is available or not
	public static boolean moveAvailabile(char[] board, int index) {
		return board[index] == ' ';
	}

//Making move
	public static void makeMove(char[] board, int index, char letter) {
		boolean isFree = moveAvailabile(board, index);
		if (isFree) {
			System.out.println("Move Successfull");
			board[index] = letter;
		}
		else {
			System.out.println("Move Unsuccessfull, Try Again");
		}
	}

// Main Method
	public static void main(String[] args) {
		char[] ticTacToeBoardMain = ticTacToeBoard();
		char userGameCharacter = chooseGameCharacter();
		displayBoard(ticTacToeBoardMain);
		int useMove = userMove(ticTacToeBoardMain);
		makeMove(ticTacToeBoardMain, useMove, userGameCharacter);
		displayBoard(ticTacToeBoardMain);
	}
}
