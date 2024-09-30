import java.util.Random;
/**
 * 
 * Driver method for Lab 10 - BST
 * @author john1819
 *
 */
public class Lab10Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a binary tree
		SimpleIntegerBST theTree = new SimpleIntegerBST();
		SimpleIntegerBST theTreeTwo = new SimpleIntegerBST();
		
		for(int i = 1; i<=1000; i++) {
			theTreeTwo.insert(i);
		}
		// let's create a tree with the numbers from 1 to 100 for testing
		for (int i = 50; i<= 100; i++)
		{
			//start at 50 so tree is more balanced
			theTree.insert(i);
		}
		// now let's go backwards from 49
		for (int i = 49; i >0; i--)
		{
			theTree.insert(i);
		}
		
		// uncomment below to get a random tree
		/*
		 * theTree = new SimpleIntegerBST(); Random r = new Random(); for (int i = 0; i<
		 * 100; i++) { theTree.insert(r.nextInt(500)); }
		 */
		// let's view the tree; in order
		theTree.inorder();
		
		// tree visualization
	//	theTree.print2D();
		
		// Now let's find unique things
		// first let's get the sum of all the integers in the tree
		long sum = theTree.findTreeSum();
		// should be 5050
		System.out.println("The sum is " + sum);
		
		// now let's count the even numbers
		// should be 50
		int count = theTree.findNumEvens();
		System.out.println("The count is  " + count);
	}

}
