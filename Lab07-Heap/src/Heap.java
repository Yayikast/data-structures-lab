public class Heap {

	int load = 0;                // number of items in heap
	int[] hArray = new int[100]; // heap storage

	Heap() {
	}

	// Move a newly inserted value up to restore heap order
	void reheapUp(int currentIndex) {
		if (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if (hArray[currentIndex] > hArray[parentIndex]) {
				swap(hArray, currentIndex, parentIndex);
				reheapUp(parentIndex);
			}
		}
	}

	// Insert new value into the heap
	void insert(int data) {
		hArray[load] = data;
		load++;
		reheapUp(load - 1);
	}

	// Move value down to restore heap order after deletion
	void reheapDown(int currentIndex) {
		int lastIndex = load - 1;

		if (2 * currentIndex + 1 <= lastIndex) {
			int largeNodeIndex;
			int leftNodeIndex = 2 * currentIndex + 1;
			int rightNodeIndex = 2 * currentIndex + 2;

			if (rightNodeIndex > lastIndex) {
				largeNodeIndex = leftNodeIndex;
			} else if (hArray[rightNodeIndex] > hArray[leftNodeIndex]) {
				largeNodeIndex = rightNodeIndex;
			} else {
				largeNodeIndex = leftNodeIndex;
			}

			if (hArray[currentIndex] < hArray[largeNodeIndex]) {
				swap(hArray, currentIndex, largeNodeIndex);
				reheapDown(largeNodeIndex);
			}
		}
	}

	// Remove and return root (max value)
	int deleteRoot() {
		if (load == 0) {
			return -1;
		}

		int temp = hArray[0];              // root value
		hArray[0] = hArray[load - 1];      // move last to root
		hArray[load - 1] = 0;              // clear old spot
		load--;

		reheapDown(0);                     // restore heap

		return temp;
	}

	// Remove values one by one (heap sort)
	void makeHeapSort() {
		while (load > 0) {
			System.out.print(deleteRoot() + " ");
		}
		System.out.println();
	}

	// Find the level of a node
	int findLevel(int nodeindex) {
		int level = 0;
		while (nodeindex > 0) {
			nodeindex = (nodeindex - 1) / 2;
			level++;
		}
		return level;
	}

	// Swap two heap values
	void swap(int[] A, int ind1, int ind2) {
		int temp = A[ind1];
		A[ind1] = A[ind2];
		A[ind2] = temp;
	}

	// Print heap array
	void printHeapArray() {
		for (int i = 0; i < load; i++)
			System.out.print(hArray[i] + " ");
		System.out.println();
	}

	// Priority queue: add item
	public void enqueue(int data) {
		insert(data);
	}

	// Priority queue: remove highest priority
	public int dequeue() {
		return deleteRoot();
	}

	// Check if empty
	public boolean isEmpty() {
		return load == 0;
	}
}
