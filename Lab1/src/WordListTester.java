
/**Written By: Evan Williams
 * For CSE-274 Lab 1
 * Due 9/1/22
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class WordListTester {

	// assertTrue(), assertEquals()

	@Test
	public void testConstructors() {
		WordList test = new WordList();
		WordList test2 = new WordList(2);
	}

	@Test
	public void testSize() {
		WordList list = new WordList(3);
		list.set(0, "a");
		list.set(1, "b");
		list.set(2, "c");

		assertEquals(3, list.size(), 0.000001);
	}

	@Test
	public void testAdd() {
		WordList test = new WordList();
		test.add("grape");
		assertEquals(test.add("apple"), true);
		assertEquals(test.add(2, "potato"), true);
	}

	@Test
	public void testGet() {
		WordList test = new WordList();
		test.add("apple");
		assertEquals(test.get(0), "apple");
	}

	@Test
	public void testRemove() {
		WordList test = new WordList();
		test.add("apple");
		test.add("potato");
		assertEquals("apple", test.remove(0));
		assertEquals(true, test.remove("potato"));
	}

	@Test
	public void testClear() {
		WordList test = new WordList();
		test.add("apple");
		test.add("potato");
		test.clear();
		assertEquals(test.get(0), "");
		assertEquals(test.get(1), "");
	}

	@Test
	public void testContains() {
		WordList test = new WordList();
		test.add("apple");
		test.add("potato");
		assertEquals(true, test.contains("apple"));
		assertEquals(true, test.contains("potato"));
		assertEquals(false, test.contains("grape"));
	}

	@Test
	public void testSet() {
		WordList test = new WordList();
		test.add("apple");
		test.set(0, "potato");
		assertEquals("potato", test.get(0));
	}

	@Test
	public void testToArray() {
		WordList test = new WordList();
		test.add("apple");
		test.add("potato");
		String[] list = test.toArray();
		assertEquals(list.length, 2, 0.00000001);
		assertTrue(list[0].equals("apple"));
		assertTrue(list[1].equals("potato"));
	}

}
