
public class TicTacToeGame {
	public static char[] ticTacToeBoard() {
		char[] ticTacToeBoard = new char[10];
		for(int i=0; i<ticTacToeBoard.length; i++) {
			ticTacToeBoard[i] = ' ';
		}
		return ticTacToeBoard;
	}
	public static void main(String[] args) {
		char[] ticTacToeBoardMain = ticTacToeBoard();
		System.out.println(ticTacToeBoardMain);
	}
}
