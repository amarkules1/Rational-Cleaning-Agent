package main.java;

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
}
