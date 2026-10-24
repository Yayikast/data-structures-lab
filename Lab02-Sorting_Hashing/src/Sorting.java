public class Sorting {

	// ======================= SWAP ===========================
	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// ======================= PRINT ==========================
	static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	// ================= FIND INDEX SMALLEST ===================
	static int findIndexSmallest(int[] A, int start, int end) {
		int minIndex = start;
		for (int j = start; j < end; j++) {
			if (A[j] < A[minIndex]) {
				minIndex = j;
			}
		}
		return minIndex;
	}

	// ===================== SELECTION SORT ====================
	static void SelectionSort(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			int minIndex = findIndexSmallest(A, i, A.length);
			swap(A, i, minIndex);
			printArray(A);
		}
	}

	// ===================== INSERTION SORT ====================
	static void InsertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int temp = A[i];
			int j = i - 1;

			while (j >= 0 && A[j] > temp) {
				A[j + 1] = A[j]; // shift right
				j--;
			}

			A[j + 1] = temp; // insert
			printArray(A);
		}
	}

	// ====================== MERGE SORT =======================
	private static void RecursiveMergeSort(int[] A) {
		int n = A.length;

		if (n < 2) {
			return;
		}

		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = A[i];
		}
		for (int i = mid; i < n; i++) {
			right[i - mid] = A[i];
		}

		// recursive calls
		RecursiveMergeSort(left);
		RecursiveMergeSort(right);

		// merge
		merge(A, left, right);
	}

	private static void merge(int[] A, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				A[k++] = left[i++];
			} else {
				A[k++] = right[j++];
			}
		}

		while (i < left.length) {
			A[k++] = left[i++];
		}

		while (j < right.length) {
			A[k++] = right[j++];
		}
	}

	// ====================== QUICK SORT =======================
	static void RecursiveQuickSort(int[] A, int start, int end) {
		if (start >= end)
			return;

		int pivot = A[end];

		int[] L = new int[A.length];
		int[] R = new int[A.length];
		int l_count = 0, r_count = 0;

		for (int i = start; i < end; i++) {
			if (A[i] < pivot) {
				L[l_count++] = A[i];
			} else {
				R[r_count++] = A[i];
			}
		}

		// rebuild array
		int index = start;

		for (int i = 0; i < l_count; i++) {
			A[index++] = L[i];
		}

		int pivotIndex = index;
		A[index++] = pivot;

		for (int i = 0; i < r_count; i++) {
			A[index++] = R[i];
		}

		// recursive calls
		RecursiveQuickSort(A, start, pivotIndex - 1);
		RecursiveQuickSort(A, pivotIndex + 1, end);
	}

	// =========================== MAIN ============================
	public static void main(String[] args) {

		System.out.println("Selection Sort");
		int[] A = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(A);
		System.out.println("Your Solution is ");
		SelectionSort(A);

		System.out.println("\nInsertion Sort");
		int[] B = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(B);
		System.out.println("Your Solution is ");
		InsertionSort(B);

		System.out.println("\nMerge Sort");
		int[] C = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(C);
		System.out.println("Your Solution is ");
		RecursiveMergeSort(C);
		printArray(C);

		System.out.println("\nQuick Sort");
		int[] D = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(D);
		System.out.println("Your Solution is ");
		RecursiveQuickSort(D, 0, D.length - 1);
		printArray(D);
	}
}
