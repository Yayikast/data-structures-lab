public class TestStackQueue {

	public static void main(String[] args) {
		// ============================ Ex.1 ============================

		System.out.println("----------------Ex1: Binary Conversion------------");
		// You may comment previous testing of Ex1
		// The correct answer should be :
		// 1 0 0 1 1

		System.out.println("1.1 Finding the binary value of 19 ");
		System.out.print("Your result is : ");
		Stack.binaryConversion(19);

		// The correct answer should be :
		// 0
		System.out.println("1.2 Finding the binary value of 0");
		System.out.print("Your result is : ");
		Stack.binaryConversion(0);

		// The correct answer should be :
		// 1
		System.out.println("1.3 Finding the binary value of 1");
		System.out.print("Your result is : ");
		Stack.binaryConversion(1);

		// The correct answer should be :
		// 1 0 0 0 0 0 0
		System.out.println("1.4 Finding the binary value of 64");
		System.out.print("Your result is : ");
		Stack.binaryConversion(64);

		System.out.println("----------------Ex2 : isPalindrome------------");
		String word1 = "gatemannametag";
		String word2 = "A";
		String word3 = "12340321";
		String word4 = "Reliefpfeiler";

		// The result should be : gatemannametag is a palindrome.
		System.out.println("2.1 Your result is : ");
		System.out.print(word1 + " is ");
		if (!Stack.isPalindrome(word1)) {
			System.out.print("not ");
		}
		System.out.println("a palindrome.");
		System.out.println();

		// The result should be : A is a palindrome.
		System.out.println("2.2 Your result is : ");
		System.out.print(word2 + " is ");
		if (!Stack.isPalindrome(word2)) {
			System.out.print("not ");
		}
		System.out.println("a palindrome.");
		System.out.println();

		// The result should be : 12340321 is not a palindrome.
		System.out.println("2.3 Your result is : ");
		System.out.print(word3 + " is ");
		if (!Stack.isPalindrome(word3)) {
			System.out.print("not ");
		}
		System.out.println("a palindrome.");
		System.out.println();

		// The result should be : Reliefpfeiler is a palindrome.
		System.out.println("Your result is : ");
		System.out.print(word4 + " is ");
		if (!Stack.isPalindrome(word4)) {
			System.out.print("not ");
		}
		System.out.println("a palindrome.");
		System.out.println();

		System.out.println("----------------Ex 3: PostfixEvaluation ------------");
		String[] postfix1 = { "2", "4", "6", "+", "*" };
		String[] postfix2 = { "4", "5", "+", "6", "3", "/", "-" };
		String[] postfix3 = { "5", "3", "+", "4", "*", "2", "-", "6", "/", "7", "%" };

		int answer = Stack.evalPostfix(postfix1);
		// The result should be : 20
		System.out.println("3.1 Your answer for postfix1 : " + answer);

		int answer1 = Stack.evalPostfix(postfix2);
		// The result should be : 7
		System.out.println("3.2 Your answer for postfix2 : " + answer1);

		int answer2 = Stack.evalPostfix(postfix3);
		// The result should be : 5
		System.out.println("3.3 Your answer for postfix3 : " + answer2);
		System.out.println();

		System.out.println("----------------Ex 4: PrefixEvaluation ------------");
		System.out.println("\nTesting isPrefix");
		System.out.println("Expression: + 2 3");
		if (QueueApp.isPrefix("+", "2", "3") == true) {
			System.out.println("Your result is + 2 3 is a prefix expression");
		} else {
			System.out.println("Your result is + 2 3 is not a prefix expression");
		}
		System.out.println("The result should be: + 2 3 is a prefix expression");

		System.out.println("\nExpression: 2 + 3");
		if (QueueApp.isPrefix("2", "+", "3") == true) {
			System.out.println("Your result is : 2 + 3 is a prefix expression");
		} else {
			System.out.println("Your result is : 2 + 3 is not a prefix expression");
		}
		System.out.println("The result should be: 2 + 3 is not a prefix expression");

		System.out.println("\nExpression: 2 3 +");
		if (QueueApp.isPrefix("2", "3", "+") == true) {
			System.out.println("Your result is : 2 3 + is a prefix expression");
		} else {
			System.out.println("Your result is : 2 3 + is not a prefix expression");
		}
		System.out.println("The result should be:2 3 + is not a prefix expression");

		System.out.println("\nTesting prefixEval");
		String[] input1 = { "+", "2", "3" };
		System.out.println("Your Result is " + QueueApp.prefixEval(input1));
		System.out.println("The result should be 5");
		System.out.println();

		String[] input2 = { "*", "+", "2", "3", "+", "1", "7" };
		System.out.println("Your Result is " + QueueApp.prefixEval(input2));
		System.out.println("The result should be 40");
		System.out.println();

		String[] input3 = { "/", "+", "-", "3", "1", "2", "4" };

		// String[] input3 = { "+", "2", "4", "/", "32", "4" };
		System.out.println("Your result is " + QueueApp.prefixEval(input3));
		System.out.println("The result should be 1");
		System.out.println();

		System.out.println("----------------Ex 5: RoundRobin ------------");
		Queue<Integer> RRB = new Queue<Integer>();
		RRB.enqueue(6);
		RRB.enqueue(12);
		RRB.enqueue(4);
		RRB.enqueue(5);
		RRB.enqueue(7);
		RRB.enqueue(9);
		Queue<String> P = new Queue<String>();
		P.enqueue("P1");
		P.enqueue("P2");
		P.enqueue("P3");
		P.enqueue("P4");
		P.enqueue("P5");
		P.enqueue("P6");
		int amount = 40;
		int quota = 3;
		System.out.println("Your result is ");
		QueueApp.makeRoundRobin(RRB, P, quota, amount);

		System.out.println("The correct result should be ");
		System.out.println("40: P1-6 P2-12 P3-4 P4-5 P5-7 P6-9 \n" 
				+ "37: P2-12 P3-4 P4-5 P5-7 P6-9 P1-3 \n"
				+ "34: P3-4 P4-5 P5-7 P6-9 P1-3 P2-9 \n" 
				+ "31: P4-5 P5-7 P6-9 P1-3 P2-9 P3-1 \n"
				+ "28: P5-7 P6-9 P1-3 P2-9 P3-1 P4-2 \n" 
				+ "25: P6-9 P1-3 P2-9 P3-1 P4-2 P5-4 \n"
				+ "22: P1-3 P2-9 P3-1 P4-2 P5-4 P6-6 \n" 
				+ "19: P2-9 P3-1 P4-2 P5-4 P6-6 \n"
				+ "16: P3-1 P4-2 P5-4 P6-6 P2-6 \n" 
				+ "15: P4-2 P5-4 P6-6 P2-6 \n" 
				+ "13: P5-4 P6-6 P2-6 \n"
				+ "10: P6-6 P2-6 P5-1 \n" 
				+ "7: P2-6 P5-1 P6-3 \n" 
				+ "4: P5-1 P6-3 P2-3 \n" 
				+ "3: P6-3 P2-3 \n"
				+ "0: P2-3 ");

	}

}
