import java.util.ArrayList;
import java.util.Stack;

/**
 * This is a binary expression tree. It is initialized with a postfix string and
 * can be printed out as either the postfix expression or the infix expression.
 * It does
 * 
 * @author john1819
 *
 */
public class BET {

	private BinaryNode root;
	private String postfix;
	private int size;

	/**
	 * Default constructor - creates an empty tree
	 */
	public BET() {
		// creates an empty Tree
		this.postfix = "";
		this.size = 0;
	}

	/**
	 * Constructor accepting postfix string to parse
	 * 
	 * @param pf - the postfix string
	 */
	public BET(String pf) {
		// builds tree based on input postfix string
		buildFromPostfix(pf);
	}
	
	/**
	 * Method to help buildFromPostfix determine if the postfix is properly formatted
	 * @param pf
	 * @return true if it is correct format and throws IllegalArgumentException if not
	 */
	public boolean goodFormat(String pf) {
		int numberCount = 0;
		int operatorCount = 0;
		
		String[] parts = pf.split(" ");
		this.size = parts.length;
		for(String s : parts) {
			if (isOperator(s)) {
				operatorCount++;
			}else {
				numberCount++;
			}
		}
		
		if((numberCount-operatorCount) == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Method accepts input string and builds the tree based on it
	 * 
	 * @param pf - the postfix string
	 * @return - true if tree build, false if bad pf format
	 */
	public boolean buildFromPostfix(String pf) {
		if (!goodFormat(pf)) {
			throw new IllegalArgumentException();
		}
		Stack<BinaryNode> parts = new Stack<>();
		String[] postfixParts = pf.split(" ");
		for (String s : postfixParts) {
			if (isOperator(s)) {
				BinaryNode right = parts.pop();
				BinaryNode left = parts.pop();

				BinaryNode temp = new BinaryNode(s);
				temp.left = left;
				temp.right = right;
				parts.add(temp);
			} else {
				parts.add(new BinaryNode(s));
			}
		}
		root = parts.peek();
		return true;
	}

	/**
	 * Helper method to determine if the character is an operator
	 * 
	 * @param ch
	 * @return
	 */
	public static boolean isOperator(String ch) {
		return (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"));
	}

	/**
	 * Method that prints an infix expression from the BET. If tree is empty, prints
	 * "No expression available"
	 */
	public void printInfixExpression() {
		if (root == null) {
			System.out.println("No expression available");
		} else {
			printInfixExpression(root);
			System.out.print("\n");
		}
	}

	/**
	 * A helper method to recursively travel through the tree to print out the Infix
	 * Expressions
	 * 
	 * @param current
	 */
	public static void printInfixExpression(BinaryNode current) {
		if (current == null) {
			return;
		}
		if (isOperator(current.element)) {
            System.out.print("( ");
        }
		printInfixExpression(current.left);
		System.out.print(current.element + " ");
		printInfixExpression(current.right);
		if (isOperator(current.element)) {
            System.out.print(") ");
        }
	}

	/**
	 * Method that prints postfix expression used to build BET. If tree is empty,
	 * prints "No expression available"
	 */
	public void printPostfixExpression() {
		if (root == null) {
			System.out.println("No expression available");
			return;
		}
		printPostfixExpression(root);
		System.out.print("\n");
	}

	/**
	 * A helper method to recursively loop through the tree to print out the postfix
	 * statement
	 * 
	 * @param root
	 */
	public static void printPostfixExpression(BinaryNode current) {
		if (current == null) {
			return;
		}
		printPostfixExpression(current.left);
		printPostfixExpression(current.right);
		System.out.print(current.element + " ");
	}

	/**
	 * Outputs number of nodes in the tree
	 * 
	 * @return int
	 */
	public int size() {
		return size;
	}

	/**
	 * isEmpty() - returns true if empty, false if not
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * BinaryNode class- class representing a node in the BET. Not accessible
	 * outside this class
	 * 
	 * @author john1819
	 *
	 */
	private class BinaryNode {
		String element;
		BinaryNode right;
		BinaryNode left;

		/**
		 * Constructor to create node with known data
		 * 
		 * @param String - data to be stored
		 */
		public BinaryNode(String element) {
			this.element = element;
			right = null;
			left = null;
		}

	}

}
