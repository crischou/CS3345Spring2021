//Cris Chou
//CYC18001

public class LazyBinarySearchTree {

	private TreeNode root = null;
	private final int upper = 99, lower = 1; // upper and lower bounds
	private int size = 0;;
	// used for preorder method
	private String toStringTree = "";

	// insert
	public boolean insert(int key) {

		TreeNode temp = root; // temp node
		TreeNode tempTrail = null; // follows temp

		// new node with key as its value
		TreeNode newNode = new TreeNode();
		newNode.key = key;

		if (outOfBounds(key)) { // local method I made check if key is within upper and lower bound and returns
								// true or false
			// System.out.println(key);
			throw new IllegalArgumentException("Error in insert: IllegalArgumentException raised");

		}

		if (root == null) { // if root empty make it root
			root = newNode;
			size++;
			// System.out.println("here");
			return true;

		} else {

			while (temp != null) {

				tempTrail = temp;

				// check if greater or less than
				if (key > temp.key) { // greater so goes to right side

					temp = temp.rightChild;

				} else if (key < temp.key) { // less so goes to left side

					temp = temp.leftChild;

				} else if (temp.key == key) {

					if (temp.deleted) { // undelete

						temp.deleted = false;
						return true;
					}

				}

			}

		}

		if (key > tempTrail.key) {

			tempTrail.rightChild = newNode;

		} else if (key < tempTrail.key) {

			tempTrail.leftChild = newNode;

		}
		size++;

		return true;

	}

	// logical delete
	public boolean delete(int key) {

		if (outOfBounds(key)) {

			throw new IllegalArgumentException("Error in delete: IllegalArgumentException raised");

		}

		TreeNode temp = root;

		while (temp != null) {

			if (key > temp.key) {

				temp = temp.rightChild;

			} else if (key < temp.key) {

				temp = temp.leftChild;

				// logical deletion
			} else if (key == temp.key) {

				temp.deleted = true;
				return true;
			}

		}

		return false;
	}

	// return the value of the minimum non-deleted element, or -1 if none exists
	public int findMin() {

		TreeNode temp = root;
		TreeNode min = new TreeNode();


		// return -1 if no min val
		if (size == 0) {

			return -1;

		}
		if (size == 1) {

			return root.key;
		}
		
		min.key = root.key;
		while (temp.leftChild != null) {
			if(!temp.deleted) {
				if(temp.key < min.key) {
					
				min.key = temp.key;
				}
			}//check right subtree of deleted
			else {
				TreeNode temp2 = temp;
				if(temp.rightChild != null) {
					temp2 = temp.leftChild;
					if(temp2.key < min.key) {
						
						min.key = temp2.key;
					}
				}
				
			}
			temp = temp.leftChild;
			

		}
		//check last value
		if(!temp.deleted) {
			if(temp.key < min.key) {
				
			min.key = temp.key;
			}
		}else {
			TreeNode temp2 = temp;
			if(temp.rightChild != null) {
				temp2 = temp.leftChild;
				if(temp2.key < min.key) {
					
					min.key = temp2.key;
				}
			}
			
		}
		
		
		// return min non deleted value
		return min.key;
	}

	// return the value of the maximum non-deleted element, or -1 if none exists.
	public int findMax() {

		TreeNode temp = root;
		TreeNode max = new TreeNode();

		// return -1 if no max val
		if (size == 0) {

			return -1;

		}
		if (size == 1) {

			return root.key;
		}
		
		max.key = root.key;
		while (temp.rightChild != null) {

			// check if value greater than not deleted
			if (!temp.deleted) {
				if (temp.key > max.key) {

					max.key = temp.key;
				}
			//check left subtree of deleted 
			}else {
				TreeNode temp2 = temp;
				if(temp.leftChild != null) {
					temp2 = temp.leftChild;
					if(temp2.key > max.key) {
						
						max.key = temp2.key;
					}
				}
				
			}
			temp = temp.rightChild;
			
		}
		//check last value
		if (!temp.deleted) {
			if (temp.key > max.key) {

				max.key = temp.key;
			}

		}else {
			//check left subtree of deleted
			TreeNode temp2 = temp;
			if(temp.leftChild != null) {
				temp2 = temp.leftChild;
				if(temp2.key > max.key) {
					
					max.key = temp2.key;
				}
			}
			
		}
		
		// return max non deleted value
		return max.key;
	}

	// return whether the given element both exists in the tree and is non-deleted
	public boolean contains(int key) {
		TreeNode temp = root;

		if (outOfBounds(key)) {

			throw new IllegalArgumentException("Error in insert: IllegalArgumentException raised");
		}

		while (temp != null) {

			// search left side if less than
			if (key > temp.key) {

				temp = temp.rightChild;

				// search right side if greater than
			} else if (key < temp.key) {

				temp = temp.leftChild;

				// return value if found and not deleted
			} else if (key == temp.key) {

				if (!temp.deleted) {

					return true;

				}

				return false;
			}

		}

		return false;
	}

	/*
	 * perform an pre-order traversal of the tree and print the value of each
	 * element, including elements marked as deleted. However, elements that are
	 * marked as deleted should be preceded by a single asterisk
	 */

	public String toString() {

		TreeNode temp = root;

		// use preOrder method to get string of values
		// reset global variable each time
		toStringTree = "";
		preOrder(root);
		return toStringTree;
	}

	// preorder method

	public void preOrder(TreeNode node) {

		// empty string if root null
		if (root == null) {

		} else {

			// add values to tree string in preorder
			if (node != null) {

				if (node.deleted) {
					// global variable declared at top
					toStringTree += ("*" + node.key + " ");

				} else {

					toStringTree += (node.key + " ");

				}

				preOrder(node.leftChild);
				preOrder(node.rightChild);
			}

		}

	}

	public int height() {

		TreeNode temp = root;
		int leftHeight = 0, rightHeight = 0;
		// check base cases
		if (size == 0) {

			return 0;
		} else if (size == 1) {

			return 1;

		}

		// find left subtree height
		while (temp.leftChild != null) {

			temp = temp.leftChild;
			leftHeight++;

		}

		// find right subtree height
		while (temp.rightChild != null) {

			temp = temp.rightChild;
			leftHeight++;

		}

		// return larger height
		if (rightHeight > leftHeight) {

			return rightHeight;

		} else if (rightHeight < leftHeight) {

			return leftHeight;

		} else if (rightHeight == leftHeight) {

			return rightHeight;

		}

		return -1;

	}

	// size of tree including deleted values
	public int size() {

		return size;
	}

	// check if out of bounds
	private boolean outOfBounds(int key) {

		if (key > upper || key < lower) { // returns true if out of bounds

			return true;

		} else {

			return false;
		}

	}

	// TreeNode
	private class TreeNode {

		int key; // key value
		TreeNode leftChild; // left child
		TreeNode rightChild; // right child
		boolean deleted = false; // deleted status, default false

	}

}
