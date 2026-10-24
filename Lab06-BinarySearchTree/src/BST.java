public class BST<T extends Comparable<T>> extends BT<T> {

	// Create an empty binary search tree
	public BST() {
	}

	// Create a BST with a single object
	public BST(T object) {
		super(object);
	}

	// Create a BST from an array of objects
	public BST(T[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	// Insert a new element into the BST
	public void insert(T newdata) {
		if (root == null) { // Tree is empty, create root
			root = new BTNode<T>(newdata);
		} else {
			BTNode<T> parent = null;
			BTNode<T> current = root;

			// Traverse tree to find the correct position
			while (current != null) {
				if (newdata.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (newdata.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else {
					return; // Duplicate value, BST keeps unique elements
				}
			}

			// Insert node as left or right child
			if (newdata.compareTo(parent.element) <= 0) {
				parent.left = new BTNode<T>(newdata);
			} else {
				parent.right = new BTNode<T>(newdata);
			}
		}
		size++;
	}

	// Delete a node from the BST
	public T delete(T item) {
		BTNode<T> parent = null;
		BTNode<T> current = root;
		boolean currentIsLeftChild = true;

		// Find the node to delete
		while (current != null) {
			if (item.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
				currentIsLeftChild = true;
			} else if (item.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
				currentIsLeftChild = false;
			} else {
				break; // Node found
			}
		}

		// Node not found
		if (current == null)
			return null;

		T temp = current.element;

		// Case 1: Node is a leaf
		if (current.left == null && current.right == null) {
			if (parent == null)
				root = null; // Deleting the only node
			else if (currentIsLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}
		// Case 2: Node has one child
		else if (current.left == null) { // Only right child
			if (parent == null)
				root = current.right;
			else if (currentIsLeftChild)
				parent.left = current.right;
			else
				parent.right = current.right;
			current.right = null;
		} else if (current.right == null) { // Only left child
			if (parent == null)
				root = current.left;
			else if (currentIsLeftChild)
				parent.left = current.left;
			else
				parent.right = current.left;
			current.left = null;
		}
		// Case 3: Node has two children
		else {
			BTNode<T> maxleft = current.left;
			BTNode<T> maxleftParent = current;

			// Find the max node in left subtree
			while (maxleft.right != null) {
				maxleftParent = maxleft;
				maxleft = maxleft.right;
			}

			current.element = maxleft.element;

			// Unlink maxleft, keeping its left subtree (if any)
			if (maxleftParent == current)
				maxleftParent.left = maxleft.left; // Maxleft is left child of current
			else
				maxleftParent.right = maxleft.left; // Maxleft is deeper in left subtree
		}

		size--;
		return temp;
	}

	// Search for data in BST
	public boolean search(T data) {
		BTNode<T> current = root;
		while (current != null) {
			if (data.compareTo(current.element) < 0)
				current = current.left;
			else if (data.compareTo(current.element) > 0)
				current = current.right;
			else
				return true;
		}
		return false;
	}

	// Find smallest node
	BTNode<T> findSmallest() {
		return findSmallest(root);
	}

	BTNode<T> findSmallest(BTNode<T> start) {
		BTNode<T> smallest = start;
		while (smallest.left != null)
			smallest = smallest.left;
		return smallest;
	}

	// Find largest node
	BTNode<T> findLargest() {
		return findLargest(root);
	}

	BTNode<T> findLargest(BTNode<T> start) {
		BTNode<T> largest = start;
		while (largest.right != null)
			largest = largest.right;
		return largest;
	}

	// Get number of nodes
	public int getSize() {
		return size;
	}

	// Get root node
	public BTNode<T> getRoot() {
		return root;
	}

	// Return path from root to specified element
	public java.util.ArrayList<BTNode<T>> path(T e) {
		java.util.ArrayList<BTNode<T>> list = new java.util.ArrayList<>();
		BTNode<T> current = root;
		while (current != null) {
			list.add(current);
			if (e.compareTo(current.element) < 0)
				current = current.left;
			else if (e.compareTo(current.element) > 0)
				current = current.right;
			else
				break;
		}
		return list;
	}

	// Find the value closest to a target in BST
	public T findClosestValue(T target) {
		return findClosestValue(root, target, root.element);
	}

	private T findClosestValue(BTNode<T> node, T target, T closest) {
		if (node == null)
			return closest;

		Double targetVal = Double.valueOf(target.toString());
		Double nodeVal = Double.valueOf(node.element.toString());
		Double closestVal = Double.valueOf(closest.toString());

		// Update closest if current node is nearer
		if (Math.abs(targetVal - nodeVal) < Math.abs(targetVal - closestVal)) {
			closest = node.element;
		}

		// Search left or right based on target
		if (target.compareTo(node.element) < 0)
			return findClosestValue(node.left, target, closest);
		else if (target.compareTo(node.element) > 0)
			return findClosestValue(node.right, target, closest);
		else
			return node.element;
	}
}
