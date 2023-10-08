package com.sabrine.zookeeper;

public class Bat extends Mammal {

	public Bat() {
		setEnergyLevel(300);
	}
	
	public void fly() {
		setEnergyLevel(getEnergyLevel()-50) ;
		
		System.out.println("Woosh!" + getEnergyLevel());
	}
	
	public void eatHumans() {
		setEnergyLevel(getEnergyLevel()+ 25) ;
		System.out.println("so-well!!! " + getEnergyLevel());
	}
	
	public void attackTown() {
		setEnergyLevel(getEnergyLevel()-100) ;
		System.out.println("oooooh!!!! " + getEnergyLevel());
	}
}
