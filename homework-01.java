//1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число n: ");
        int n = sc.nextInt();

        int triangleNumber = 0;
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            triangleNumber += i;
            factorial *= i;
        }

        System.out.println("Треугольное число: " + triangleNumber);
        System.out.println("Факториал: " + factorial);
    }
}
// 2) Вывести все простые числа от 1 до 1000
public class Main {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
//3) Реализовать простой калькулятор
//+ - / *

//Введите первое число: A \n
//Введите знак: *
//Введите второе число: B
//Результат: A*B

//sc.next() -- считывает символ
//sc.nextLine() -- считывает всю строчку
//sc.nextInt() -- считывает число, но без перехода на след. строчку
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double num1 = sc.nextDouble();

        System.out.print("Введите знак операции (+, -, *, /): ");
        String operator = sc.next();

        System.out.print("Введите второе число: ");
        double num2 = sc.nextDouble();

        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Ошибка: деление на ноль");
                    return;
                }
                break;
            default:
                System.out.println("Ошибка: неверный знак операции");
                return;
        }

        System.out.println("Результат: " + result);
    }
}
