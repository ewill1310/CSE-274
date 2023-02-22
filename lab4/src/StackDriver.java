
/**
 * Tester program for stack implementation
 * -Do not modify
 * @author john1819
 *
 */
public class StackDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create an instance of GenericStack that
		// accepts Strings
		GenericStack<String> stringStack =
				new GenericStack<String>();
		stringStack.push("Java");
		stringStack.push("love");
		stringStack.push("I");
		
		
		// create a new String by concatenating
		// the popped Strings
		String phrase = "" + stringStack.pop() +
				stringStack.pop() + stringStack.pop();
		System.out.println(phrase);
		stringStack.push("garbage");
		stringStack.clear();
		System.out.println("Is String stack empty (true): " + stringStack.isEmpty());
		
		// now let's do numbers
		GenericStack<Integer> intStack = new GenericStack<Integer>();
		
		intStack.push(95);
		intStack.push(55);
		System.out.println("Peek at intStack: (should be 55): " + intStack.peek());
		
		intStack.push(33);
		intStack.pop();
		intStack.pop();
		System.out.println("Pop from intstack(should be 95): " + intStack.pop());
		
		System.out.println("Is empty?= should be true  :" + intStack.isEmpty());
		System.out.println("The end");
	}

}
