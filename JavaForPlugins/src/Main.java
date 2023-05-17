import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scInt = new Scanner(System.in);
        Scanner scLine = new Scanner(System.in);

        int a, b;
        String operator;
        boolean isTrue = false;

        System.out.println("Enter your first number: ");
        a = scInt.nextInt();
        System.out.println("Enter your second number: ");
        b = scInt.nextInt();
        System.out.println("Enter your operator: ");
        operator = scLine.nextLine();

         int result = switch(operator){
            case "+"-> a+b;
            case "-"-> a-b;
            case "/"->(int)(a/b);
            case "*"->a*b;
            case "%"->a%b;
            default -> {
                isTrue = true;
                while(isTrue) { // again check
                    System.out.println("Enter your first number again: ");
                    a = scInt.nextInt();
                    System.out.println("Second number: ");
                    b = scInt.nextInt();
                    System.out.println("Enter your operator: ");
                    operator = scLine.nextLine();
                }
                throw new RuntimeException();
            }
        };

        System.out.println(result);



    }
}