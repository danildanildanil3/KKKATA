import java.util.Scanner;

public class TextModifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
  
        String Text = scanner.nextLine();
        int sum = 0;

     
        StringBuilder modifiedText = new StringBuilder();
        for (int i = 0; i < Text.length()-1; i++) {
            char currentChar = Text.charAt(i);
            boolean flag = true;

            if (Text.charAt(i) == ' ' && i < Text.length() - 1 && Text.charAt(i + 1) != ' ') {
                modifiedText.append(" ");
                flag = false;


            }

            if (Text.charAt(i + 1) == '-' && i < Text.length() - 2) {
                modifiedText.append(Text.charAt(i + 2));
                modifiedText.append(Text.charAt(i));
                flag = false;
                i += 2;

            }


            if (Text.charAt(i) == '+') {
                modifiedText.append('!');
                flag = false;


            }

            if (Character.isDigit(Text.charAt(i))) {
                sum += Character.getNumericValue(Text.charAt(i));
                flag = false;
                if (flag) {
                    modifiedText.append(Text.charAt(i));

                }



            }

        }
        modifiedText.append(sum);


        System.out.println(modifiedText);
    }
}

