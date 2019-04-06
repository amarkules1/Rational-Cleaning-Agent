package main.java;

public class Main {

	public static void main(String[] args) {
	
		//initialize environment
		BasicEnvironment env = new BasicEnvironment();
		Agents agent = new Agents();
		String action;
		
		//run agent
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++) {
					env.set_configuration(i,j,k);
					System.out.println("\nStart:" + (i == 0 ? "Space A is clean" : "Space A is dirty") + ":" + 
													(j == 0 ? "Space B is clean" : "Space B is dirty") + ":" + 
													(k == 0 ? "Initially, Agent is in space A" : "Initially, Agent is in space B") + ":" + 
													(env.get_agent_location() == 0 ? "Current space is A" : "Current space is B") + ":" + 
													(env.isClean(0,env.get_agent_location()) ? "Current space status is clean" : "Current space status is dirty") + "\n");
					for (int l = 0; l < 10; l++) {
						action = agent.Simple_Reflex_Agent(env.get_agent_location(),env.isClean(0,env.get_agent_location()) ? 0 : 1);
						env.act(action);
						System.out.println("Step: " + (l+1) + ":" + action + ":" + 
											(env.get_agent_location() == 0 ? "Current space is A" : "Current space is B") + ":" + 
											(env.isClean(0,env.get_agent_location()) ? "Current space status is clean" : "Current space status is dirty"));
					}
				}
				
		
		
//		Agents agent2 = new Agents();
//		agent2.Randonmized_Simple_Reflex_Agent(5,5);
//		agent2.stateAgent(5,5);
	}
}
