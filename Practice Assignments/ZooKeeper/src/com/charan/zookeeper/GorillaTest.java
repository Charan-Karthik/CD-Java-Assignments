package com.charan.zookeeper;

public class GorillaTest {
	public static void main(String[] args) {
		
		Mammal test = new Mammal();
//		System.out.println(test.getEnergyLevel());
//		test.displayEnergy();

		Gorilla testGorilla = new Gorilla();
		System.out.println("You see a gorilla in the zoo enclosure");
		testGorilla.displayEnergy();
		testGorilla.throwSomething();
		testGorilla.displayEnergy();
		testGorilla.throwSomething();
		testGorilla.displayEnergy();
		testGorilla.throwSomething();
		testGorilla.displayEnergy();
		testGorilla.eatBananas();
		testGorilla.displayEnergy();
		testGorilla.eatBananas();
		testGorilla.displayEnergy();
		testGorilla.climb();
		testGorilla.displayEnergy();
	}

}
