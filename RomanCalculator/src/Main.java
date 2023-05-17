import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ведите операции сложения, вычитания, умножения и деления с двумя числами \n" +
                "(два римских или два арабских) через пробел: ");
        String FirstString = sc.nextLine();

        String result = calc(FirstString);
        System.out.println("result is :" + result);
    }

    public static String calc(String input) throws Exception {
        Converter converter = new Converter();
        String[] DivString = input.split("\\s");
        if (DivString.length > 3)
            throw new Exception(" Only two values and operand");

        String s1 = DivString[0];
        String operator = DivString[1];
        String s2 = DivString[2];


        converter.checkValid(s1, s2, operator);

        if (converter.isArabic(s1) && converter.isArabic(s2)) {
            input = String.valueOf(converter.computeArab(s1, s2, operator));
        }

//         not completed
        if (converter.isRoman(s1) && converter.isRoman(s2)) {
            input = String.valueOf(converter.computeRoman(s1, s2, operator));
        }

        return input;
    }
}
