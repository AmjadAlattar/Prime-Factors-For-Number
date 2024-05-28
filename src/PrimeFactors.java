import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a whole number (-1 to exit): ");
        int number = scanner.nextInt();

        while (number != -1) {
            if (isPrime(number)) {
                System.out.println(number + " is a prime number.");
            } else {
                Set<Integer> primeFactors = calculatePrimeFactors(number);
                System.out.println("Prime factors of " + number + ": " + primeFactors);
            }

            System.out.print("Enter a whole number (-1 to exit): ");
            number = scanner.nextInt();
        }

        scanner.close();
    }

    // Check if a number is prime
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Calculate the prime factors of a number
    public static Set<Integer> calculatePrimeFactors(int number) {
        Set<Integer> primeFactors = new HashSet<>();

        for (int i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }

        if (number > 1) {
            primeFactors.add(number);
        }

        return primeFactors;
    }
}
