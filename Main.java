package HojaDeTrabajo4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione implementacion de Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        int option = scanner.nextInt();

        Stack<String> operatorStack = null;
        Stack<Integer> valueStack = null;

        switch (option) {

            case 1:
                operatorStack = new StackArrayList<>();
                valueStack = new StackArrayList<>();
                break;

            case 2:
                operatorStack = new StackVector<>();
                valueStack = new StackVector<>();
                break;

            case 3:

                System.out.println("Seleccione tipo de lista:");
                System.out.println("1. Simple");
                System.out.println("2. Doble");

                int listOption = scanner.nextInt();

                if (listOption == 1) {
                    operatorStack = new StackList<>(new SinglyLinkedList<>());
                    valueStack = new StackList<>(new SinglyLinkedList<>());
                } else {
                    operatorStack = new StackList<>(new DoublyLinkedList<>());
                    valueStack = new StackList<>(new DoublyLinkedList<>());
                }
                break;

            default:
                System.out.println("Opcion invalida.");
                scanner.close();
                return;
        }

        InfixToPostfix converter = new InfixToPostfix();
        Calculator calculator = new Calculator(valueStack);

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                // Convertir infix → postfix
                String postfix = converter.convert(line, operatorStack);

                // Evaluar postfix
                int result = calculator.evaluate(postfix);

                System.out.println("Infix: " + line);
                System.out.println("Postfix: " + postfix);
                System.out.println("Resultado: " + result);
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}