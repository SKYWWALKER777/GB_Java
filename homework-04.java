import java.util.*;

public class DequeOperations {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        deque1.add(3);
        deque1.add(2);
        deque1.add(1);
        deque1.add(-1);

        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.add(5);
        deque2.add(4);
        deque2.add(3);
        deque2.add(1);

        Deque<Integer> multiplicationResult = multiply(deque1, deque2);
        System.out.println("Multiplication Result: " + multiplicationResult);

        Deque<Integer> additionResult = add(deque1, deque2);
        System.out.println("Addition Result: " + additionResult);
    }

    private static Deque<Integer> multiply(Deque<Integer> deque1, Deque<Integer> deque2) {
        int sign1 = deque1.removeLast();
        int sign2 = deque2.removeLast();
        int sign = sign1 * sign2 < 0 ? -1 : 1;
        Deque<Integer> result = new ArrayDeque<>();

        while (!deque1.isEmpty()) {
            int num1 = deque1.removeLast();
            Deque<Integer> tempResult = new ArrayDeque<>(result);
            int carry = 0;
            result.clear();

            while (!deque2.isEmpty()) {
                int num2 = deque2.removeLast();
                int product = (num1 * num2) + carry;
                result.addFirst(product % 10);
                carry = product / 10;
            }

            if (carry > 0)
                result.addFirst(carry);

            int tempCarry = 0;

            while (!tempResult.isEmpty() || carry > 0) {
                int sum = (tempResult.isEmpty() ? 0 : tempResult.removeFirst()) + carry + tempCarry;
                result.addFirst(sum % 10);
                tempCarry = sum / 10;
            }

            deque2.addAll(tempResult);

            if (!deque1.isEmpty())
                deque1.removeLast();
        }

        if (sign == -1)
            result.addFirst(-1);

        return result;
    }

    private static Deque<Integer> add(Deque<Integer> deque1, Deque<Integer> deque2) {
        if (deque1.isEmpty() && deque2.isEmpty()) {
            return new ArrayDeque<>();
        }

        int sign1 = deque1.isEmpty() ? 1 : deque1.removeLast();
        int sign2 = deque2.isEmpty() ? 1 : deque2.removeLast();
        int sign = sign1 < 0 && sign2 < 0 ? -1 : 1;
        Deque<Integer> result = new ArrayDeque<>();
        int carry = 0;

        while (!deque1.isEmpty() || !deque2.isEmpty() || carry != 0) {
            int num1 = deque1.isEmpty() ? 0 : deque1.removeLast();
            int num2 = deque2.isEmpty() ? 0 : deque2.removeLast();
            int sum = num1 + num2 + carry;
            result.addFirst(sum % 10);
            carry = sum / 10;
        }

        if (sign == -1)
            result.addFirst(-1);

        return result;
    }
}
