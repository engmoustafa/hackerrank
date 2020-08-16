package utils.datastructure.binarytree;

/* Class BTNode */
class BinaryNode {
	BinaryNode left;
	BinaryNode right;
	int data;

	/* Constructor */
	public BinaryNode() {
		left = null;
		right = null;
		data = 0;
	}

	/* Constructor */
	public BinaryNode(int n) {
		left = null;
		right = null;
		data = n;
	}

	/* Function to set left node */
	public void setLeft(BinaryNode n) {
		left = n;
	}

	/* Function to set right node */
	public void setRight(BinaryNode n) {
		right = n;
	}

	/* Function to get left node */
	public BinaryNode getLeft() {
		return left;
	}

	/* Function to get right node */
	public BinaryNode getRight() {
		return right;
	}

	/* Function to set data to node */
	public void setData(int d) {
		data = d;
	}

	/* Function to get data from node */
	public int getData() {
		return data;
	}
}