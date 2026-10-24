public class Queue<T> {
	// Underlying singly linked list for the queue
	SList<T> list = new SList<T>();

	// Constructor to initialize an empty queue
	Queue() {
	}

	// Add an element to the rear of the queue
	void enqueue(T element) {
		list.addLast(element);
	}

	// Check if the queue is empty
	boolean isEmpty() {
		return list.isEmpty();
	}

	// Remove and return the element at the front of the queue
	T dequeue() {
		return list.removeFirst();
	}

	// Get the element at the front without removing it
	T queuefront() {
		return list.first.element;
	}

	// Get the element at the rear without removing it
	T queuerear() {
		return list.last.element;
	}

	// Create a new queue (copy logic can be added later)
	Queue<T> copyQueue() {
		Queue<T> Q2 = new Queue<T>();
		return Q2;
	}

	// Check if two queues have the same elements in the same order
	boolean isIdentical(Queue<T> Q2) {
		if (list.size != Q2.list.size)
			return false;

		boolean identical = true;
		int size = Q2.list.size;

		for (int i = 0; i < size; i++) {
			T e1 = Q2.dequeue();
			T e2 = dequeue();
			if (identical && e1 != e2) {
				identical = false;
			}
			Q2.enqueue(e1);
			enqueue(e2);
		}
		return identical;
	}

	// Print all elements horizontally
	void printHorizontal() {
		Node<T> walker = list.first;
		while (walker != null) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}
	}

	// Get the number of elements in the queue
	public int getSize() {
		return list.getSize();
	}
}
