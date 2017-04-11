package com.kuali.elevator;



class ElevatorCentralComand {
	
    private static final int groundFloor = 1;
	
	private static final int topFloor = 10;
	
	private Elevator elevators[];
			
	public ElevatorCentralComand(){
		for(int i=0; i<10; i++){
			Elevator elevator = new Elevator((i+1));
			elevators[i] = elevator;
		}	
	}
	
	
	
}


/**
 * 
 * @author athirumali
 *
 */
public class ElevatorController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElevatorCentralComand ecentralCmd = new ElevatorCentralComand();
		
		
	}

}