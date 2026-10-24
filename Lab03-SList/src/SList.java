public class SList<T> {
	int size;           // number of elements in the list
	SNode<T> first;     // reference to first node
	SNode<T> last;      // reference to last node

	SList() {
		size = 0;
		first = null;
		last = null;
	}

	void addFirst(T element) {
		SNode<T> newNode = new SNode<T>(element);
		newNode.next = first;  // point new node to current first
		first = newNode;       // update first to new node
		size++;
		if (last == null)      // if list was empty, last also points to new node
			last = first;
	}

	void addLast(T element) {
		SNode<T> newNode = new SNode<T>(element);
		if (size == 0) {
			first = newNode;   // empty list, first points to new node
		} else {
			last.next = newNode; // link current last to new node
		}
		last = newNode;         // update last to new node
		size++;
	}

	void addAtIndex(int index, T element) {
		if (index == 0) {
			addFirst(element);    // insert at beginning
		} else if (index >= size) {
			addLast(element);     // insert at end
		} else {
			SNode<T> newNode = new SNode<T>(element);
			SNode<T> current = first;
			
			for (int i=0; i<(index-1); i++) { // move to node before insertion point
				current = current.next;
			}
			
			newNode.next = current.next;  // link new node to next node
			current.next = newNode;       // link previous node to new node
			size++;
		}
	}

	T removeFirst() {
		if (size == 0)
			return null;  // empty list
		else {
			SNode<T> tmp = first;
			first = first.next;  // move first to next node
			size--;
			if (first == null)   // if list becomes empty, last must also be null
				last = null;
			return tmp.element;
		}
	}

	T removeLast() {
		if (size == 0) {
			return null;        // empty list
		} else if (size == 1) {
			SNode<T> tmp = last;
			first = null;
			last = null;
			size--;
			return tmp.element;
		} else {
			SNode<T> tmp = last;
			SNode<T> current = first;
			while(current.next != last) { // move to second-to-last node
				current = current.next;
			}
			current.next = null;  // detach last node
			last = current;       // update last
			size--;
			return tmp.element;
		}
	}

	T removeAtIndex(int index) {
		if (size == 0) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == (size-1)) {
			return removeLast();
		} else {
			SNode<T> current = first;
			for (int i=0; i<(index-1); i++) {
				current = current.next;   // move to node before target
			}
			SNode<T> tmp = current.next; // node to remove
			current.next = current.next.next; // bypass removed node
			size--;
			return tmp.element;
		}
	}

	boolean isEmpty() {
		return size == 0;   // true if list has no elements
	}

	int getSize() {
		return size;        // return number of elements
	}

	void reverse() {
		SNode<T> previous = null;
		SNode<T> current = first;
		SNode<T> next = null;
		while (current != null) {
			next = current.next;     // store next node
			current.next = previous; // reverse pointer
			previous = current;      // move previous forward
			current = next;          // move current forward
		}
		last = first;   // swap first and last
		first = previous;
	}

	int search(T item) {
		SNode<T> current = first;
		int i = 0;
		while (current != null) {
			if (current.element.equals(item)) {
				return i;        // found, return index
			} else {
				current = current.next;
				i++;
			}
		}
		return -1;           // not found
	}

	void printHorizontal() {
		SNode<T> walker = first;
		for (int i = 0; i < size; i++) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}
		System.out.println("\n-----");
	}
}
