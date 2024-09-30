import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestGraph {

	public DirectedGraph getGraph1() {
		DirectedGraph g1 = new DirectedGraph();
		g1.addVertex('a');
		g1.addVertex('b');
		g1.addEdge('a', 'b');
		return g1;
	}

	// See graph on slide 41 of graphs notes
	// DFS from B: BEFCHI
	// DFS from F: FCBEHI
	// DFS from A: ABEFCHIDG
	// Shortest path from A to E: AE
	// Shortest path from D to B: GHIFCB
	// Shortest path from E to H: EH
	// Shortest path from H to E: HIFCBE
	// Shortest path from B to A: doesn't exist
	public DirectedGraph getGraph2() {

		DirectedGraph g = new DirectedGraph();
		String s = "ABCDEFGHI";

		for (int i = 0; i < s.length(); i++) {
			g.addVertex(s.charAt(i));
		}

		g.addEdge('A', 'B');
		g.addEdge('A', 'E');
		g.addEdge('A', 'D');
		g.addEdge('B', 'E');
		g.addEdge('C', 'B');
		g.addEdge('D', 'G');
		g.addEdge('E', 'H');
		g.addEdge('E', 'F');
		g.addEdge('F', 'H');
		g.addEdge('F', 'C');
		g.addEdge('G', 'H');
		g.addEdge('H', 'I');
		g.addEdge('I', 'F');

		return g;
	}

	
	// DFS from F: FG
	// DFS from G: G
	// DFS from A: ABCFGED
	// DFS from C: CFG
	// Shortest path from A to D: AED
	// Shortest path from A to G: ABCFG
	// Shortest path from D to C: DBC
	public DirectedGraph getGraph3() {
		DirectedGraph g = new DirectedGraph();
		String s = "ABCDEFG";

		for (int i = 0; i < s.length(); i++) {
			g.addVertex(s.charAt(i));
		}

		g.addEdge('A', 'B');
		g.addEdge('A', 'E');
		g.addEdge('B', 'C');
		g.addEdge('C', 'F');
		g.addEdge('D', 'B');
		g.addEdge('D', 'E');
		g.addEdge('D', 'F');
		g.addEdge('E', 'D');
		g.addEdge('E', 'A');
		g.addEdge('F', 'G');

		return g;
	}

	@Test(timeout=1000)
	public void testRemoveEdgeDoesRemoveG1() {
		DirectedGraph g = getGraph1();
		g.removeEdge('a', 'b');
		assertFalse(g.hasEdge('a', 'b'));
	}

	@Test(timeout=1000)
	public void testRemoveEdgeDoesRemoveG2() {
		DirectedGraph g = getGraph2();
		g.removeEdge('A', 'B');
		g.removeEdge('A', 'E');
		g.removeEdge('A', 'D');
		g.removeEdge('B', 'E');
		g.removeEdge('C', 'B');
		g.removeEdge('D', 'G');
		g.removeEdge('E', 'H');
		g.removeEdge('E', 'F');
		g.removeEdge('F', 'H');
		g.removeEdge('F', 'C');
		g.removeEdge('G', 'H');
		g.removeEdge('H', 'I');
		g.removeEdge('I', 'F');

		assertFalse(g.hasEdge('A', 'B'));
		assertFalse(g.hasEdge('A', 'E'));
		assertFalse(g.hasEdge('A', 'D'));
		assertFalse(g.hasEdge('B', 'E'));
		assertFalse(g.hasEdge('C', 'B'));
		assertFalse(g.hasEdge('D', 'G'));
		assertFalse(g.hasEdge('E', 'H'));
		assertFalse(g.hasEdge('E', 'F'));
		assertFalse(g.hasEdge('F', 'H'));
		assertFalse(g.hasEdge('F', 'C'));
		assertFalse(g.hasEdge('G', 'H'));
		assertFalse(g.hasEdge('H', 'I'));
		assertFalse(g.hasEdge('I', 'F'));

	}

	@Test(timeout=1000)
	public void testRemoveEdgeReturnsProperBoolean() {
		DirectedGraph g = getGraph2();

		assertTrue(g.removeEdge('A', 'B'));
		assertTrue(g.removeEdge('A', 'E'));
		assertTrue(g.removeEdge('A', 'D'));
		assertTrue(g.removeEdge('B', 'E'));
		assertTrue(g.removeEdge('C', 'B'));
		assertTrue(g.removeEdge('D', 'G'));
		assertTrue(g.removeEdge('E', 'H'));
		assertTrue(g.removeEdge('E', 'F'));
		assertTrue(g.removeEdge('F', 'H'));
		assertTrue(g.removeEdge('F', 'C'));
		assertTrue(g.removeEdge('G', 'H'));
		assertTrue(g.removeEdge('H', 'I'));
		assertTrue(g.removeEdge('I', 'F'));

		assertFalse(g.removeEdge('A', 'B'));
		assertFalse(g.removeEdge('A', 'E'));
		assertFalse(g.removeEdge('A', 'D'));
		assertFalse(g.removeEdge('B', 'E'));
		assertFalse(g.removeEdge('C', 'B'));
		assertFalse(g.removeEdge('D', 'G'));
		assertFalse(g.removeEdge('E', 'H'));
		assertFalse(g.removeEdge('E', 'F'));
		assertFalse(g.removeEdge('F', 'H'));
		assertFalse(g.removeEdge('F', 'C'));
		assertFalse(g.removeEdge('G', 'H'));
		assertFalse(g.removeEdge('H', 'I'));
		assertFalse(g.removeEdge('I', 'F'));

	}

	@Test(timeout=1000)
	public void testRemoveEdgeHandlesBadInput() {
		DirectedGraph g = getGraph1();
		assertFalse(g.removeEdge('b', 'a'));
		assertFalse(g.removeEdge('c', 'b'));
		assertFalse(g.removeEdge('a', 'c'));
		assertFalse(g.removeEdge('a', 'a'));
		assertFalse(g.removeEdge('b', 'b'));
	}

	
	
	@Test(timeout=1000)
	public void testRemoveVertexG1a() {
		DirectedGraph g = getGraph1();
		g.removeVertex('a');
		assertTrue(g.hasVertex('b'));
		
	}
	
	@Test(timeout=1000)
	public void testRemoveVertexG1aAlsoRemovesEdgeCorrectly() {
		DirectedGraph g = getGraph1();
		g.removeVertex('a');
		g.addVertex('a');
		assertFalse(g.hasEdge('a', 'b'));
	}
	
	@Test(timeout=1000)
	public void testRemoveVertexG2A() {
		DirectedGraph g = getGraph2();
		g.removeVertex('A');
		assertTrue(g.hasVertex('B'));
		assertFalse(g.hasVertex('A'));
	}


	@Test(timeout=1000)
	public void testHasEdgeG1() {
		DirectedGraph g = getGraph1();
		assertTrue(g.hasEdge('a', 'b'));
		assertFalse(g.hasEdge('b', 'a'));
		assertFalse(g.hasEdge('b', 'b'));
		assertFalse(g.hasEdge('a', 'a'));
		assertFalse(g.hasEdge('c', 'a'));
		assertFalse(g.hasEdge('a', 'c'));
		assertFalse(g.hasEdge('x', 'y'));
	}
	
	@Test(timeout=1000)
	public void testHasEdgeG2() {
		DirectedGraph g = getGraph2();
		assertTrue(g.hasEdge('A', 'B'));
		assertTrue(g.hasEdge('A', 'E'));
		assertTrue(g.hasEdge('A', 'D'));
		assertTrue(g.hasEdge('B', 'E'));
		assertTrue(g.hasEdge('C', 'B'));
		assertTrue(g.hasEdge('D', 'G'));
		assertTrue(g.hasEdge('E', 'H'));
		assertTrue(g.hasEdge('E', 'F'));
		assertTrue(g.hasEdge('F', 'H'));
		assertTrue(g.hasEdge('F', 'C'));
		assertTrue(g.hasEdge('G', 'H'));
		assertTrue(g.hasEdge('H', 'I'));
		assertTrue(g.hasEdge('I', 'F'));
		
		assertTrue(g.hasEdge('A', 'B'));
		assertTrue(g.hasEdge('A', 'E'));
		assertTrue(g.hasEdge('A', 'D'));
		assertTrue(g.hasEdge('B', 'E'));
		assertTrue(g.hasEdge('C', 'B'));
		assertTrue(g.hasEdge('D', 'G'));
		assertTrue(g.hasEdge('E', 'H'));
		assertTrue(g.hasEdge('E', 'F'));
		assertTrue(g.hasEdge('F', 'H'));
		assertTrue(g.hasEdge('F', 'C'));
		assertTrue(g.hasEdge('G', 'H'));
		assertTrue(g.hasEdge('H', 'I'));
		assertTrue(g.hasEdge('I', 'F'));
		
	}


	@Test(timeout=1000)
	public void testDepthFirstTraversalG1a() {
		DirectedGraph g = getGraph1();
		String result = "ab";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.depthFirstTraversal('a'));
	}
	
	@Test(timeout=1000)
	public void testDepthFirstTraversalG1b() {
		DirectedGraph g = getGraph1();
		String result = "b";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.depthFirstTraversal('b'));
	}
	
	@Test(timeout=1000)
	public void testDepthFirstTraversalG2B() {
		// DFS from B: BEFCHI
		// DFS from F: FCBEHI
		// DFS from A: ABEFCHIDG
		DirectedGraph g = getGraph2();
		String result = "BEFCHI";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.depthFirstTraversal('B'));
	}

	@Test(timeout=1000)
	public void testDepthFirstTraversalG2F() {
		// DFS from B: BEFCHI
		// DFS from F: FCBEHI
		// DFS from A: ABEFCHIDG
		DirectedGraph g = getGraph2();
		String result = "FCBEHI";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.depthFirstTraversal('F'));
	}
	
	@Test(timeout=1000)
	public void testDepthFirstTraversalResetsVisitedStateOfVertices() {
		// DFS from B: BEFCHI
		// DFS from F: FCBEHI
		// DFS from A: ABEFCHIDG
		DirectedGraph g = getGraph2();
		String result = "FCBEHI";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.depthFirstTraversal('F'));
		assertEquals(expected, g.depthFirstTraversal('F'));
	}
	
	@Test(timeout=1000)
	public void testDepthFirstTraversalG2A() {
		// DFS from B: BEFCHI
		// DFS from F: FCBEHI
		// DFS from A: ABEFCHIDG
		DirectedGraph g = getGraph2();
		String result = "ABEFCHIDG";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.depthFirstTraversal('A'));
	}
	
	@Test(timeout=1000)
	public void testShortestPathG1ab() {
		DirectedGraph g = getGraph1();
		String result = "ab";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.shortestPath('a','b'));
	}
	
	@Test(timeout=1000)
	public void testShortestPathG1ba() {
		DirectedGraph g = getGraph1();
		String result = "";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.shortestPath('b','a'));
	}
	
	@Test(timeout=1000)
	public void testShortestPathG2AE() {
		// Shortest path from A to E: AE
		// Shortest path from D to B: DGHIFCB
		// Shortest path from E to H: EH
		// Shortest path from H to E: HIFCBE
		// Shortest path from B to A: doesn't exist
		DirectedGraph g = getGraph2();
		String result = "AE";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.shortestPath('A', 'E'));
	}
	
	@Test(timeout=1000)
	public void testShortestPathG2DB() {
		// Shortest path from A to E: AE
		// Shortest path from D to B: DGHIFCB
		// Shortest path from E to H: EH
		// Shortest path from H to E: HIFCBE
		// Shortest path from B to A: doesn't exist
		DirectedGraph g = getGraph2();
		String result = "DGHIFCB";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.shortestPath('D', 'B'));
	}
	
	@Test(timeout=1000)
	public void testShortestPathG2EH() {
		// Shortest path from A to E: AE
		// Shortest path from D to B: DGHIFCB
		// Shortest path from E to H: EH
		// Shortest path from H to E: HIFCBE
		// Shortest path from B to A: doesn't exist
		DirectedGraph g = getGraph2();
		String result = "EH";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.shortestPath('E', 'H'));
	}
	
	@Test(timeout=1000)
	public void testShortestPathG2HE() {
		// Shortest path from A to E: AE
		// Shortest path from D to B: DGHIFCB
		// Shortest path from E to H: EH
		// Shortest path from H to E: HIFCBE
		// Shortest path from B to A: doesn't exist
		DirectedGraph g = getGraph2();
		String result = "HIFCBE";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.shortestPath('H', 'E'));
	}
	
	@Test(timeout=1000)
	public void testShortestPathG2BA() {
		// Shortest path from A to E: AE
		// Shortest path from D to B: DGHIFCB
		// Shortest path from E to H: EH
		// Shortest path from H to E: HIFCBE
		// Shortest path from B to A: doesn't exist
		DirectedGraph g = getGraph2();
		String result = "";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.shortestPath('B', 'A'));
	}
	
	@Test(timeout=1000)
	public void testShortestPathResetsVertices() {
		// Shortest path from A to E: AE
		// Shortest path from D to B: DGHIFCB
		// Shortest path from E to H: EH
		// Shortest path from H to E: HIFCBE
		// Shortest path from B to A: doesn't exist
		DirectedGraph g = getGraph2();
		String result = "";
		List<Character> expected = new ArrayList<>();
		for (int i = 0; i < result.length(); i++)
			expected.add(result.charAt(i));
		
		assertEquals(expected, g.shortestPath('B', 'A'));
		assertEquals(expected, g.shortestPath('B', 'A'));
	}

	@Test(timeout=1000)
	public void testMakeCompleteG1() {
		DirectedGraph g = getGraph1();
		g.makeComplete();
		
		String verts = "ab";
		for (int i = 0; i < verts.length(); i++) {
			for (int j = 0; j < verts.length(); j++) {
				// when i and j are different, we should find an edge
				// when i and j are the same, we should not find an edge
				assertEquals( i == j, !g.hasEdge(verts.charAt(i), verts.charAt(j)));
			}
		}
	}
	
	@Test(timeout=1000)
	public void testMakeCompleteG2() {
		DirectedGraph g = getGraph2();
		g.makeComplete();
		
		String verts = "ABCDEFGHI";
		for (int i = 0; i < verts.length(); i++) {
			for (int j = 0; j < verts.length(); j++) {
				// when i and j are different, we should find an edge
				// when i and j are the same, we should not find an edge
				assertEquals( i == j, !g.hasEdge(verts.charAt(i), verts.charAt(j)));
			}
		}
	}

}
