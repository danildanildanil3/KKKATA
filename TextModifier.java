import java.util.Scanner;

public class TextModifier {

    public static String textModifier(String input) {
        // Условие a: Удаляем лишние пробелы
        String cleanedText = input.trim().replaceAll("\\s+", " ");

        // Условие b: Меняем местами символы вокруг знака минус
        StringBuilder result = new StringBuilder();
        char[] chars = cleanedText.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                if (i > 0 && i < chars.length - 1) {
                    // Меняем местами символы
                    result.setCharAt(result.length() - 1, chars[i + 1]);
                    result.append(chars[i - 1]);
                    i++; // Пропускаем следующий символ
                }
            } else if (chars[i] != '-') {
                result.append(chars[i]);
            }
        }

        // Условие c: Заменяем знак плюс на восклицательный знак
        String textAfterPlus = result.toString().replace('+', '!');

        // Условие d: Считаем сумму цифр и удаляем их из текста
        int digitSum = 0;
        StringBuilder finalResult = new StringBuilder();

        for (char ch : textAfterPlus.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitSum += Character.getNumericValue(ch);
            } else {
                finalResult.append(ch);
            }
        }

        // Добавляем сумму цифр, если она больше нуля
        if (digitSum > 0) {
            finalResult.append(" ").append(digitSum);
        }

        return finalResult.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String userInput = scanner.nextLine();
        String result = textModifier(userInput);
        System.out.println(result);
    }
}
