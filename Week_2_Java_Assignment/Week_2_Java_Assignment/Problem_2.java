import java.util.Scanner;

/*
 * Problem 2: Word Reversal Encoder
 * Reverses every word in a sentence individually while keeping
 * the word order the same.
 */
public class Problem_2 {

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]);
            reversedWord.reverse();
            result.append(reversedWord);
            if (i != words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();
        System.out.println(reverseEachWord(sentence));
        sc.close();
    }
}
