package simpleCalculator.java;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = 0, num2 = 0;
        String operator;
        boolean validInput = false;

        // Get first number
        while (!validInput) {
            System.out.print("Enter first number: ");
            try {
                num1 = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric value.");
            }
        }

        // Get operator
        System.out.print("Enter operator (+, -, *, /): ");
        operator = scanner.nextLine().trim();

        // Get second number
        validInput = false;
        while (!validInput) {
            System.out.print("Enter second number: ");
            try {
                num2 = Double.parseDouble(scanner.nextLine());
                if (operator.equals("/") && num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric value.");
            }
        }

        // Perform operation
        double result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case "-":
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case "*":
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case "/":
                result = num1 / num2;
                System.out.println("Result: " + result);
                break;
            default:
                System.out.println("Invalid operator. Please use one of +, -, *, /.");
        }

        scanner.close();
    }
}
