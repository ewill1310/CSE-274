
/**Originally provided by Cynthia Johnson
 * Edited By: Evan Williams
 * For CSE-274 Lab 1
 * Due 9/1/22
 */
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {

		// Do your own testing here. Create a WordList object,
		// add, remove, check what's in the array, and so on.
		// Test edge cases as you go.
		WordList test = new WordList();
		
		// Test add
		test.add("apple");
		test.add("potato");
		System.out.println("Current WordList contents:");
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}

		// Test remove
		System.out.println(test.remove(0));
		System.out.println(test.remove("potato"));
		System.out.println("Current WordList contents:");
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
		System.out.println("");
		
		// Test contains
		test.add("apple");
		test.add("potato");
		System.out.println("The word potato is in the array: " + test.contains("potato"));
		System.out.println("The word apple is in the array: " + test.contains("apple"));
		System.out.println("");
		
		// Test set
		test.set(0, "grape");
		test.set(1, "chocolate");
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
		System.out.println("");

		// Test to Array
		test.add("apple");
		test.add("potato");
		String[] list = test.toArray();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		System.out.println("");
		
		// Test clear and Size
		System.out.println("Before clear: ");
		System.out.println("WordList contains: " + test.size() + " words.");
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
		test.clear();
		System.out.println("After clear: ");
		System.out.println("WordList contains: " + test.size() + " words.");
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
	}

}
