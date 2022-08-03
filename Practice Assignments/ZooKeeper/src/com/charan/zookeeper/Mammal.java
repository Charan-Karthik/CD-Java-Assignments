package com.charan.zookeeper;

public class Mammal {
	private int energyLevel = 100;
	
// METHODS
	public int displayEnergy() {
		System.out.println("Energy Level: " + this.getEnergyLevel());
		return this.getEnergyLevel();
	}
	
// 	GETTERS AND SETTERS
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
