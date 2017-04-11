package com.kuali.elevator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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
	
	/**
	 * Perform service on all elevators, We'll keep it simple and do it all at once may be once a 
	 * day on the ground floor.
	 */
	public void serviceAll(){
		for(int i=0; i<10; i++){
			elevators[i].elevatorAt = 0;
			elevators[i].floorsTraversed = 0;
			elevators[i].trips = 0;
			elevators[i].serviccerequired = false;
		}
	}
	
	public void serviceScheduled(){
		for(int i=0; i<10; i++){
			if(elevators[i].isServiccerequired()){
				elevators[i].elevatorAt = 0;
				elevators[i].floorsTraversed = 0;
				elevators[i].trips = 0;
				elevators[i].serviccerequired = false;
			}
		}
	}
	
	/**
	 * Runs thru the day every 10 mins and every elevator requiring service will be serviced. 
	 * 10 mins for programming purpose realistically we need to know how we are using the elevators
	 */
	public void scheduledService(){
		try{
			ScheduledExecutorService scheduledExecutorService =
			        Executors.newScheduledThreadPool(5);	
			ScheduledFuture scheduledFuture =
			    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			        @Override
			        public void run() {
			        	serviceScheduled();
			        }
			    }, 0, 600L , TimeUnit.SECONDS);	
			System.out.println("result = " + scheduledFuture.get());	
			scheduledExecutorService.shutdown();
		}catch(ExecutionException eE){
			eE.printStackTrace();
		}catch(InterruptedException iE){
			iE.printStackTrace();
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
		ecentralCmd.serviceAll();
		
		//as many requests as needed.
		//ecentralCmd.handleTransportrequest(1, 5, 1, true);
		//ecentralCmd.scheduledService();
		
	}

}