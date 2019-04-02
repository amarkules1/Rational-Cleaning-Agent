package main.java;
import java.util.Random;

public class BasicEnvironment {
	String[][] environment;
	int rowCt;
	int columnCt;
	int agent_location;

	public BasicEnvironment() {
		this.rowCt = 1;
		this.columnCt = 2;
		this.environment = initRandomEnvironment(1,2);
	}
	
	public String[][] initRandomEnvironment(int i, int j){
		String[][] env = new String[i][j];
		Random r = new Random();
		for(int k = 0; k < i; k++) {
			for(int m = 0; m < j; m++) {
				if(r.nextInt(2)==1) {
					env[k][m] = "dirty";
				}else {
					env[k][m] = "clean";
				}
			}
		}
		return env;
	}
	
	public void clean(int i, int j) {
		this.environment[i][j] = "clean";
	}
	
	public void makeDirty(int i, int j) {
		this.environment[i][j] = "dirty";
	}
	
	public boolean isClean(int i, int j) {
		return this.environment[i][j].equals("clean");
	}

	public String[][] getEnvironment() {
		return environment;
	}

	public void setEnvironment(String[][] environment) {
		this.environment = environment;
	}

	public int getRowCt() {
		return rowCt;
	}

	public void setRowCt(int rowCt) {
		this.rowCt = rowCt;
	}

	public int getColumnCt() {
		return columnCt;
	}

	public void setColumnCt(int columnCt) {
		this.columnCt = columnCt;
	}
	
	public int get_agent_location() {

		return this.agent_location;
	}

	public void set_configuration(int A_status, int B_status, int location) {
		
		this.environment[0][0] = (A_status == 0) ? "clean" : "dirty";
		this.environment[0][1] = (B_status == 0) ? "clean" : "dirty";

		this.agent_location = location;		
	}
	
	public void act(String action) {
		
		if (action == "Suck")
			this.environment[0][this.agent_location] = "clean";
		else if (action == "Right")
			if (this.agent_location == 0)
				this.agent_location = 1;
			else
				System.out.println("\n" + "Movement Error"+ "\n");
		else if (action == "Left")
			if (this.agent_location == 1)
				this.agent_location = 0;
			else
				System.out.println("\n" + "Movement Error"+ "\n");
		else
			System.out.println("\n" + "Movement Error"+ "\n");
	}
}
