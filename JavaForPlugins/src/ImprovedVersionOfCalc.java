import java.util.Scanner;
import java.util.stream.Stream;

public class ImprovedVersionOfCalc {
    public static Scanner scInt = new Scanner(System.in);
    public static Scanner scLine = new Scanner(System.in);
    public static boolean isTrue = false;
    public static int a, b;
    public static String operator;
    public static String operator1;
    public static int result; //(wait me)
    public static void main(String[] args) {
        ImprovedVersionOfCalc ivc = new ImprovedVersionOfCalc();

        System.out.println("Enter your first number: ");
        a = scInt.nextInt();
        System.out.println("Enter your second number: ");
        b = scInt.nextInt();
        System.out.println("Enter your operator: ");
        operator = scLine.nextLine();
//        ivc.muliple(a,b,operator);

        System.out.println(result);


    }
//    public int muliple (int a, int b,String operator){
//         result = switch (operator) {
//            case "+" -> a + b;
//            case "-" -> a - b;
//            case "/" -> (int) (a / b);
//            case "*" -> a * b;
//            case "%" -> a % b;
//             default-> {
//                    isTrue = true;
//                    while (isTrue) { // again check
//                        System.out.println("Enter your first number again: ");
//                        a = scInt.nextInt();
//                        System.out.println("Second number: ");
//                        b = scInt.nextInt();
//                        System.out.println("Enter your operator: ");
//                        operator = scLine.nextLine();
//                        muliple(a, b, operator);
//                    }
////                    if(isTrue==false){
////                        throw new ;
////                    }
//            }
//        };
//        return result;
//    };
////    public boolean checkValues()
}
