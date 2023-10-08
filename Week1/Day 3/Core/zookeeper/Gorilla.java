package com.sabrine.zookeeper;

public class Gorilla extends Mammal{
	
	
	
//	methods
	public void throwSomething() {
		setEnergyLevel(getEnergyLevel()-5) ;
		System.out.println("The gorilla has throw something at you!!: " + getEnergyLevel());
	
	}
	
	public void  eatBananas() {
		setEnergyLevel(getEnergyLevel() + 10) ;
		System.out.println("The gorilla increasing his energy by eating banana!!!!: " + getEnergyLevel());
	}
	
	public void clumb() {
		setEnergyLevel(getEnergyLevel() - 10) ;
		System.out.println("The gorilla climbs a nearby tree and his energy decreased to !!!: " + getEnergyLevel());
	}

}
