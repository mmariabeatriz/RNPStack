import java.util.Scanner;
import java.util.Stack;

public class RPN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  
        System.out.println("Bem-vindo a calculadora! (Digite SAIR para encerrar)");
        System.out.println("Digite inicie a operação desejada:");

        Stack<Integer> stack = new Stack<>();
        String input = "";

        while (!input.equals("SAIR")) {

            input = in.next();

            if (isInt(input)) {
                stack.push(Integer.parseInt(input));
            } else if (isOp(input)) {
                int current = parseOp(input, stack);
                System.out.println(current);
                stack.push(current);
            }
        }
    }

    public static int calculate(String operation, int left, int right) {
        if (operation.equals("+")) {
            return left + right;
        }else if (operation.equals("-")) {
            return left - right;
        }else if (operation.equals("*")) {
            return left * right;
        }else if (operation.equals("/")) {
            return left / right;
        }else {
            return left;
        }
    }
    
    public static boolean isOp(String input) {
        if (input == null) return false;

        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    public static boolean isInt(String input) {
        if (input == null) return false;

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    public static int parseOp(String operation, Stack<Integer> stack) {
        int output = stack.pop();

        if (!stack.empty()) {
            output = calculate(operation, stack.pop(), output);
        }

        return output;
    }  
   
}