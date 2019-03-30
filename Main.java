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
					System.out.println("\nStart:" + i + ":" + j + ":" + k + ":" + env.get_agent_location() + ":" + (env.isClean(0,env.get_agent_location()) ? 0 : 1) + "\n");
					for (int l = 0; l < 10; l++) {
						action = agent.Simple_Reflex_Agent(env.get_agent_location(),env.isClean(0,env.get_agent_location()) ? 0 : 1);
						env.act(action);
						System.out.println(i + ":" + j + ":" + k + ":" + l + ":" + action + ":" +  env.get_agent_location() + ":" + (env.isClean(0,env.get_agent_location()) ? 0 : 1));
					}
				}
	}
}
