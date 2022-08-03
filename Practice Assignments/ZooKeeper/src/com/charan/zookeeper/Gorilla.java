package com.charan.zookeeper;

public class Gorilla extends Mammal{
	public void throwSomething() {
		System.out.println("The gorilla has thrown something!");
		this.setEnergyLevel(getEnergyLevel()-5);
	}
	
	public void eatBananas() {
		System.out.println("The gorilla is happy because it ate a banana.");
		this.setEnergyLevel(getEnergyLevel()+10);
	}
	
	public void climb() {
		System.out.println("The gorilla climbed a tree.");
		this.setEnergyLevel(getEnergyLevel()-10);
	}
}
