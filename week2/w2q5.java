package week2;
import java.util.HashMap;
import java.util.Map;
public class w2q5 {
    static void printFilteredWordFrequency(String feedback) {

        String text = feedback.toLowerCase();

        text = text.replace(".", "");
        text = text.replace(",", "");

        String[] words = text.split("\\s+");

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            boolean stopWord = false;

            for (int j = 0; j < stopWords.length; j++) {

                if (words[i].equals(stopWords[j])) {
                    stopWord = true;
                    break;
                }
            }

            if (!stopWord) {
                frequency.put(words[i],
                        frequency.getOrDefault(words[i], 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String feedback = "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
