package main.java.com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        if (op == null) {
            return 0;
        }

        return switch (op) {
            case "add", "add-again" -> a + b;
            case "sub", "sub-again" -> a - b;
            case "mul" -> a * b;
            case "div" -> (b == 0) ? 0 : a / b;
            case "mod" -> (b == 0) ? 0 : a % b;
            case "pow" -> (int) Math.pow(a, b);
            default -> 0;
        };
    }
}