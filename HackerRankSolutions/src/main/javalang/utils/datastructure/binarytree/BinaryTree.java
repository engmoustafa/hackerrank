package javalang.utils.datastructure.binarytree;

public class BinaryTree {
	private BinaryNode root;
	//private Integer maintainedCount =0 ;

	/* Constructor */
	public BinaryTree() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Functions to insert data */
	public void insert(int data) {
		root = insert(root, data);
	}

	public void insert(int level, int index, int data) {
		
	}
	
	public void insertSorted(int data) {
		BinaryNode parentNode = insertSorted(root,data);
		if (root ==null) {
			root = parentNode;
		}
	}
	/**
	 * Return the parent node which the data was inserted in
	 * @param node
	 * @param data
	 * @return
	 */
	private BinaryNode insertSorted(BinaryNode node, int data) {
		if(node == null) {
			node = new BinaryNode(data);
			return node;
		}else {
			if(node.getData() > data) {
				if(node.getLeft() == null) {
					node.setLeft(new BinaryNode(data));
					return node;
				}else {
					return insertSorted(node.left,data);
				}
			}else {
				if(node.getRight() == null) {
					node.setRight(new BinaryNode(data));
					return node;
				}else {
					return insertSorted(node.right,data);
				}
			}
		}
	}
	/* Function to insert data recursively */
	private BinaryNode insert(BinaryNode node, int data) {
		if (node == null)
			node = new BinaryNode(data);
		else {
			if (node.getRight() == null)
				node.right = insert(node.right, data);
			else
				node.left = insert(node.left, data);
		}
		return node;
	}

	/* Function to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	/* Function to count number of nodes recursively */
	private int countNodes(BinaryNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}

	/* Function to search for an element */
	public boolean search(int val) {
		return search(root, val);
	}

	/* Function to search for an element recursively */
	private boolean search(BinaryNode r, int val) {
		if (r.getData() == val)
			return true;
		if (r.getLeft() != null)
			if (search(r.getLeft(), val))
				return true;
		if (r.getRight() != null)
			if (search(r.getRight(), val))
				return true;
		return false;
	}

	/* Function for inorder traversal */
	public void inorder() {
		inorder(root);
	}

	private void inorder(BinaryNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	/* Function for preorder traversal */
	public void preorder() {
		preorder(root);
	}

	private void preorder(BinaryNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	/* Function for postorder traversal */
	public void postorder() {
		postorder(root);
	}

	private void postorder(BinaryNode r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}
}
