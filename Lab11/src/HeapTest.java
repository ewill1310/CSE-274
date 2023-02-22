import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 
 */
/**
 * @author john1819
 *
 */
class HeapTest {
	static MinHeap heap = new MinHeap();

	/**
	 * Test method for {@link MinHeap#insert(int)}.
	 */
	@Test
	final void testInsert() {
		int[] data = { 47, 83, 55, 99, 66, 27, 68 };
		for (int n : data) {
			heap.insert(n);
			assertFalse(heap.isEmpty());
			assertEquals(n, (int) heap.remove());
			assertTrue(heap.isEmpty());
		}
		for (int n : data) {
			heap.insert(n);
		}
		for (int n : data) {
			heap.insert(n);
		}
		heap.remove();
		heap.remove();
		int[] dataSorted = { 47, 47, 55, 55, 66, 66, 68, 68, 83, 83, 99, 99 };
		for (int i = 0; i < dataSorted.length; i++) {
			assertEquals(dataSorted[i], (int) heap.remove());
		}
		while (!heap.isEmpty()) {
			heap.remove();
		}
		assertTrue(heap.isEmpty());
	}

	/**
	 * Test method for {@link MinHeap#getSize()}.
	 */
	@Test
	final void testGetSize() {
		assertEquals(0, heap.getSize());
		heap.insert(10);
		heap.insert(11);
		assertEquals(2, heap.getSize());
		while (!heap.isEmpty()) {
			heap.remove();
		}
	}

	/**
	 * Test method for {@link MinHeap#isEmpty()}.
	 */
	@Test
	final void testIsEmpty() {
		MinHeap empty = new MinHeap();
		assertTrue(empty.isEmpty());
		empty.insert(10);
		assertFalse(empty.isEmpty());
	}
}