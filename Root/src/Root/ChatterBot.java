package Root;

import java.util.Random;

public class ChatterBot {
	static final String REQUEST_PREFIX = "say ";
	
	Random random = new Random();
	String[] repliesTo;
	String name;
	
	
	ChatterBot(String name ,String[] repliesTo){
		this.name = name;
		this.repliesTo = new String[repliesTo.length];
		int index = 0;
		while (index < repliesTo.length) {
			this.repliesTo[index] = repliesTo[index];
			index ++;
		}
	}
	
	String replyTo(String statment) {
		
		if (statment.startsWith(REQUEST_PREFIX)){
			return statment.replaceFirst(REQUEST_PREFIX,"");
		}

		return replatToIllegal(statment);
	}
	
	String replatToIllegal(String statment) {
		int randomIndex = random.nextInt(repliesTo.length);
		String replay = this.repliesTo[randomIndex]; 
		if (random.nextBoolean()) {
			replay = replay + statment;
		}
		return replay;
	}
}
