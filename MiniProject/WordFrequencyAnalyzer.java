import java.util.HashMap;
import java.util.Scanner;

public class WordFrequencyAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        // String: convert text to lowercase
        input = input.toLowerCase();

        // StringBuilder: clean the sentence
        StringBuilder cleanedText = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetterOrDigit(ch) || ch == ' ') {
                cleanedText.append(ch);
            }
        }

        // Split sentence into words
        String[] words = cleanedText.toString().split("\\s+");

        // HashMap: store word and its frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Display result
        System.out.println("\nWord Frequency:");
        
        for (String word : frequency.keySet()) {
            System.out.println(word + " : " + frequency.get(word));
        }

        sc.close();
    }
}