//Aviva malako
package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
	private Player player1,player2;
	private Board board;

	
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.startGame();
		
	}
	public void startGame() {
		Scanner c = new Scanner(System.in);
		player1 = initPlayer(1);
		player2 = initPlayer(2);
		while(player1.getSymbole() == player2.getSymbole()) {
			System.out.println("This Symbol Already taken Please PIck Anothe Symbol\n");
			char symbol = c.next().charAt(0);
			player2.setSymbol(symbol);
		}
		board = new Board(player1.getSymbole(),player2.getSymbole());
		boolean player1T = true;
		int status = Board.INCOPLTED;
		while(status == Board.INCOPLTED || status == Board.INVALID ) {
			if(player1T) {
				System.out.println("Player -1 :"+ player1.getName() + " turn");
				System.out.println("Enter row\n");
				int row = c.nextInt();
				System.out.println("Enter col\n");
				int col = c.nextInt();
				status = board.move(player1.getSymbole(), row,col);
				if(status != Board.INVALID) {
					player1T = false;
					board.printBoard();
				}
				else {
					System.out.println("Invalid Move try again \n");
				}
			}
			else {
				System.out.println("Player-2 :"+ player2.getName() +" turn");
				System.out.println("Enter row\n");
				int row = c.nextInt();
				System.out.println("Enter col\n");
				int col = c.nextInt();
				status = board.move(player2.getSymbole(), row,col);
				if(status != Board.INVALID) {
					player1T = true;
					board.printBoard();
				}
				else {
					System.out.println("Invalid Move try again \n");
				}
				
			}
		}
		if (status == Board.PLAYER_1_WIN) {
			System.out.println("Player 1 -"+player1.getName() +" Win");
		}
		else if(status == Board.PLAYER_2_WIN) {
			System.out.println("Player 2 -"+player2.getName() +" Win");
		}
		else {
			System.out.println("Draw");
		}
		
	}
	
	private Player initPlayer(int num) {
		Scanner c = new Scanner(System.in);
		System.out.println("Enter your name player Number:"+ num+"\n" );
		String name = c.nextLine();		
		System.out.println("Enter Symbol player Number:"+ num+"\n" );
		char symbol = c.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;
		
	}
}
