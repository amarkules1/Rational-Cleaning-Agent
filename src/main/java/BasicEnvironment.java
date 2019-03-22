package main.java;
import java.util.Random;

public class BasicEnvironment {
	String[][] environment;
	int rowCt;
	int columnCt;
	

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
	
	
}
