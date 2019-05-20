
import java.util.*;
/*
 * This class shows the implementation of graph
 * @author Alankar Singh
 */
public class GraphImplementation {

	HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
	HashMap<Character, Boolean> visited = new HashMap<>();
	Queue<Character> checkBFS = new LinkedList<Character>(); // for bfs
	Stack<Character> checkDFS = new Stack<Character>();
	
	int i = 0;
	
	/*
	 * A method to add all the points to create edges
	 * @param char start, char end
	 */
	public void add(char start, char end) {

		if (!(graph.containsKey(start))) {
			visited.put(start, false);
		}
		if (!(graph.containsKey(end))) {
			visited.put(end, false);
		}
		if (graph.containsKey(start)) {
			graph.get(start).add(end);
		} else {
			ArrayList<Character> edges = new ArrayList<Character>();
			edges.add(end);
			graph.put(start, edges);
		}

	}
	
	// A method to show all the key value pair
	public void visited() {
		for (Map.Entry em : visited.entrySet()) {
			System.out.println("Key is: " + em.getKey() + " Value is : " + em.getValue());
		}
	}

	/*
	 * A method to show the DFS Traversal
	 * @param char value
	 */
	public void DFSTraversal(char value) {

		ArrayList<Character> child = new ArrayList<Character>();
		System.out.print(" " + value);
		visited.put(value, true);

		child = graph.get(value);
		
		if (child != null) {
			
			for (int i = 0; i < child.size(); i++) {
				if (visited.get(child.get(i)) == false) {
					DFSTraversal(child.get(i));
				}
			}
		}
	}
	/*
	 * A method to show the BFS Traversal
	 * @param char value
	 */
	public void BFSTraversal(char value) {
		
		ArrayList<Character> child = new ArrayList<Character>();

		if (checkBFS.isEmpty()) {
			checkBFS.add(value);
		}
		while (!checkBFS.isEmpty()) {
			char pop = checkBFS.poll();
			if (visited.get(pop) == false) {
				System.out.print(" " + pop);
				visited.put(pop, true);
			}
			child = graph.get(pop);
			if (child != null) {
				for (int i = 0; i < child.size(); i++) {
					checkBFS.add(child.get(i));
				}
			}
		}

	}

	public void graphDisplay() {

		for (Map.Entry me : graph.entrySet()) {
			System.out.println("Key : " + me.getKey() + " value : " + me.getValue());
		}
	}

	public static void main(String[] args) {

		GraphImplementation gi = new GraphImplementation();
		gi.add('A', 'B');
		gi.add('A', 'D');
		gi.add('A', 'G');
		gi.add('B', 'E');
		gi.add('B', 'F');
		gi.add('E', 'G');
		gi.add('F', 'C');
		gi.add('F', 'D');
		gi.add('C', 'H');
		// gi.visited();
		 gi.graphDisplay();
//		 gi.BFSTraversal('A');
//   		 gi.DFSTraversal('A');

	}
}
