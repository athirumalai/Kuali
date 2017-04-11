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
	
	
}
