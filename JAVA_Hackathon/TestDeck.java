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
		// System.out.println(myDeck);
		

// Generating Random Card
		int random1 = random.nextInt(52);
		Card randomCard1 = myDeck.getCards().get(random1);
		// System.out.println(randomCard1);

		String randomCard1String = randomCard1.getName() + " of " + randomCard1.getSuit();
		System.out.println(randomCard1String);

		// System.out.println(hashDeck.get(randomCard1String));
		// hashDeck.replace(randomCard1String, 0);


		
	}
}
