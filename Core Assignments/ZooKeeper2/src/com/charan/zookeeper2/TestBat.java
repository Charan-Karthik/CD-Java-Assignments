package com.charan.zookeeper2;

public class TestBat {

	public static void main(String[] args) {
		Bat crazyBat = new Bat();
//		System.out.println(crazyBat.getEnergyLevel());
		System.out.println("A crazy bat appears...");
		crazyBat.displayEnergy();
		crazyBat.attackTown();
		crazyBat.displayEnergy();
		crazyBat.attackTown();
		crazyBat.displayEnergy();
		crazyBat.attackTown();
		crazyBat.displayEnergy();
		crazyBat.eatHumans();
		crazyBat.displayEnergy();
		crazyBat.eatHumans();
		crazyBat.displayEnergy();
		crazyBat.fly();
		crazyBat.displayEnergy();
		crazyBat.fly();
		crazyBat.displayEnergy();
	}

}
