
/**
 * A simple BST that is only used to store Integer types. For use with Lab 10.
 * 
 * @author john1819
 *
 */
public class SimpleIntegerBST implements Tree {

	protected TreeNode<Integer> root;
	protected int size = 0;
	static final int COUNT = 10;

	@Override
	public boolean search(Integer e) {
		TreeNode<Integer> current = root; // Start from the root

		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else // element matches current.element
				return true; // Element is found
		}

		return false;
	}

	@Override
	public boolean insert(Integer e) {
		if (root == null)
			root = createNewNode(e); // Create a new root
		else {
			// Locate the parent node
			TreeNode<Integer> parent = null;
			TreeNode<Integer> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else
					return false; // Duplicate node not inserted
			}
			// Create the new node and attach it to the parent node
			if (e.compareTo(parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}
		size++;
		return true; // Element inserted successfully
	}

	protected TreeNode<Integer> createNewNode(Integer e) {
		return new TreeNode<Integer>(e);
	}

	@Override
	public boolean delete(Integer e) {
		/**
		 * Delete an element from the binary tree. Return true if the element is deleted
		 * successfully Return false if the element is not in the tree
		 */

// Locate the node to be deleted and also locate its parent node
		TreeNode<Integer> parent = null;
		TreeNode<Integer> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // Element is in the tree pointed at by current
		}

		if (current == null)
			return false; // Element is not in the tree

// Case 1: current has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {
				root = current.right;
			} else {
				if (e.compareTo(parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		} else {
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<Integer> parentOfRightMost = current;
			TreeNode<Integer> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		return true; // Element deleted successfully
	}

	@Override
	public void inorder() {
		inorder(root);
	}

	/**
	 * In order helper method
	 * 
	 * @param root
	 */
	protected void inorder(TreeNode<Integer> root) {
		// prints the tree contents in order
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.element);
		inorder(root.right);

	}

	@Override
	public void postorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void preorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// additional code modified from
	// https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
	// prints a 2-d representation of the tree
	private void print2DUtil(TreeNode<Integer> root, int space) {
		// Base case
		if (root == null)
			return;

		// Increase distance between levels
		space += COUNT;

		// Process right child first
		print2DUtil(root.right, space);

		// Print current node after space
		// count
		System.out.print("\n");
		for (int i = COUNT; i < space; i++)
			System.out.print(" ");
		System.out.print(root.element + "\n");

		// Process left child
		print2DUtil(root.left, space);
	}

	// Wrapper over print2DUtil()
	public void print2D() {
		// Pass initial space count as 0
		print2DUtil(root, 0);
	}

	// things to do
	public int findTreeSum() {
		/// implement this method that traverses the tree and returns the sum of all the
		/// nodes
		int sum = findTreeSum(root);
		return sum;
	}
	
	/**
	 * This is a helper class for the findTreeSum method
	 * @param root
	 * @return sum of Tree
	 */
	public int findTreeSum(TreeNode<Integer> root) {
		int sum = 0;
		if (root == null) {
			return sum;
		}
		sum = findTreeSum(root.left);
		sum = sum + root.element;
		sum = sum + findTreeSum(root.right);
		return sum;

	}

	public int findNumEvens() {
		// implement this method that traverses the tree and counts how many nodes
		// contain even numbers
		int amount = findNumEvens(root);
		return amount;
	}

	/**
	 * This is a helper method for findNumEvens
	 * @param root
	 * @return
	 */
	public int findNumEvens(TreeNode<Integer> root) {
		int amount = 0;
		if (root == null) {
			return amount;
		}
		amount = findNumEvens(root.left);
		if(root.element%2 == 0) {
			amount++;
		}
		amount = amount + findNumEvens(root.right);
		return amount;
	}
	
	
	/**
	 * This inner class is static, because it does not access any instance members
	 * defined in its outer class
	 */
	public static class TreeNode<E extends Comparable<E>> {
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}

}
