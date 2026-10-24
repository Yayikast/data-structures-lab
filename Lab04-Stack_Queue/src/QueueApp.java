public class QueueApp {
	// Check if a string is an integer
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	// Check if the three strings form a prefix expression
	static boolean isPrefix(String x, String y, String z) {
		if (!isInteger(x) && isInteger(y) && isInteger(z))
			return true;
		else
			return false;
	}

	// Evaluate a binary operation in prefix notation
	static String evalPrefixString(String opt, String x, String y) {
		if (opt.equals("+"))
			return "" + (Integer.parseInt(x) + Integer.parseInt(y));
		else if (opt.equals("-"))
			return "" + (Integer.parseInt(x) - Integer.parseInt(y));
		else if (opt.equals("*"))
			return "" + Integer.parseInt(x) * Integer.parseInt(y);
		else if (opt.equals("/"))
			return "" + Integer.parseInt(x) / Integer.parseInt(y);
		else if (opt.equals("%"))
			return "" + Integer.parseInt(x) % Integer.parseInt(y);
		else
			return "can't be evaluated";
	}

	// Evaluate a prefix expression given as an array of strings
	static String prefixEval(String[] input) {
		Queue<String> Q = new Queue<String>();
		for (int i = 0; i < input.length; i++) {
			Q.enqueue(input[i]);
		}

		String x, y, z;
		Q.printHorizontal();
		x = Q.dequeue();
		y = Q.dequeue();
		z = Q.dequeue();
		String temp;

		if (Q.isEmpty()) {
			if (isPrefix(x, y, z)) {
				return evalPrefixString(x, y, z);
			}
		} else {
			do {
				if (isPrefix(x, y, z)) {
					temp = evalPrefixString(x, y, z);
					Q.enqueue(temp);
					if (!Q.isEmpty()) {
						x = Q.dequeue();
						y = Q.dequeue();
						z = Q.dequeue();
					}
				} else {
					Q.enqueue(x);
					x = y;
					y = z;
					if (!Q.isEmpty()) {
						z = Q.dequeue();
					}
				}
			} while (!Q.isEmpty());

			while (!isPrefix(x, y, z)) {
				Q.enqueue(x);
				x = y;
				y = z;
				z = Q.dequeue();
			}
			temp = evalPrefixString(x, y, z);
			Q.enqueue(temp);
		}

		// Simple if-else for readability
		if (!Q.isEmpty()) {
			return Q.dequeue();
		} else {
			return null;
		}
	}

	// Round-robin scheduling simulation
	static void makeRoundRobin(Queue<Integer> Q, Queue<String> P, int limit, int resourceAmt) {
		printRoundRobin(Q, P, resourceAmt);

		while (!Q.isEmpty() && resourceAmt != 0) {
			int temp = Q.dequeue();
			String name = P.dequeue();

			if (limit <= resourceAmt) {
				if (temp >= limit) {
					temp -= limit;
					resourceAmt -= limit;
					if (temp > 0) {
						Q.enqueue(temp);
						P.enqueue(name);
					}
					printRoundRobin(Q, P, resourceAmt);
				} else {
					resourceAmt -= temp;
					temp = 0;
					printRoundRobin(Q, P, resourceAmt);
				}

			} else {
				if (temp > resourceAmt) {
					temp -= resourceAmt;
					resourceAmt = 0;
					Q.enqueue(temp);
					P.enqueue(name);
				} else {
					resourceAmt -= temp;
					temp = 0;
				}
				printRoundRobin(Q, P, resourceAmt);
			}
		}
	}

	// Print current round-robin state
	static void printRoundRobin(Queue<Integer> Q, Queue<String> N, int remain) {
		System.out.print(remain + ": ");
		for (int i = 0; i < Q.list.size; i++) {
			String name = N.dequeue();
			Integer need = Q.dequeue();
			System.out.print(name + "-" + need + " ");
			N.enqueue(name);
			Q.enqueue(need);
		}
		System.out.println();
	}
}
