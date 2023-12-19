import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorV3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите два числа от 1 до 10 включительно и знак математического действия (+, -, *, или /) между ними:");
        String input = scan.nextLine();
        int actionInd = -1;
        for (int i = 0; i < signArray.length; i++) {
            if (input.contains(signArray[i])) {
                actionInd = i;
                break;
            }
        }
        if(actionInd==-1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Cтрока не является математической операцией");
            }
            return;
        }
        System.out.println(calc(input));
    }
    public static String calc(String input) {
        int num1;
        int num2;
        String operator;
        String result;
        String[] numbers = input.split("[+\\-*/]");

        if (numbers.length != 2) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
            }
        }
        if ((numList.contains(numbers[0])) && (numList.contains(numbers[1]))) {
            num1 = Integer.parseInt(numbers[0]);
            num2 = Integer.parseInt(numbers[1]);
        }
        else {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "Некорректный ввод чисел";
            }
        }
        operator = actionDetect(input);
        if (num1 > 10 || num2 > 10) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "Числа должны быть от 1 до 10";
            }
        }

        int res = calc(num1, num2, operator);
        result = String.valueOf(res);
        return result;
    }
    static String actionDetect(String expr1) {
        if (expr1.contains("+")) return "+";
        else if (expr1.contains("-")) return "-";
        else if (expr1.contains("*")) return "*";
        else if (expr1.contains("/")) return "/";
        else {
            try {
                throw new Exception();
            } catch (Exception e) {
                return ("Некорректный ввод знака действия");
            }

        }
    }
    static int calc(int a, int b, String action) {
        return switch (action) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };

    }

    static String[] signArray = {"+", "-", "*", "/"};
    static String[] numbersArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static List<String> numList = new ArrayList<>(List.of(numbersArray));

}
