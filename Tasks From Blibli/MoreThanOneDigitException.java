import java.util.Scanner;

class MoreThanOneDigitException extends Exception {
    public MoreThanOneDigitException(String message) {
        super(message);
    }
}
 class MoreThanOneDigitExceptionTest {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        try {
            if (Math.abs(number) > 9) {
                throw new MoreThanOneDigitException("The number has more than one digit: " + number);
            }
            System.out.println("The number is valid: " + number);
        } catch (MoreThanOneDigitException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        scanner.close();
    }
}
