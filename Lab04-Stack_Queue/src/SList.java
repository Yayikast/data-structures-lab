public class SList<T> {
	int size;
	Node<T> first;
	Node<T> last;

	// Constructor to create an empty list
	SList() {
		size = 0;
		first = null;
		last = null;
	}

	// Add an element to the beginning of the list
	void addFirst(T element) {
		Node<T> newNode = new Node<T>(element);
		newNode.next = first;
		first = newNode;
		size++;
		if (last == null)
			last = first;
	}

	// Add an element to the end of the list
	void addLast(T element) {
		Node<T> newNode = new Node<T>(element);
		if (size == 0)
			first = newNode;
		else
			last.next = newNode;
		last = newNode;
		size++;
	}

	// Add an element at a specific index
	void addAtIndex(int index, T element) {
		if (index == 0)
			addFirst(element);
		else if (index >= size)
			addLast(element);
		else {
			Node<T> current = first;
			Node<T> newNode = new Node<T>(element);
			for (int i = 0; i < index - 1; i++)
				current = current.next;
			newNode.next = current.next;
			current.next = newNode;
			size++;
		}
	}

	// Remove and return the first element
	T removeFirst() {
		if (size == 0)
			return null;
		Node<T> tmp = first;
		first = first.next;
		size--;
		if (first == null)
			last = null;
		return tmp.element;
	}

	// Remove and return the last element
	T removeLast() {
		if (size == 0)
			return null;
		else if (size == 1) {
			Node<T> tmp = first;
			first = null;
			last = null;
			size--;
			return tmp.element;
		} else {
			Node<T> current = first;
			while (current.next != last)
				current = current.next;
			Node<T> tmp = last;
			last = current;
			last.next = null;
			size--;
			return tmp.element;
		}
	}

	// Remove and return the element at a specific index
	T removeAtIndex(int index) {
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return removeFirst();
		else if (index == size - 1)
			return removeLast();
		else {
			Node<T> current = first;
			for (int i = 0; i < index - 1; i++)
				current = current.next;
			Node<T> tmp = current.next;
			current.next = tmp.next;
			tmp.next = null;
			size--;
			return tmp.element;
		}
	}

	// Search for an element and return its index, or -1 if not found
	int search(T item) {
		Node<T> current = first;
		int i = 0;
		while (current != null) {
			if (current.element.equals(item))
				return i;
			current = current.next;
			i++;
		}
		return -1;
	}

	// Check if the list is empty
	boolean isEmpty() {
		return size == 0;
	}

	// Get the number of elements in the list
	int getSize() {
		return size;
	}

	// Print all elements in the list horizontally
	void printHorizontal() {
		Node<T> walker = first;
		while (walker != null) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}
		System.out.println("\n-----");
	}
}
