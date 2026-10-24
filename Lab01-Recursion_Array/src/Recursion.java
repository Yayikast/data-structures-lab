public class Recursion {

	static int subsum(int n) {
		// Ex1: Alternating sum 1 - 2 + 3 - 4 + ... ± n
		if (n == 1) {
			return 1;
		} else {
			return subsum(n - 1) + (int) (Math.pow(-1, n + 1) * n);
		}
	}

	static int sumDigit(int n) {
		// Ex2: Sum of digits
		if (0 <= n && n <= 9) {
			return n;
		} else {
			return sumDigit(Math.floorDiv(n, 10)) + (n % 10);
		}
	}

	public static int sumEven(int n) {
		// Ex3: Sum of even numbers from 2 up to n
		if (n < 2) {
			return 0;
		} else {
			if (n % 2 == 0) {
				return n + sumEven(n - 2);
			} else {
				return sumEven(n - 1);
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Calculating subsum(10):");
		System.out.println("Your answer is " + subsum(10));
		System.out.println("The correct answer is -5");
		System.out.println("-----------------------");

		System.out.println("sumDigit(123456789)");
		System.out.println("Your answer is " + sumDigit(123456789));
		System.out.println("The correct answer is 45");
		System.out.println("-----------------------");

		System.out.println("Calculating sumEven(10):");
		System.out.println("Your answer is " + sumEven(10));
		System.out.println("The correct answer is 30");
	}
}

