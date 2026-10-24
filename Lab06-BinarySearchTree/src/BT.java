public class BT<T> {
	int size; // Number of nodes in the binary tree
	BTNode<T> root = null; // Root node of the tree

	/** Create an empty tree */
	BT() {
		root = null;
		size = 0;
	}

	/** Create a tree with a single element as root */
	BT(T data) {
		this(new BTNode<T>(data));
	}

	/** Create a tree with a given root node */
	BT(BTNode<T> root) {
		this.root = root;
		size = 1;
	}

	/** Create a tree with root and left/right subtrees */
	BT(BTNode<T> root, BT<T> Lsubtree, BT<T> Rsubtree) {
		this.root = root;
		root.left = Lsubtree.root;
		root.right = Rsubtree.root;
		size = Lsubtree.size + Rsubtree.size + 1;
	}

	/** Find height of tree */
	int findHeight() {
		return findHeight(root);
	}

	/** Recursive helper to find height of subtree */
	int findHeight(BTNode<T> root) {
		if (root == null) { // empty subtree
			return 0;
		} else if (isLeaf(root)) { // leaf node
			return 1;
		} else { // internal node
			int lheight = findHeight(root.left);
			int rheight = findHeight(root.right);
			return 1 + Math.max(lheight, rheight);
		}
	}

	/** Check if a node is a leaf (no children) */
	boolean isLeaf(BTNode<T> root) {
		return root != null && root.left == null && root.right == null;
	}

	/** Check if tree is balanced (difference in height <= 1 for all nodes) */
	boolean isBalanced() {
		return isBalanced(root);
	}

	/** Recursive helper to check balance of subtree */
	boolean isBalanced(BTNode<T> root) {
		if (root == null) {
			return true;
		}
		int LH = findHeight(root.left);
		int RH = findHeight(root.right);
		int diff = Math.abs(LH - RH);
		return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	/* Inorder traversal (Left -> Root -> Right) */
	public void inorder() {
		inorder(root);
	}

	protected void inorder(BTNode<T> root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}

	/* Postorder traversal (Left -> Right -> Root) */
	public void postorder() {
		postorder(root);
	}

	protected void postorder(BTNode<T> root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}

	/* Preorder traversal (Root -> Left -> Right) */
	public void preorder() {
		preorder(root);
	}

	protected void preorder(BTNode<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	/** Breadth-First Traversal (Level Order) */
	void PrintBFT() {
		Queue<BTNode<T>> Q = new Queue<>();
		BTNode<T> tmp;
		Q.enqueue(root);
		while (!Q.isEmpty()) {
			tmp = Q.dequeue();
			if (tmp.left != null) {
				Q.enqueue(tmp.left);
			}
			if (tmp.right != null) {
				Q.enqueue(tmp.right);
			}
			System.out.print(tmp.element + " ");
		}
	}

	/** Depth-First Traversal using stack (Preorder) */
	void PrintDFT() {
		Stack<BTNode<T>> S = new Stack<>();
		BTNode<T> tmp;
		S.push(root);
		while (!S.isEmpty()) {
			tmp = S.pop();
			if (tmp.right != null) {
				S.push(tmp.right); // push right first
			}
			if (tmp.left != null) {
				S.push(tmp.left); // push left second
			}
			System.out.print(tmp.element + " ");
		}
	}

	/** Get number of nodes in tree */
	public int getSize() {
		return size;
	}

	/** Get root node */
	public BTNode<T> getRoot() {
		return root;
	}
}
