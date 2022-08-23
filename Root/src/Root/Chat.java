package Root;

import java.util.Scanner;

public class Chat {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String statment = scanner.nextLine();
		String name;
		
		
		String[] replies = {"What ","say i should say"};
		ChatterBot[] bots = new ChatterBot[2];
		bots[0] = new ChatterBot("Aviva",replies);
		
		replies[1] = "say say";
		bots[1] = new ChatterBot("Moshe",replies);
		int indexcurrentbot = 0;
		
		while(true) {
			statment = bots[indexcurrentbot].replyTo(statment);
			name = bots[indexcurrentbot].name;
			System.out.print(name+":"+statment+"\n");
			statment = scanner.nextLine();
			indexcurrentbot = 1 - indexcurrentbot;
			
		}
	
	
		
		
	}

}
