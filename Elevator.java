package com.kuali.elevator;

/**
 * The elevator object is mostly a self contained place holder and has minimal functionality
 * and takes orders from central command - all decisions are made at central command.
 * PS. i still like democracy and hate dictators,
 *  but as a programming assignment the modules are easier to design.
 * @author athirumali
 *
 */
public class Elevator {
	
	int id;

	int elevatorAt;
	
	boolean doorOpen;
	
	int floorsTraversed;
	
	int trips;
	
	int floorAt;
	
	boolean serviccerequired;
	
	boolean isIntransit;
	
	boolean directionUp;
	
	public boolean isDirectionUp() {
		return directionUp;
	}

	public void setDirectionUp(boolean directionUp) {
		this.directionUp = directionUp;
	}

	Elevator(int id){
		this.id = id;
	}
	
	public int getFloorAt() {
		return floorAt;
	}

	public void setFloorAt(int floorAt) {
		this.floorAt = floorAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getElevatorAt() {
		return elevatorAt;
	}

	public void setElevatorAt(int elevatorAt) {
		this.elevatorAt = elevatorAt;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public int getFloorsTraversed() {
		return floorsTraversed;
	}

	public void setFloorsTraversed(int floorsTraversed) {
		this.floorsTraversed = floorsTraversed;
	}

	public int getTrips() {
		return trips;
	}

	public void setTrips(int trips) {
		this.trips = trips;
	}

	public boolean isServiccerequired() {
		return serviccerequired;
	}

	public void setServiccerequired(boolean serviccerequired) {
		this.serviccerequired = serviccerequired;
	}

	public boolean isIntransit() {
		return isIntransit;
	}

	public void setIntransit(boolean isIntransit) {
		this.isIntransit = isIntransit;
	} 
	
	/**
	 * complete the trip and set all appropriate parameters.
	 * @param startFloor
	 * @param endFloor
	 */
	public void transport(int startFloor, int endFloor, boolean up){
		
		isIntransit = true;
		directionUp = up;
		openDoor(startFloor);
		closeDoor(startFloor);
		
		//Traverse floor and report.
		int trip = endFloor-startFloor; 
		int finalCount = trip*1000;
		int j = 0 ;
		elevatorAt = startFloor ;
		for(int i=0; i<finalCount; i++){			
			j++;
			if(j==1000){
				if(up){
					elevatorAt++;					
				}else{
					elevatorAt--;
				}
				System.out.println("Elevator no. " + id + " at "+ elevatorAt);
				j=0;
			}
		}		
		
		floorsTraversed += endFloor - startFloor; 
		trips++;
		if(trips==100){
			serviccerequired = true; 
		}
		
		openDoor(endFloor);
		closeDoor(endFloor);
		
		isIntransit = false;
	}
	
	/**
	 * Open elevator door and report - the count delay can be handled better
	 * @param floor
	 */
	private void openDoor(int floor){
		for(int i = 0; i <1000; i++){
			
		}
		System.out.println("Elevator no. "+ id+ " Door opened at floor "+ floor);
	}
	
	/**
	 * Close elevator door and report - the count delay can be handled better
	 * @param floor
	 */
	private void closeDoor(int floor){
		for(int i = 0; i <1000; i++){
			
		}
		System.out.println("Elevator no. "+ id+ " Door closed at floor "+ floor);
	}
	
}
