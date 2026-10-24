/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

class SList<T> {

	int size;
	Node<T> first;
	Node<T> last;

	SList() {
		size = 0;
		first = null;
		last = null;
	}

	void addFirst(T element) {
		Node<T> newNode = new Node<T>(element);
		newNode.next = first;
		first = newNode;
		size++;
		if (last == null) {
			last = first;
		}
	}

	void addLast(T element) {
		Node<T> newNode = new Node<T>(element);
		if (last == null) {
			last = first = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	void addAtIndex(int index, T element) {
		if (index == 0) {
			addFirst(element);
		} else if (index == size) {
			addLast(element);
		} else {
			Node<T> current = first;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}

			Node<T> temp = current.next;
			current.next = new Node<T>(element);
			(current.next).next = temp;
			size++;
		}
	}

	T removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<T> temp = first;
			first = first.next;
			size--;
			if (first == null) {
				last = null;
			}
			return temp.element;
		}
	}

	T removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<T> temp = first;
			first = last = null;
			size = 0;
			return temp.element;
		} else {
			Node<T> current = first;
			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}
			Node<T> temp = last;
			last = current;
			last.next = null;
			size--;
			return temp.element;
		}
	}

	T removeAtIndex(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<T> previous = first;
			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}
			Node<T> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	int getSize() {
		return size;
	}

	void printVerical() {
		Node<T> walker = first;
		for (int i = 0; i < size; i++) {
			System.out.println(walker.element);
			walker = walker.next;
		}
		System.out.println("-----");
	}

	void printHorizontal() {
		Node<T> walker = first;
		for (int i = 0; i < size; i++) {
			System.out.print(walker.element);
			System.out.print(" ");
			walker = walker.next;
		}
		System.out.println("\n-----");
	}

	void clear() {
		first = last = null;
	}

	boolean contains(T element) {
		Node<T> current = first;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(element)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	T get(int index) {
		if (index < 0 || index > size - 1) {
			return null;
		}
		Node<T> current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.element;
	}

	int indexOf(T element) {
		Node<T> current = first;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(element)) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}
}