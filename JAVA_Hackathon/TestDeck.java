// package com.hackathon.dekofcards;
// import java.util.HashMap;
import java.util.Random;

public class TestDeck {

	public static void main(String[] args) {
		
		// HashMap<String, Integer> hashDeck = new HashMap<String, Integer>();
		Random random = new Random();

		Deck myDeck = new Deck();
		// for (Card card: myDeck.getCards()) {
			// hashDeck.put(card.showCard(), 1);
			// System.out.println(card.showCard());
		// }
		// System.out.println(myDeck.getCards());
		// System.out.println(myDeck.getCards().size());

		int deckSize = myDeck.getCards().size();
		// System.out.println(deckSize);
		
		int points = 0;

// Generating Random Card
		int random1 = random.nextInt(deckSize);
		Card randomCard1 = myDeck.getCards().get(random1);
		// System.out.println(randomCard1);
		String randomCard1String = randomCard1.getName() + " of " + randomCard1.getSuit();

		System.out.println(randomCard1String);
		if(randomCard1.getRank() > 10){
			points += 10;
		} else {
			points += randomCard1.getRank();
		}
		System.out.println("Points: " + points);

		myDeck.getCards().remove(random1);
		deckSize = myDeck.getCards().size();

		int random2 = random.nextInt(deckSize);
		Card randomCard2 = myDeck.getCards().get(random2);
		String randomCard2String = randomCard2.getName() + " of " + randomCard2.getSuit();
		System.out.println(randomCard2String);
		if(randomCard2.getRank() > 10){
			points += 10;
		} else {
			points += randomCard2.getRank();
		}
		System.out.println("Points: " + points);

		myDeck.getCards().remove(random1);
		deckSize = myDeck.getCards().size();

		int randomNumber = 0;
		Card randomCard;

		boolean isPlaying = true;
		while(isPlaying){
			if(points > 21){
				System.out.println("You lost!");
				break;
			} else if(points == 21) {
				System.out.println("You win!");
				break;
			}
			System.out.println("Would you like another card? (y/n)");
			String response = System.console().readLine();
			if(response.equals("n")){
				isPlaying = false;
				System.out.println("Your points: " + points);
				break;
			} else {
				randomNumber = random.nextInt(deckSize);
				randomCard = myDeck.getCards().get(randomNumber);
				System.out.println(randomCard.getName() + " of " + randomCard.getSuit());
				if(randomCard.getRank() > 10){
					points += 10;
				} else {
					points += randomCard.getRank();
				}
				System.out.println("Points: " + points);
			}
		}
		
	}
}
