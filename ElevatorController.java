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
	
	/**
	 * Again make it simple - the elevators are lined up in a row 1 - thru - 10.
	 * @param startFloor
	 * @param elevatorId
	 * @param up
	 * @return
	 */
	private int getElevatorforTransport(int startFloor, int elevatorId, boolean up){
		
		/**
		 * This flat out pseudo code.When i say check use the flag. 
		 */		
		// 1. Left corner most elevator. 
		// 2. Loop thru from 0 to 9 
		// 3. Check if any of elevators are in transit - if yes - if in same direction - yes - if on floor beloew or above requested floor depending on the direction RETURN ID of that elevator. PRIORITY 1 - BREAK
												      //    4. if no 
														    //    5. if any elevator is already on that floor return that elevator id. PRIORITY 2 -- BREAK
															//	  6. else step thru and see which elevator is on closest floor - subtract current floor next elevators floor hold on to it, do same with next subscript 
															//    7. if this value is lower hold on to this and subsequently figure out the lowest value that way and grab that elevators index and return it. -- PRIORITY 3 -- BREAK.
		
		// 8. Right corner most elevator.
		// 9. Loop thru from 9 to 0 and use the same logic.
		// 10. repeat 3 thru 7 and return elevator index.
		
		// 11.  If the request is from the center - perform 3 thru 7 twice from center to 0 and from center to 9
		// 12. compare the two results by subtracting the elevator id to the elevator index returned from either side and the closest one wins YAE!!!
		
		return 1;
	}
	
	
	private void stopMovingElevator(int elevatorId, int requestedFloor){
		for(int i=0; i<11000;i++){
			//give this time just for logic reasons 
		}
		elevators[elevatorId].setElevatorAt(requestedFloor);
		elevators[elevatorId].setIntransit(false);
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