public class TestMinHeap {
	public static void main(String[] args) {
		MinHeap H = new MinHeap();

		System.out.println("Testing insert and reheapUp methods:");
		// The correct answer is 0 18 9 45 27 54 63 99 72 81 36 90
		for (int i = 99; i >= 0; i = i - 9) {
			H.insert(i);
		}
		H.printHeap();

		System.out.println("\nTesting Priority Queue operations (smallest first):");
		MinHeap priorityQueue = new MinHeap();
		priorityQueue.enqueue(4);
		priorityQueue.enqueue(2);
		priorityQueue.enqueue(5);
		priorityQueue.enqueue(1);
		System.out.println("Priority Queue after enqueuing 4, 2, 5, 1:");
		priorityQueue.printHeap();

		while (!priorityQueue.isEmpty()) {
			System.out.println("Dequeue: " + priorityQueue.dequeue()); // Expected: 1, 2, 4, 5
		}
		System.out.println("Is Priority Queue Empty? " + priorityQueue.isEmpty()); // Should be true
	}
}
