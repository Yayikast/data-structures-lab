public class Stack<T> {

	private SList<T> list = new SList<T>();

	Stack() {
	}

	void push(T element) {
		list.addFirst(element);
	}

	T pop() {
		if (list.size == 0) {
			throw new RuntimeException("Stack is empty");
		} else {
			return list.removeFirst();
		}
	}

	T peek() {
		return list.first.element;
	}

	boolean isEmpty() {
		if (list.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	void printVertical() {
		Node<T> walker = list.first;
		for (int i = 0; i < list.size; i++) {
			System.out.println(walker.element);
			walker = walker.next;
		}
		System.out.println("-----");
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}