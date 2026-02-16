public class InfixToPostfix {

    public String convert(String expression, Stack<String> stack) {

        // Limpiar el stack por si se reutiliza
        while (!stack.isEmpty()) {
            stack.pop();
        }

        StringBuilder output = new StringBuilder();
        int i = 0;

        while (i < expression.length()) {

            char c = expression.charAt(i);

            // Ignorar espacios
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            // Si es número (puede ser de varios dígitos)
            if (Character.isDigit(c)) {

                StringBuilder number = new StringBuilder();

                while (i < expression.length() &&
                        Character.isDigit(expression.charAt(i))) {

                    number.append(expression.charAt(i));
                    i++;
                }

                output.append(number).append(" ");
                continue;
            }

            // Si es '('
            if (c == '(') {
                stack.push(String.valueOf(c));
            }

            // Si es ')'
            else if (c == ')') {

                while (!stack.isEmpty() &&
                        !stack.peek().equals("(")) {

                    output.append(stack.pop()).append(" ");
                }

                // Eliminar el '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Si es operador
            else if (isOperator(c)) {

                while (!stack.isEmpty() &&
                        precedence(stack.peek().charAt(0)) >= precedence(c)) {

                    output.append(stack.pop()).append(" ");
                }

                stack.push(String.valueOf(c));
            }

            i++;
        }

        // Vaciar el stack al final
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    private boolean isOperator(char c) {
        return c == '+' ||
               c == '-' ||
               c == '*' ||
               c == '/' ||
               c == '%';
    }

    private int precedence(char c) {

        if (c == '+' || c == '-') return 1;

        if (c == '*' || c == '/' || c == '%') return 2;

        return 0;
    }
}