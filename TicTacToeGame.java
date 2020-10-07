import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	public static Scanner userInputScanner = new Scanner(System.in);
	public static int USER = 1, COMPUTER = 1;

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
			} else {
				System.out.println("Move not Available");
			}
		}
	}

// Checking if move is available or not
	public static boolean moveAvailabile(char[] board, int index) {
		return board[index] == ' ';
	}

//	Making move
	public static void makeMove(char[] board, int index, char letter) {
		boolean isFree = moveAvailabile(board, index);
		if (isFree) {
			System.out.println("Move Successfull");
			board[index] = letter;
		} else {
			System.out.println("Move Unsuccessfull, Try Again");
		}
	}

//	Who shall play First
	public static int playFirstToss() {
		Random random = new Random();
		int whoPlaysFirst = random.nextInt(2);
		return whoPlaysFirst;
	}

//	check at anypoint if game has ended in win or tie 
	public static boolean isWinner(char[] board, char userCharacter) {
		return (board[1] == userCharacter && board[2] == userCharacter && board[3] == userCharacter
				|| board[4] == userCharacter && board[5] == userCharacter && board[6] == userCharacter
				|| board[7] == userCharacter && board[8] == userCharacter && board[9] == userCharacter
				|| board[1] == userCharacter && board[4] == userCharacter && board[7] == userCharacter
				|| board[2] == userCharacter && board[5] == userCharacter && board[8] == userCharacter
				|| board[3] == userCharacter && board[6] == userCharacter && board[9] == userCharacter
				|| board[1] == userCharacter && board[5] == userCharacter && board[9] == userCharacter
				|| board[3] == userCharacter && board[5] == userCharacter && board[7] == userCharacter);
	}

// Computer's move-> Trying to win	
	public static int ifAnyWinningMove(char letter, char[] board) {
		for (int index = 1; index <= 9; index++) {
			char[] boardClone = board.clone();
			if (isWinner(boardClone, letter))
				return index;
		}
		return 0;
	}

// Get Computer's Move, if winning, return winning move. Else, return 0. Also, if user is winning on next move, We try to block next move.
	public static int getComputerMove(char[] board, char computerLetter, char userLetter) {
		int winningMove = ifAnyWinningMove(computerLetter, board);
		if (winningMove != 0)
			return winningMove;
		else {
			int userWinningMove = ifAnyWinningMove(userLetter, board);
			if (userLetter != 0)
				return userWinningMove;
		}
		return 0;
	}

//  Main Method
	public static void main(String[] args) {
		int whoPlaysFirst = playFirstToss();
		String firstPlayerString = "";
		if (whoPlaysFirst == 0)
			firstPlayerString += "COMPUTER";
		else
			firstPlayerString += "USER";
		System.out.println(firstPlayerString + " shall be playing first");
		char[] ticTacToeBoardGame = ticTacToeBoard();
		char userGameCharacter = chooseGameCharacter();
		char computerGameCharacter = ' ';
		if (userGameCharacter == 'X')
			computerGameCharacter = 'O';
		else
			computerGameCharacter = 'X';
		displayBoard(ticTacToeBoardGame);
		int userMove = userMove(ticTacToeBoardGame);
		makeMove(ticTacToeBoardGame, userMove, userGameCharacter);
		displayBoard(ticTacToeBoardGame);
	}
}
