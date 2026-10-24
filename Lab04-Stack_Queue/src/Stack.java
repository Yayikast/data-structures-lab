class Stack<T> {

	// Underlying singly linked list for the stack
	private SList<T> list = new SList<T>();

	// Constructor to create an empty stack
	Stack() {
	}

	// Push an element onto the top of the stack
	void push(T element) {
		list.addFirst(element);
	}

	// Remove and return the top element of the stack
	T pop() {
		return list.removeFirst();
	}

	// Return the top element without removing it
	T peek() {
		return list.first.element;
	}

	// Check if the stack is empty
	boolean isEmpty() {
		return list.isEmpty();
	}

	// Return a copy of the stack
	Stack<T> copyStack() {
		Stack<T> rvStack = reverseStack();
		return rvStack.reverseStack();
	}

	// Convert an integer to binary and print it
	static void binaryConversion(int x) {
		Stack<Integer> answer = new Stack<Integer>();
		if (x == 0) {
			answer.push(0);
		}
		while (x > 0) {
			int r = x % 2;
			answer.push(r);
			x = x / 2;
		}
		answer.list.printHorizontal();
	}

	// Reverse the elements of the stack and return a new stack
	Stack<T> reverseStack() {
		Stack<T> S1 = new Stack<T>();
		Stack<T> S2 = new Stack<T>();
		while (!isEmpty()) {
			T e = pop();
			S1.push(e);
			S2.push(e);
		}
		while (!S1.isEmpty()) {
			push(S1.pop());
		}
		return S2;
	}

	// Check if a string is a palindrome (ignoring case)
	static boolean isPalindrome(String word) {
		Stack<Character> S1 = new Stack<Character>();
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			S1.push(word.charAt(i));
		}
		Stack<Character> S2 = S1.reverseStack();
		while (!S1.isEmpty()) {
			if (S1.pop() != S2.pop()) {
				return false;
			}
		}
		return true;
	}

	// Check if a string can be parsed as an integer
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	// Evaluate a postfix expression and return the result
	public static Integer evalPostfix(String[] input) {
		Stack<Integer> S = new Stack<Integer>();
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
			if (isInteger(input[i])) {
				S.push(Integer.parseInt(input[i]));
			} else {
				int y = S.pop();
				int x = S.pop();
				if (input[i].equals("+")) {
					S.push(x + y);
				} else if (input[i].equals("-")) {
					S.push(x - y);
				} else if (input[i].equals("*")) {
					S.push(x * y);
				} else if (input[i].equals("/")) {
					S.push(x / y);
				} else {
					S.push(x % y);
				}
			}
		}
		System.out.println();
		return S.pop();
	}
}

