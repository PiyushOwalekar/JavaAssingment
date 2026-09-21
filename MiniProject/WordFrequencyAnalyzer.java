import java.util.HashMap;
import java.util.Scanner;

public class WordFrequencyAnalyzer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        input = input.toLowerCase();

        StringBuilder cleanedText = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetterOrDigit(ch) || ch == ' ') {
                cleanedText.append(ch);
            }
        }

        String[] words = cleanedText.toString().split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nWord Frequency:");
        
        for (String word : frequency.keySet()) {
            System.out.println(word + " : " + frequency.get(word));
        }

        sc.close();
    }
}
