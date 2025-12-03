package Driver;

public class ShuntingYardCalculator {

    // Check if char is operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Operator precedence
    private static int precedence(char op) {
        switch (op) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
        }
        return 0;
    }

    // Exponent is right associative
    private static boolean isRightAssociative(char op) {
        return op == '^';
    }

    // Validate parentheses
    public static boolean isValidExpression(String exp) {

        // Force use of java.util.Stack 
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : exp.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // Infix → Postfix 
    public static String infixToPostfix(String expression) {
        expression = expression.replaceAll("\\s+", "");

        StringBuilder output = new StringBuilder();

        java.util.Stack<Character> operators = new java.util.Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Multi-digit number
            if (Character.isDigit(c)) {
                while (i < expression.length() &&
                      (Character.isDigit(expression.charAt(i)) ||
                       expression.charAt(i) == '.')) {
                    output.append(expression.charAt(i));
                    i++;
                }
                output.append(" ");
                i--;
            }

            // Operator
            else if (isOperator(c)) {
                while (!operators.isEmpty() &&
                        isOperator(operators.peek()) &&
                        ((precedence(c) < precedence(operators.peek())) ||
                        (precedence(c) == precedence(operators.peek()) &&
                        !isRightAssociative(c)))) {

                    output.append(operators.pop()).append(" ");
                }
                operators.push(c);
            }

            else if (c == '(') {
                operators.push(c);
            }

            else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.append(operators.pop()).append(" ");
                }
                if (!operators.isEmpty()) operators.pop(); // remove '('
            }
        }

        while (!operators.isEmpty()) {
            output.append(operators.pop()).append(" ");
        }

        return output.toString().trim();
    }

    // Evaluate Postfix
    public static double evaluatePostfix(String postfix) {

        java.util.Stack<Double> stack = new java.util.Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                    case "^": stack.push(Math.pow(a, b)); break;
                }
            }
        }

        return stack.pop();
    }

    // Main
    public static void main(String[] args) {
        String[] tests = {
                "(3 + 4) * 2 / (1 - 5)",
                "2 ^ 3 ^ 2",
                "10 + 2 * 6",
                "(5 + 3) * (2 - 8) / 2"
        };

        for (String expression : tests) {
            System.out.println("Input: " + expression);

            if (!isValidExpression(expression)) {
                System.out.println("Invalid expression: Unbalanced parentheses\n");
                continue;
            }

            String postfix = infixToPostfix(expression);
            System.out.println("Postfix: " + postfix);

            double result = evaluatePostfix(postfix);
            System.out.println("Result: " + result + "\n");
        }
    }
}
