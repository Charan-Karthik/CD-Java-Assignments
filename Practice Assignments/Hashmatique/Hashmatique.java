import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("In The End", "I tried so hard and got so far but in the end it doesn't even matter");
        trackList.put("Remember the Name", "This is 10 percent luck, 20 percent skill, 15 percent concentrated power of will, 5 percent pleasure, 50 percent pain, and a 100 percent reason to remember the name");
        trackList.put("Numb", "I've become so numb I can't feel you there I've become so tired so much more aware");
        trackList.put("Warriors", "As a child, you would wait, and watch from far away, but you always knew that you'd be the one that work while they all play");
        trackList.put("What I've Done", "In this farewell, there's no blood, there's no alibi, 'cause I've drawn regret, from the truth of a thousand lies, so let mercy come and wash away, what I've done");

        String oneSongByTrackTitle = trackList.get("Numb");
        // System.out.println("Numb lyrics: " + oneSongByTrackTitle);

        Set<String> keys = trackList.keySet();
        // System.out.println(keys);

        for(String key : keys){
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}


// LEARN PLATFORM HASHMAP EXAMPLE //
        // HashMap<String, String> userMap = new HashMap<String, String>();
        // userMap.put("nninja@codingdojo.com", "Nancy Ninja");
        // userMap.put("ssamurai@codingdojo.com", "Sam Samurai");
        // userMap.put("wwizard@codingdojo.com", "Walter Wizard");
        // // get the keys by using the keySet method
        // Set<String> keys = userMap.keySet();
        // System.out.println(keys);
        // // for(String key : keys) {
        // //     System.out.println(key);
        // //     System.out.println(userMap.get(key));    
        // // }