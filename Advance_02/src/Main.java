import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("NHập số ISBN 10 numbe");
        String numberISBN = scanner.nextLine();


        if (numberISBN.length() != 10) {
            System.out.println(" ISBN cần có 10 digits");
            return;
        }
        int sum = 0;
        Stack<Integer> digits = new Stack<>();
        try {
            for (int i = 0; i < 10; i++) {
                int digit = Character.getNumericValue(numberISBN.charAt(i));
                digits.push(digit);
            }
            int mul = 1;

            while (!digits.isEmpty()) {
                sum += mul * digits.pop();
                mul++;
            }
            if (sum % 11 == 0) {
                System.out.println("ISBN Valid ");
            } else {
                System.out.println("ISBN Invalid");
            }
        } catch (Exception e) {
            System.out.println("Invalid, Input number, please try again");
        }
    }
}