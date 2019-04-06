package main.java;

import java.util.Random;

public class Agents {

	public String Simple_Reflex_Agent(int location, int status) {
		
		if (status == 1) 
			return "Suck";	
		else if (location == 0)
			return "Right";
		else if (location == 1)
			return "Left";
		else
			System.out.println("\n" + "Action Error"+ "\n");
		
		return "Error";
	}	
	
	public void Randonmized_Simple_Reflex_Agent(int rowCt, int columnCt) {
		
		ScoringEnvironment env = new ScoringEnvironment(rowCt, columnCt);
		Random r = new Random();

		while(!env.isDone()) {
			if(!env.isClean(env.get_agent_location()[0],env.get_agent_location()[1])) {
				env.act("Suck");
			}
			else if(r.nextInt(4)==0) {
				env.act("Left");
			}
			else if(r.nextInt(4)==1) {
				env.act("Right");
			}
			else if(r.nextInt(4)==2) {
				env.act("Up");
			}
			else
				env.act("Down");				
		}		
	}	
	
	public void stateAgent(int rowCt, int columnCt) {
		ScoringEnvironment env = new ScoringEnvironment(rowCt, columnCt);
		int [][] visited = new int[rowCt][columnCt];
		returnToOrigin(env);
		while(!env.isDone()) {
			if(!env.isClean(env.get_agent_location()[0],env.get_agent_location()[1])) {
				env.act("Suck");
				visited[env.get_agent_location()[0]][env.get_agent_location()[1]] = 1;
			}
			else if(env.get_agent_location()[1]+1<columnCt && visited[env.get_agent_location()[0]][(env.get_agent_location()[1] + 1)] !=1) {
				visited[env.get_agent_location()[0]][env.get_agent_location()[1]] = 1;
				env.act("Right");
			}
			else if(env.get_agent_location()[1]>0 && visited[env.get_agent_location()[0]][(env.get_agent_location()[1] - 1)] !=1){
				visited[env.get_agent_location()[0]][env.get_agent_location()[1]] = 1;
				env.act("Left");
			}
			else if(env.get_agent_location()[0]+1<rowCt && visited[env.get_agent_location()[0]+1][env.get_agent_location()[1]]!=1) {
				visited[env.get_agent_location()[0]][env.get_agent_location()[1]] = 1;
				env.act("Up");
			}else if(!env.isDone()) {
				returnToOrigin(env);
			}
		}
		
	}
	public void returnToOrigin(ScoringEnvironment env) {
		while(env.get_agent_location()[0]>0) {
			env.act("Down");
		}
		while(env.get_agent_location()[1]>0) {
			env.act("Left");
		}
	}
}
