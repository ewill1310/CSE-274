import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	
	QueueInterface<Integer> queue;
	
	@Before
	public void createQueue() {
		queue = new ArrayQueue<Integer>(); // change to LinkedQueue when you are ready
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.add(10);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testpeek() {
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.add(n);
			assertEquals(47, (int)queue.peek());
		}
	
	}
	
	@Test
	public void testQueueing() {
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.add(n);
			assertFalse(queue.isEmpty());
			assertEquals(n, (int)queue.remove());
			assertTrue(queue.isEmpty());
		}		
		
		for (int n : data) {
			queue.add(n);
		}
		for (int n : data) {
			queue.add(n);
		}
		queue.remove();
		queue.remove();
		for (int n : data) {
			queue.add(n);
		}
		
		for (int i = 2; i < data.length; i++) {
			assertEquals(data[i], (int)queue.remove());
		}
		
		for (int n : data) {
			assertEquals(n, (int)queue.remove());
		}		
		
		while(!queue.isEmpty()) {
			queue.remove();
		}		
		
		assertTrue(queue.isEmpty());		
		
	}
}
