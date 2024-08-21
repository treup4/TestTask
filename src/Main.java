import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e){
            System.out.println("Ошибка: неверный формат числа, введите целые числа.");
        } catch (IOException e) {
            System.out.println("Ошибка: неверный формат ввода, пример: a + b");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: допустымые числа от 1 до 10 включительно");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: допустимые операции +, -, *, /");
        }
    }

    public static String calc(String input) throws IOException {
        if (input.isEmpty()) throw new IOException();

        int result = 0;
        String[] elements = input.split(" ");

        if (elements.length != 3) throw new IOException();
        if (elements[1].length() > 1) throw new ArithmeticException();

        int a = Integer.parseInt(elements[0]);
        int b = Integer.parseInt(elements[2]);

        if (a<1 || a>10 || b<1 || b>10) throw new IndexOutOfBoundsException();

        char operation = elements[1].charAt(0);

        switch (operation) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': result = a / b; break;
            default: throw new ArithmeticException();
        }

        return String.valueOf(result);
    }
}