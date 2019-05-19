
/*
 * This program shows the implementation of Binary search tree.
 * @author Alankar Singh
 * 
 * This program supports following BST's operations.
 * insert(), minimum(), maximum(), search(),
 * delete(), display()
 */

import java.util.LinkedList;
import java.util.Queue;

/*
 * The following BstNode class is used to create a node,
 * when value is passed to this class it makes a node of binary tree.
 */
class BstNode {

	int data;
	BstNode left;
	BstNode right;

	public BstNode(int value) {
		this.data = value;
		left = null;
		right = null;
	}
}

/*
 * This class consists of the main implementation of binary search tree.
 */
public class BinarySearchTree {

	BstNode root;
	int counter;

	public BinarySearchTree() {
		root = null;
	}

	/*
	 * This method support insert function.
	 * @param int value
	 * 
	 * @return null
	 */
	public void insert(int value) {

		BstNode node = new BstNode(value);
		if (root == null) {
			root = node;
			return;
		}
		BstNode present = null;
		BstNode current = root;
		while (true) {
			present = current;
			if (value < current.data) {
				current = current.left;
				if (current == null) {
					present.left = node;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					present.right = node;
					return;
				}
			}
		}
	}

	/*
	 * This method is designed to get the minimum value from tree.
	 * 
	 * @param null
	 * 
	 * @return null
	 */
	public int minimum() {
		BstNode temp = root;
		int minValue = min(temp);
		return minValue;
	}

	/*
	 * This method is helper function for minimum().
	 * 
	 * @param rootValue
	 * 
	 * @return 0;
	 */
	public int min(BstNode root) {

		BstNode temp = root;
		while (temp != null) {
			if (temp.left == null) {
				return temp.data;
			} else {
				temp = temp.left;
			}
		}
		return 0;
	}

	/*
	 * The method maximum() gives the maximum value from tree.
	 * 
	 * @param int value
	 * 
	 * @return null
	 */
	public int maximum() {

		BstNode temp = root;
		while (temp != null) {
			if (temp.right == null) {
				return temp.data;
			} else {
				temp = temp.right;
			}
		}
		return 0;
	}

	/*
	 * This method searches the given value from the tree.
	 * 
	 * @param int value
	 * 
	 * @return true ( if value is found)
	 * 
	 * @return false (if value is not found)
	 */
	public boolean search(int val) {

		if (root.data == val) {
			return true;
		}
		BstNode current = root;
		while (true) {
			// searches at the left side of tree.
			if (val < current.data) {
				if (current.left == null) {
					return false;
				} else {
					if (current.left.data == val) {
						return true;
					} else {
						current = current.left;
					}
				}
				// searches the right side of tree.
			} else {
				if (current.right == null) {
					return false;
				} else {
					if (current.right.data == val) {
						return true;
					} else {
						current = current.right;
					}
				}
			}
		}

	}

	/*
	 * The delete method deletes the node with the given value from the tree.
	 * 
	 * @param int value
	 * 
	 * @return null
	 */
	public void delete(int val) {

		BstNode current = null;
		BstNode parent = null;
		current = root;

		while (true) {
			if (current.data == val) {
				break;
			} else if (val < current.data) {
				parent = current;
				current = current.left;
			} else {
				parent = current;
				current = current.right;

			}
		}
		// Now we will take care of all the three cases of delete function.
		// Case 1 : if Node does not have any child.
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			} else {
				if (current.data < parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
		}

		// Case 2: if Node has one child.
		else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else {
				if (current.data < parent.data) {
					parent.left = current.right;
				} else
					parent.right = current.right;
			}
		}

		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else {
				if (current.data < parent.data) {
					parent.left = current.left;
				} else
					parent.right = current.left;
			}
		}

		// Case 3: if node has both the children
		else if (current.left != null && current.right != null) {
			if (current == root) {
				root = current.right;
			} else {
				current.data = successor(current, current.right);

			}
		}
	}

	/*
	 * This method is used to balance the tree, after the removal of the node by
	 * delete function.
	 */
	public int successor(BstNode newParent, BstNode root) {

		BstNode current = null;
		BstNode parent = newParent;
		current = root;
		while (current != null) {

			if (current.left == null) {
				if (current.data > parent.data) {
					parent.right = null;
				} else if (current.data < parent.data) {
					parent.left = null;
				}
				return current.data;

			} else {
				parent = current;
				current = current.left;
			}
		}
		return 0;
	}

	/*
	 * This method is used to display the binary tree in depth first search.
	 * 
	 * @param root
	 * 
	 * @return null
	 */
	public void dfsdisplay(BstNode root) {

		// in-order traversal(DFS) method.
		if (root != null) {
			dfsdisplay(root.left);
			System.out.print(" " + root.data);
			dfsdisplay(root.right);
		}

		// // pre-order traversal(DFS) method.
		//
		// if (root != null) {
		//
		// System.out.print(" " + root.data);
		// dfsdisplay(root.left);
		// dfsdisplay(root.right);
		// }
		//
		// // post-order traversal(DFS) method.
		// if (root != null) {
		//
		// dfsdisplay(root.left);
		// dfsdisplay(root.right);
		// System.out.print(" " + root.data);
		// }
	}

	/*
	 * This method is used to display the binary tree in bredth first search.
	 * 
	 * @param root
	 * 
	 * @return null
	 */
	public void bfsdisplay() {

		Queue<BstNode> que = new LinkedList<BstNode>();
		que.add(root);
		BstNode temp;

		while (!que.isEmpty()) {
			temp = que.remove();
			System.out.print(" " + temp.data);
			if (temp.left != null)
				que.add(temp.left);
			if (temp.right != null)
				que.add(temp.right);
		}

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(30);
		bst.insert(20);
		bst.insert(15);
		bst.insert(25);
		bst.insert(22);
		bst.insert(27);
		bst.insert(40);
		bst.insert(35);
		bst.insert(45);
		bst.insert(43);
		// System.out.println("before delete:");
		bst.dfsdisplay(bst.root);
		System.out.println();
		// System.out.println();
		// bst.delete(2);
		// System.out.println("after delete");
		// bst.display(bst.root);
		bst.delete(45);
		bst.dfsdisplay(bst.root);

	}
}