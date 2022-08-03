import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Greetings " + name;
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis")>-1){
            return "And that's a look at Alexis' best use case.";
        }

        if(conversation.indexOf("Alfred")>-1){
            return "Alfred is the best.";
        }

        return "I bought the bank.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    public String basicGreeting(String name, String name2) {
        return String.format("Hi %s, %s at your service", name, name2);
    }

    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String shout(String somethingToShout){
        return somethingToShout.toUpperCase();
    }
}