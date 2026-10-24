public class Array {
	final int size; // Maximum capacity of the array A
	int[] A;
	int load = 0; // Current number of elements stored in A

	Array(int n) {
		size = n;
		A = new int[size];
	}

	// Ex4 a — Insert element at the beginning of the array
	void addFirst(int e) {
		if (load >= size) {
			return;
		}
		for (int i = load; i > 0; i--) {
			A[i] = A[i - 1];
		}
		A[0] = e;
		load++;
	}

	// Ex4 b — Insert element at the end of the array
	void addLast(int e) {
		if (load >= size) {
			return;
		}
		A[load] = e;
		load++;
	}

	// Ex4 c — Insert element at a specific index
	void addAtIndex(int e, int index) {
		if (load >= size || index < 0 || index > load) {
			return;
		}
		for (int i = load; i > index; i--) {
			A[i] = A[i - 1];
		}
		A[index] = e;
		load++;
	}

	// Ex4 d — Remove and return the first element
	int removeFirst() {
		if (load == 0) {
			return -1;
		}
		int temp = A[0];
		for (int i = 0; i < load - 1; i++) {
			A[i] = A[i + 1];
		}
		load--;
		return temp;
	}

	// Ex4 e — Remove and return the last element
	int removeLast() {
		if (load == 0) {
			return -1;
		}
		int temp = A[load - 1];
		load--;
		return temp;
	}

	// Ex4 f — Remove and return the element at a specific index
	int removeAtIndex(int index) {
		if (load == 0 || index < 0 || index >= load) {
			return -1;
		}
		int temp = A[index];
		for (int i = index; i < load - 1; i++) {
			A[i] = A[i + 1];
		}
		load--;
		return temp;
	}

	// Ex4 g — Return the value stored at a specific index
	int getElementAtIndex(int index) {
		return A[index];
	}

	// Ex4 h — Set the value at a specific index
	void setElementAtIndex(int val, int index) {
		A[index] = val;
	}

	// Print the current array and its load
	void printArray() {
		for (int i = 0; i < load; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("\nArray load is " + load);
	}

	// Ex5 — Find if there exists a pair of elements that sum to a target value
	// Works only when the array is sorted in ascending order
	boolean findPairWithSum(int sum) {
		if (load < 2) {
			return false;
		}

		// Two-pointer technique
		int left = 0;
		int right = load - 1;

		while (left < right) {
			int currentSum = A[left] + A[right];

			if (currentSum == sum) {
				return true; // Pair found
			} else if (currentSum < sum) {
				left++; // Increase sum by moving left pointer right
			} else {
				right--; // Decrease sum by moving right pointer left
			}
		}
		return false; // No matching pair found
	}

	public static void main(String[] args) {
		Array A = new Array(10);

		// Ex4 a — Test addFirst
		A.addFirst(9);
		A.addFirst(1);
		A.addFirst(4);
		System.out.println("After addFirst 9, 1, and 4 to A");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n4 1 9 \nArray load is 3");

		// Ex4 b — Test addLast
		System.out.println("----------------------------------");
		A.addLast(2);
		A.addLast(5);
		A.addLast(8);
		System.out.println("After addLast 2, 5, and 8 to A");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n4 1 9 2 5 8 \nArray load is 6");

		// Ex4 c — Test addAtIndex
		System.out.println("----------------------------------");
		A.addAtIndex(6, 2);
		A.addAtIndex(3, 4);
		System.out.println("After add 6 at index 2, and add 3 at index 4 to A");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n4 1 6 9 3 2 5 8 \nArray load is 8");

		// Ex4 d — Test removeFirst
		System.out.println("----------------------------------");
		A.removeFirst();
		A.removeFirst();
		System.out.println("After removeFirst twice");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 9 3 2 5 8 \nArray load is 6");

		// Ex4 e — Test removeLast
		System.out.println("----------------------------------");
		A.removeLast();
		A.removeLast();
		System.out.println("After removeLast twice");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 9 3 2 \nArray load is 4");

		// Ex4 f — Test removeAtIndex
		System.out.println("----------------------------------");
		A.removeAtIndex(1);
		A.removeAtIndex(1);
		System.out.println("After removeAtIndex 1 twice");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 2 \nArray load is 2");

		// Ex4 g — Test setElementAtIndex
		System.out.println("----------------------------------");
		A.setElementAtIndex(7, 1);
		System.out.println("After set value at index 1 to 7");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 7 \nArray load is 2");

		// Ex4 h — Test getElementAtIndex
		System.out.println("----------------------------------");
		System.out.println("Your Answer is");
		System.out.println("Value at A[1]= " + A.getElementAtIndex(1));
		System.out.println("Correct Answer is\nValue at A[1]= 7");

		// Ex5 — Test findPairWithSum
		System.out.println("----------------------------------");
		A.addLast(7);
		A.addLast(9);
		A.addLast(9);
		A.addLast(11);
		A.addLast(11);
		A.addLast(11);
		System.out.println("After adding 7, 9, 9, 11, 11, 11 to A");
		System.out.println("Your Answer is");
		A.printArray();
		System.out.println("Correct Answer is\n6 7 7 9 9 11 11 11 \nArray load is 8");

		System.out.println("----------------------------------");
		int sum = 20;
		System.out.println("Your Answer for findPairWithSum(" + sum + "): " + A.findPairWithSum(sum));
		System.out.println("Correct Answer for findPairWithSum(" + sum + "): true");
	}
}



