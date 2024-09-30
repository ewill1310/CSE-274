import static org.junit.Assert.*;

import org.junit.Test;

public class TestResizableArraySet {

	@Test
	public void testResizableArraySetInt() {
		Set s = new ResizableArraySet();
		assertEquals(0, s.size());
	}

	@Test
	public void testResizableArraySet() {
		Set s = new ResizableArraySet(4);
		assertEquals(0, s.size());
	}

	@Test
	public void testAdd() {
		Set s = new ResizableArraySet(4);
		assertTrue(s.add("A"));
		assertEquals(1, s.size());
		assertFalse(s.add("A"));
		assertEquals(1, s.size());
		assertTrue(s.add("C"));
		assertTrue(s.add("D"));
		assertEquals(3, s.size());
	}

	@Test
	public void testAddWithResize() {
		Set s = new ResizableArraySet(3);

		for (int i = 1; i <= 3; i++) {
			assertTrue(s.add("" + i));
			assertFalse(s.add("" + i));
			assertEquals(i, s.size());
			assertTrue(s.contains(new String("" + i)));
		}

		// This will require resizing, twice
		for (int i = 4; i <= 7; i++) {
			assertTrue(s.add("" + i));
			assertFalse(s.add("" + i));
			assertEquals(i, s.size());
			assertTrue(s.contains(new String("" + i)));
		}
	}

	// Assumes add is working
//	@Test
//	public void testRemove() {
//		Set s = new ResizableArraySet();
//
//		for (int i = 1; i <= 8; i++) {
//			s.add("" + i);
//		}
//
//		int size = s.size();
//		assertEquals(8, size);
//
//		// Remove the odds
//		for (int i = 1; i <= 7; i += 2) {
//			assertTrue(s.remove(new String("" + i)));
//			size--;
//			assertFalse(s.contains(new String("" + i)));
//			assertEquals(size, s.size());
//			assertFalse(s.remove(new String("" + i)));
//			assertFalse(s.contains(new String("" + i)));
//			assertEquals(size, s.size());
//		}
//
//		// Remove the evens, backwards
//		for (int i = 8; i >= 2; i -= 2) {
//			assertTrue(s.remove(new String("" + i)));
//			size--;
//			assertFalse(s.contains(new String("" + i)));
//			assertEquals(size, s.size());
//			assertFalse(s.remove(new String("" + i)));
//			assertFalse(s.contains(new String("" + i)));
//			assertEquals(size, s.size());
//		}
//
//		assertTrue(s.isEmpty());
//	}

	@Test
	public void testAddAll() {
		String[] letters = { "A", "B", "C", "D" };
		String[] moreLetters = { "C", "D", "E", "F", "F" };

		Set s = new ResizableArraySet();

		s.addAll(letters);
		assertEquals(4, s.size());
		for (String ltr : letters) {
			assertTrue(s.contains(new String(ltr)));
		}

		s.addAll(moreLetters);
		assertEquals(6, s.size());
		for (String ltr : moreLetters) {
			assertTrue(s.contains(new String(ltr)));
		}

	}

	@Test
	public void testContains() {
		Set s = new ResizableArraySet();
		assertFalse(s.contains(new String("A")));
		s.add("A");
		assertTrue(s.contains(new String("A")));
	}

	@Test
	public void testSize() {
		Set s = new ResizableArraySet(3);

		for (int i = 1; i <= 4; i++) {
			s.add("" + i);
			assertEquals(i, s.size());
		}
	}

	@Test
	public void testIsEmpty() {
		Set s = new ResizableArraySet(3);
		assertTrue(s.isEmpty());
		s.add("A");
		assertFalse(s.isEmpty());
	}

	@Test
	public void testClear() {
		Set s = new ResizableArraySet(3);

		s.add("A");
		s.add("B");
		s.add("C");
		
		assertEquals(3, s.size());
		assertFalse(s.isEmpty());
		assertTrue(s.contains("A"));
		assertTrue(s.contains("B"));
		assertTrue(s.contains("C"));
		
		s.clear();
		assertEquals(0, s.size());
		assertTrue(s.isEmpty());
		assertFalse(s.contains("A"));
		assertFalse(s.contains("B"));
		assertFalse(s.contains("C"));
		
	}

	@Test
	public void testToArray() {
		Set s = new ResizableArraySet();
		String[] expectedArray = new String[11];

		for (int i = 0; i < 11; i++) {
			s.add("" + i);
			expectedArray[i] = "" + i;
		}
		
		assertArrayEquals(expectedArray, s.toArray());
	}
	
	/*
	 * This test is meant to check if the algorithm for remove matches
	 * what was shown in class (replacing removed item with last item)
	 */
//	@Test
//	public void testRemoveAlgorithm() {
//		Set s = new ResizableArraySet(6);
//		String[] expArr1 = {"H", "E", "U", "S"};
//		String[] expArr2 = {"S", "E", "U"};
//		String[] expArr3 = {"S", "E"};
//		String[] expArr4 = {"E"};
//		
//		s.add("H");
//		s.add("O");
//		s.add("U");
//		s.add("S");
//		s.add("E");
//		
//		s.remove("O");
//		assertArrayEquals(expArr1, s.toArray());
//		s.remove("H");
//		assertArrayEquals(expArr2, s.toArray());
//		s.remove("U");
//		assertArrayEquals(expArr3, s.toArray());
//		s.remove("S");
//		assertArrayEquals(expArr4, s.toArray());
//	}

}
