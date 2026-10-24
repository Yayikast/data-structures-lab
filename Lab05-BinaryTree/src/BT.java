public class BT<T> {

	int size; // Number of nodes in the tree
	BTNode<T> root = null; // Root node of the tree

	// Default constructor: creates an empty tree
	BT() {
		root = null;
		size = 0;
	}

	// Constructor with single node data
	BT(T data) {
		this(new BTNode<T>(data));
	}

	// Constructor with a given root node
	BT(BTNode<T> root) {
		this.root = root;
		size = 1;
	}

	// Constructor with root node and left/right subtrees
	BT(BTNode<T> root, BT<T> Lsubtree, BT<T> Rsubtree) {
		this.root = root;
		root.left = Lsubtree.root;
		root.right = Rsubtree.root;
		size = Lsubtree.size + Rsubtree.size + 1;
	}

	// Find height of the tree
	int findHeight() {
		return findHeight(root);
	}

	// Recursive helper for finding height
	int findHeight(BTNode<T> root) {
		if (root == null) {
			return 0;
		} else if (isLeaf(root)) {
			return 1;
		} else {
			return 1 + Math.max(findHeight(root.left), findHeight(root.right));
		}
	}

	// Check if a node is a leaf
	boolean isLeaf(BTNode<T> root) {
		return root != null && root.left == null && root.right == null;
	}

	// Check if the tree is height-balanced
	boolean isBalanced() {
		return isBalanced(root);
	}

	// Recursive helper for balance check
	boolean isBalanced(BTNode<T> root) {
		if (root == null)
			return true;

		int LH = findHeight(root.left);
		int RH = findHeight(root.right);

		if (Math.abs(LH - RH) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		} else {
			return false;
		}
	}

	// Inorder traversal: left-root-right
	public void inorder() {
		inorder(root);
	}

	protected void inorder(BTNode<T> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.element + " ");
			inorder(root.right);
		}
	}

	// Postorder traversal: left-right-root
	public void postorder() {
		postorder(root);
	}

	protected void postorder(BTNode<T> root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.element + " ");
		}
	}

	// Preorder traversal: root-left-right
	public void preorder() {
		preorder(root);
	}

	protected void preorder(BTNode<T> root) {
		if (root != null) {
			System.out.print(root.element + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	// Depth-First Traversal using a stack
	void PrintDFT() {
		Stack<BTNode<T>> S = new Stack<BTNode<T>>();
		S.push(root);
		while (!S.isEmpty()) {
			BTNode<T> tmp = S.pop();
			if (tmp.right != null)
				S.push(tmp.right);
			if (tmp.left != null)
				S.push(tmp.left);
			System.out.print(tmp.element + " ");
		}
	}

	// Breadth-First Traversal using a queue
	void PrintBFT() {
		Queue<BTNode<T>> Q = new Queue<BTNode<T>>();
		Q.enqueue(root);
		while (!Q.isEmpty()) {
			BTNode<T> tmp = Q.dequeue();
			if (tmp.left != null)
				Q.enqueue(tmp.left);
			if (tmp.right != null)
				Q.enqueue(tmp.right);
			System.out.print(tmp.element + " ");
		}
	}

	// Check operator precedence for expression tree
	static boolean hasHigherPriority(String sign1, String sign2) {
		if (sign2.equals("("))
			return true;
		else if ((sign1.equals("*") || sign1.equals("/") || sign1.equals("%"))
				&& (sign2.equals("+") || sign2.equals("-")))
			return true;
		else
			return false;
	}

	// Check if a string is an operator
	public static boolean isOperator(String item) {
		return item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/") || item.equals("%");
	}

	// Build a binary expression tree from an infix expression array
	public static BT<String> makeExpressionTree(String[] infixArr) {
		Stack<BT<String>> BTStack = new Stack<BT<String>>();
		Stack<BTNode<String>> parent = new Stack<BTNode<String>>();
		int i = 0;

		while (i < infixArr.length) {
			String item = infixArr[i];

			if (item.equals("(")) { // Open parenthesis
				parent.push(new BTNode<String>(item));
			} else if (isOperator(item)) { // Operator
				BTNode<String> temp = new BTNode<String>(item);
				if (parent.isEmpty()) {
					parent.push(temp);
				} else {
					if (hasHigherPriority(item, parent.peek().element)) {
						parent.push(temp);
					} else {
						// Build subtrees until operator precedence satisfied
						do {
							BTNode<String> root = parent.pop();
							BT<String> Rsubtree = BTStack.pop();
							BT<String> Lsubtree = BTStack.pop();
							BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
							BTStack.push(newBT);
						} while (!parent.isEmpty() && !hasHigherPriority(item, parent.peek().element));
						parent.push(temp);
					}
				}
			} else if (item.equals(")")) { // Close parenthesis
				while (!parent.peek().element.equals("(")) {
					BTNode<String> root = parent.pop();
					BT<String> Rsubtree = BTStack.pop();
					BT<String> Lsubtree = BTStack.pop();
					BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
					BTStack.push(newBT);
				}
				parent.pop(); // Remove "("
			} else { // Operand
				BT<String> newTree = new BT<String>(item);
				BTStack.push(newTree);
			}
			i++;
		}

		// Finalize remaining operators
		while (!parent.isEmpty()) {
			BTNode<String> root = parent.pop();
			BT<String> Rsubtree = BTStack.pop();
			BT<String> Lsubtree = BTStack.pop();
			BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
			BTStack.push(newBT);
		}

		return BTStack.pop();
	}
}
