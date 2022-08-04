// package com.hackathon.dekofcards;
// import java.util.HashMap;
import java.util.Random;

public class TestDeck {

	public static void main(String[] args) {
		Random random = new Random();
		Deck myDeck = new Deck();

		int deckSize = myDeck.getCards().size();
// Test to make sure deck size is 52
		// System.out.println(deckSize);
		
		
		int points = 0;
		int dealer = 0;
// Player Random Card #1
		int random1 = random.nextInt(deckSize);
		Card randomCard1 = myDeck.getCards().get(random1);
		String randomCard1String = randomCard1.getName() + " of " + randomCard1.getSuit();

		System.out.println("You were dealt: " + randomCard1String);
		if(randomCard1.getRank() > 10){
			points += 10;
		} else {
			points += randomCard1.getRank();
		}
		System.out.println("Your points: " + points);
		System.out.println("");

		myDeck.getCards().remove(random1);
		deckSize = myDeck.getCards().size();
		// System.out.println(deckSize);


// Dealer Random Card #1
		int dealer1 = random.nextInt(deckSize);
		Card dealerCard1 = myDeck.getCards().get(dealer1);
		String dealerCard1String = dealerCard1.getName() + " of " + dealerCard1.getSuit();

		System.out.println("Dealer has drawn: " + dealerCard1String);
		System.out.println("");
		if(dealerCard1.getRank() > 10){
			dealer += 10;
		} else {
			dealer += dealerCard1.getRank();
		}

		myDeck.getCards().remove(dealer1);
		deckSize = myDeck.getCards().size();
		// System.out.println(deckSize);


// Player Random Card #2
		int random2 = random.nextInt(deckSize);
		Card randomCard2 = myDeck.getCards().get(random2);
		String randomCard2String = randomCard2.getName() + " of " + randomCard2.getSuit();
		System.out.println("You were delt: " + randomCard2String);
		if(randomCard2.getRank() > 10){
			points += 10;
		} else {
			points += randomCard2.getRank();
		}
		System.out.println("Your points: " + points);
		System.out.println("");

		myDeck.getCards().remove(random1);
		deckSize = myDeck.getCards().size();
		// System.out.println(deckSize);


// Dealer Random Card #2
int dealer2 = random.nextInt(deckSize);
		Card dealerCard2 = myDeck.getCards().get(dealer2);
		String dealerCard2String = dealerCard2.getName() + " of " + dealerCard2.getSuit();

		System.out.println("Dealer draws another card and places it face down.");
		System.out.println("");
		if(dealerCard2.getRank() > 10){
			dealer += 10;
		} else {
			dealer += dealerCard2.getRank();
		}

		myDeck.getCards().remove(dealerCard2);
		deckSize = myDeck.getCards().size();
		// System.out.println(deckSize);


// Player decides whether or not to continue
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
			System.out.println("");
			if(response.equals("n")){
				isPlaying = false;
				System.out.println("Your points: " + points);
				System.out.println("Dealer points: " + dealer);

// While loop for dealer
				int dealerNumber = 0;
				Card dealerCard;
				while(dealer < 15) {
					dealerNumber = random.nextInt(deckSize);
					dealerCard = myDeck.getCards().get(dealerNumber);
					System.out.println("Dealer draws "+ dealerCard.getName() + " of " + dealerCard.getSuit());
					if(dealerCard.getRank() > 10){
						dealer += 10;
					} else {
						dealer += dealerCard.getRank();
					}
					myDeck.getCards().remove(dealerCard);
					deckSize = myDeck.getCards().size();
					// System.out.println(deckSize);
					System.out.println("Dealer points: " + dealer);
				}
				
				if(dealer > points && dealer < 22){
					System.out.println("You lose!");
				} else {
					System.out.println("You win!");
		}
				break;
			} else {
				randomNumber = random.nextInt(deckSize);
				randomCard = myDeck.getCards().get(randomNumber);
				System.out.println("You were dealt " + randomCard.getName() + " of " + randomCard.getSuit());
				if(randomCard.getRank() > 10){
					points += 10;
				} else {
					points += randomCard.getRank();
				}
				System.out.println("Your points: " + points);

				myDeck.getCards().remove(randomCard);
				deckSize = myDeck.getCards().size();
			}
		}
	}
}
