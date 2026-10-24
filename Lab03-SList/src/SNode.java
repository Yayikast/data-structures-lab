class SNode<T> {
	T element;     // Data stored in the node
	SNode<T> next; // Reference to the next node

	SNode(T element) {
		this.element = element;
		next = null;
	}
}
