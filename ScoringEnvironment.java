package main.java;

import java.util.Random;

public class ScoringEnvironment {
	String[][] environment;
	int rowCt;
	int columnCt;
	int[] agent_location;
	long moveCt;

	public ScoringEnvironment(int rowCt, int colCt) {
		this.rowCt = rowCt;
		this.columnCt = colCt;
		this.environment = initRandomEnvironment(rowCt,colCt);
		this.agent_location = new int[2];
		this.agent_location[0] = 0;
		this.agent_location[1] = 0;
		this.moveCt = 0;
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
		return this.environment[i][j].equalsIgnoreCase("clean");
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
	
	public int[] get_agent_location() {

		return this.agent_location;
	}

	public void set_configuration(String[][] env, int[] location) {
		this.agent_location = location;
		this.environment = env;	
	}
	
	public void act(String action) {
		
//		System.out.println(moveCt + ":" + this.agent_location[0] + ":" + this.agent_location[1]);
		if (action == "Suck")
			this.environment[this.agent_location[0]][this.agent_location[1]] = "clean";
		else if (action == "Right"){
			if((this.agent_location[1]+1)>=columnCt) {
				//System.out.println("\n" + "Movement Error"+ "\n");
			}else {
				moveCt++;
				this.agent_location[1]++;
			}
		}
		else if (action == "Left") {
			if(this.agent_location[1]<=0) {
				//System.out.println("\n" + "Movement Error"+ "\n");
			}else {
				moveCt++;
				this.agent_location[1]--;
			}
		}
		else if( action.equals("Up")) {
			if((this.agent_location[0]+1)>=rowCt) {
				//System.out.println("\n" + "Movement Error"+ "\n");
			}else {
				moveCt++;
				this.agent_location[0]++;
			}
		}else if(action.equals("Down")) {
			if(this.agent_location[0]<=0) {
				//System.out.println("\n" + "Movement Error"+ "\n");
			}else {
				moveCt++;
				this.agent_location[0]--;
			}
		}
		else
			System.out.println("\n" + "Movement Error"+ "\n");
	}
	
	public boolean isDone() {
		boolean dirtySquare = false;
		for(int i = 0; i < rowCt; i++) {
			for(int j = 0; j < columnCt; j++) {
				if(this.environment[i][j].equalsIgnoreCase("dirty")){
					dirtySquare = true;
				}
			}
		}
		if(!dirtySquare) {
			System.out.println("Cleaned all squares in "+ this.moveCt + " moves.");
		}
		return !dirtySquare;
	}
	public long getMoveCt() {
		return this.moveCt;
	}
}
