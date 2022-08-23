package TicTacToe;

public class Board {
	private char[][] board;
	private int boardSize = 3;
	private char p1Symbol, p2Symbol;
	private int counter = 0;
	public final static int PLAYER_1_WIN = 1;
	public final static int PLAYER_2_WIN = 2;
	public static final int DRAW = 3;
	public static final int INCOPLTED = 4;
	public static final int INVALID = 5;
	
	public Board(char p1Symbol, char p2Symbol) {
		this.board= new char[boardSize][boardSize];
		for(int row =0; row < boardSize; row++) {
			for( int col =0; col < boardSize; col++) {
				this.board[row][col] ='-';
			}
		}
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}
	public int move(char symbol, int x, int y) {
		
		if(x < 0|| y < 0|| x > boardSize|| y>boardSize || board[x][y] !='-') {	// cheaking if the location on the board is ok
			return INVALID;
		}
		
		board[x][y] = symbol;
		counter++; // counter count the board size
		// cheak row 
		if(board[x][0]== board[x][1] && board[x][1]== board[x][2] && board[x][0]!= '-') {
			return symbol == p1Symbol ? PLAYER_1_WIN:PLAYER_2_WIN; 
		}
		// cheak col 
		if(board[0][y]== board[1][y] && board[1][y]== board[2][y] && board[0][y]!= '-') {
			return symbol == p1Symbol ? PLAYER_1_WIN:PLAYER_2_WIN; 
		}
		//main digonal
		if(board[0][0] != '-' && board[0][0]== board[1][1] && board[1][1] == board [0][0]) {
			return symbol == p1Symbol ? PLAYER_1_WIN:PLAYER_2_WIN; 
		}
		// second digonal 
		if(board[0][2]!='-' && board[0][2]== board[1][1] && board[1][1] == board[2][0]) {
			return symbol == p1Symbol ? PLAYER_1_WIN:PLAYER_2_WIN; 
		}
		return INCOPLTED;
	}
	public void printBoard() {
		System.out.println("-------------------");
		for(int i =0; i< boardSize; i++) {
			for(int j =0; j< boardSize; j++) {
				System.out.print("|"+board[i][j]+"|");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-------------------");
	}
	
	
}
