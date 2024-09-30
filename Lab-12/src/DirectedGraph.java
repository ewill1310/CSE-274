import java.util.*;

public class DirectedGraph implements Graph {

	private Set<Vertex> verts;
	private int edgeCount;

	public DirectedGraph() {
		verts = new TreeSet<>();
	}

	@Override
	public boolean addVertex(Character c) {
		Vertex temp = new Vertex(c);
		if (verts.contains(temp))
			return false;
		verts.add(temp);
		return true;
	}

	@Override
	public boolean removeVertex(Character c) {
		Vertex temp = getVertex(c);
		if (temp == null)
			return false;
		
		for (Vertex v : verts)
			v.adj.remove(temp);
		verts.remove(temp);
		return true;
	}

	@Override
	public boolean addEdge(Character c1, Character c2) {

		Vertex v1 = getVertex(c1);
		Vertex v2 = getVertex(c2);

		if (v1 == null || v2 == null || v1 == v2 || v1.adj.contains(v2))
			return false;
		
		v1.adj.add(v2);
		edgeCount++;
		return true;
	}

	// helper method to get a particular vertex for a specified character, or return
	// null if
	private Vertex getVertex(Character c) {
		for (Vertex v : verts) {
			if (v.data == c) {
				return v;
			}
		}
		return null;
	}

	@Override
	public boolean removeEdge(Character c1, Character c2) {
		Vertex v1 = getVertex(c1);
		Vertex v2 = getVertex(c2);

		if (v1 == null || v2 == null || v1 == v2 || !v1.adj.contains(v2))
			return false;
		
		v1.adj.remove(v2);
	
		return true;
	}

	@Override
	public boolean hasVertex(Character c) {
		return getVertex(c) != null;
	}

	@Override
	public boolean hasEdge(Character c1, Character c2) {
		Vertex temp1 = getVertex(c1);
		Vertex temp2 = getVertex(c2);

		return temp1 != null && temp2 != null && temp1.adj.contains(temp2);
	}

	@Override
	public boolean isEmpty() {
		return verts.size() != 0;
	}

	@Override
	public List<Character> neighbors(Character c) {
		Vertex temp = getVertex(c);
		List<Character> neighbors = new ArrayList<Character>();
		
		for (Vertex v : temp.adj) {
			neighbors.add(v.data);
		}
		
		return neighbors;
	}

	@Override
	public List<Character> breadthFirstTraversal(Character c) {
		unvisitAll();
		Vertex start = getVertex(c);
		Queue<Vertex> q = new LinkedList<>();
		List<Character> result = new ArrayList<>();
		
		q.add(start);
		start.visited = true;
		
		while (!q.isEmpty()) {
			Vertex front = q.remove();
			result.add(front.data);
			for (Vertex v : front.adj) {
				if (!v.visited) {
					v.visited = true;
					q.add(v);
				}
			}
		}
		
		return result;
	}

	@Override
	public List<Character> depthFirstTraversal(Character c) {
		unvisitAll();
		Vertex start = getVertex(c);
		Stack<Vertex> stk = new Stack<>();
		List<Character> result = new ArrayList<>();
		
		stk.push(start);
		start.visited = true;
		result.add(start.data);
		
		while (!stk.isEmpty()) {
			Vertex top = stk.peek();
			boolean addedNeighbor = false;
			
			for (Vertex v : top.adj) {
				if (!v.visited) { // found an unvisited neighbor
					v.visited = true;
					stk.push(v);
					result.add(v.data);
					addedNeighbor = true;
					break;
				}
			}
			
			if (!addedNeighbor)
				stk.pop();
		}
		
		return result;
	}

	@Override
	public List<Character> shortestPath(Character c1, Character c2) {
		unvisitAll();
		Vertex start = getVertex(c1);
		Vertex end = getVertex(c2);
		Queue<Vertex> q = new LinkedList<>();
		List<Character> result = new ArrayList<>();
		
		q.add(start);
		start.visited = true;		
		Vertex curr = null;
		
		while (curr != end && !q.isEmpty()) {
			curr = q.remove();
			
			for (Vertex v : curr.adj) {
				if (!v.visited) {
					v.visited = true;
					v.previous = curr;
					q.add(v);
				}
			}
		}
		
		// There was a path...put the path in the list
		if (curr == end) {
			while (curr != start) {
				result.add(0, curr.data);
				curr = curr.previous;
			}
			result.add(0, start.data);
		}
		
		return result;
	}

	@Override
	public int vertexCount() {
		return verts.size();
	}

	@Override
	public int edgeCount() {
		return edgeCount;
	}

	public String toString() {
		String result = "";
		for (Vertex v : verts)
			result += v + "\n";
		return result;
	}
	
	public void makeComplete() {
		for (Vertex v1 : verts) {
			// add all other vertices as neighbors
			for (Vertex v2 : verts) {
				if (v1 != v2)
					v1.adj.add(v2);
			}
		}
	}
	
	private void unvisitAll() {
		for (Vertex v : verts)
			v.visited = false;
	}

	private class Vertex implements Comparable<Vertex> {
		private Character data;
		private Set<Vertex> adj;
		boolean visited;
		Vertex previous;

		private Vertex(Character data) {
			this.data = data;
			this.adj = new TreeSet<Vertex>();
			this.visited = false;
			this.previous = null;
		}

		private Vertex getNeighbor(Character c) {
			for (Vertex v : adj) {
				if (v.data == c)
					return v;
			}
			return null;
		}

		// Two vertices are equal if their characters are equal
		// Methods like contains() need equals() to be defined for the objects being
		// compared.
		public boolean equals(Object other) {
			if (this == other)
				return true;
			if (!(other instanceof Vertex))
				return false;
			Vertex that = (Vertex) other;
			return this.data == that.data;
		}

		public String toString() {
			String result = data + ": [";
			for (Vertex v : adj) {
				result = v.data + " ";
			}
			return result.trim() + "]";
		}

		@Override
		public int compareTo(Vertex that) {
			return this.data - that.data;
		}
	}

}
