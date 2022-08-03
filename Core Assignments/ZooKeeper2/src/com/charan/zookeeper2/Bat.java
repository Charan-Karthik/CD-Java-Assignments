package com.charan.zookeeper2;

public class Bat extends Mammal{
	
	public Bat() {
		this.setEnergyLevel(300);
	}
	
	public void fly() {
		if(this.getEnergyLevel() < 50) {
			System.out.println("Phew, the bat is low on energy.");
		} else {			
			System.out.println("WOOSH");
			this.setEnergyLevel(getEnergyLevel()-50);
		}
	}
	
	public void eatHumans() {
		this.setEnergyLevel(getEnergyLevel()+25);
	}
	
	public void attackTown() {
		if(this.getEnergyLevel() < 50) {
			System.out.println("Phew, the bat is low on energy.");
		} else {
			System.out.println("crackle");
			this.setEnergyLevel(getEnergyLevel()-100);	
		}
	}
}
