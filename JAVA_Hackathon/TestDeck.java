// package com.hackathon.dekofcards;
import java.util.HashMap;
import java.util.Random;

public class TestDeck {

	public static void main(String[] args) {
		
		HashMap<String, Integer> hashDeck = new HashMap<String, Integer>();
		Random random = new Random();

		Deck myDeck = new Deck();
		for (Card card: myDeck.getCards()) {
			hashDeck.put(card.showCard(), 1);
			// System.out.println(card.showCard());
		}
		// System.out.println(hashDeck);
		System.out.println(myDeck);
		

		// Deal out two cards
		// System.out.println("Length of hashmap: " + hashDeck.size());

		System.out.println("Length of deck: " + myDeck.getCards().size());
		System.out.println("All Card In ArrayList: " + myDeck.getCards());

// Generating Random Numbers
		// for(int i=0; i<10; i++){
		// 	int random1 = random.nextInt(52);
		// 	System.out.println("Random Number: " + random1);
		// }

		int random1 = random.nextInt(52);
		Card randomCard1 = myDeck.getCards().get(random1);
		// System.out.println(randomCard1.getSuit() + randomCard1.getRank() + randomCard1.getName());
		System.out.println("Card selected is: " + randomCard1.getName() + " of " + randomCard1.getSuit());

		String randomCard1String = randomCard1.getName() + " of " + randomCard1.getSuit();
		System.out.println(randomCard1String);
	}
}
