public class Queue<T> {

	private SList<T> list = new SList<T>();

	Queue() {
	}

	void enqueue(T element) {
		list.addLast(element);
	}

	T dequeue() {
		if (list.size == 0) {
			throw new RuntimeException("Queue is empty");
		} else {
			return list.removeFirst();
		}
	}

	T queuefront() {
		return list.first.element;
	}

	T queuerear() {
		return list.last.element;
	}

	boolean isEmpty() {
		if (list.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	void printHorizontal() {
		Node<T> walker = list.first;
		for (int i = 0; i < list.size; i++) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}
		System.out.println("\n-----");
	}
}