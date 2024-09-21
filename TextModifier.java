import java.util.Scanner;

public class TextModifier {

    public static String textModifier(String input) {

        String cleanedText = input.trim().replaceAll("\\s+", " ");


        StringBuilder result = new StringBuilder();
        char[] chars = cleanedText.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                if (i > 0 && i < chars.length - 1) {

                    result.setCharAt(result.length() - 1, chars[i + 1]);
                    result.append(chars[i - 1]);
                    i++; 
                }
            } else if (chars[i] != '-') {
                result.append(chars[i]);
            }
        }


        String textAfterPlus = result.toString().replace('+', '!');

        int digitSum = 0;
        StringBuilder finalResult = new StringBuilder();

        for (char ch : textAfterPlus.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitSum += Character.getNumericValue(ch);
            } else {
                finalResult.append(ch);
            }
        }

        if (digitSum > 0) {
            finalResult.append(" ").append(digitSum);
        }

        return finalResult.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String result = textModifier(userInput);
        System.out.println(result);
    }
}
