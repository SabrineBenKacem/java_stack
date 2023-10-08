package com.sabrine.zookeeper;

public class Mammal {

	private int energyLevel;
	
	public Mammal() {
		this.energyLevel =100;
	}
	
//	getter & setter

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
//	methods
	public int displayEnergy() {
		System.out.println("Mammal energy level equal to " + getEnergyLevel());
		return getEnergyLevel();
	}
}
