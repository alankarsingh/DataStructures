import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * This class shows the Implementation of Dijkshtras algorithm.
 * 
 * @author Alankar Singh 
 */
public class DijkshtrasImplementation {

	ArrayList<Object> edges;
	ArrayList<ArrayList> allEdges = new ArrayList<>();
	HashMap<Character, ArrayList<Character>> neighbours = new HashMap<>();
	HashMap<Character, Boolean> visited = new HashMap<>();
	HashMap<Character, Integer> values = new HashMap<Character, Integer>();
	HashMap<Character, Integer> shortestPath = new HashMap<Character, Integer>();

	int infinity = 999;

	/*
	 * A method to create an edge between two points and weight
	 * 
	 * @param char u
	 * 
	 * @param char v
	 * 
	 * @param char weight
	 */
	public void createEdge(char u, char v, int weight) {
		edges = new ArrayList<Object>();
		edges.add(u);
		edges.add(v);
		edges.add(weight);
		allEdges.add(edges);
		char start = u, end = v;
		if (!(neighbours.containsKey(start))) {
			visited.put(start, false);
		}
		if (!(neighbours.containsKey(end))) {
			visited.put(end, false);
		}
		if (neighbours.containsKey(start)) {
			neighbours.get(start).add(end);
		} else {
			ArrayList<Character> edges = new ArrayList<Character>();
			edges.add(end);
			neighbours.put(start, edges);
		}

	}

	/*
	 * @param char val
	 */
	public void values(char val) {

		Iterator<ArrayList> check = allEdges.iterator();
		values.put(val, 0);
		while (check.hasNext()) {
			ArrayList<Object> temp = check.next();
			if (!values.containsKey(temp.get(0)))
				values.put((char) temp.get(0), infinity);
			if (!values.containsKey(temp.get(1)))
				values.put((char) temp.get(1), infinity);
		}
	}

	/*
	 * A method which implements Dijkstra's single source shortest path algorithm
	 */
	public void DjImplementation() {

		ArrayList<Character> temp;
		char value = 'A';
		int dist = 0;

		int min = 999;
		while (values.containsKey(value)) {
			int u = values.get(value);
			if (!neighbours.containsKey(value)) {
				dist = values.get(value);
				shortestPath.put(value, dist);
				values.remove(value);
			} else {
				temp = neighbours.get(value);
				for (int i = 0; i < temp.size(); i++) {
					int v = 0;
					if (shortestPath.containsKey(temp.get(i))) {
						v = shortestPath.get(temp.get(i));
					} else {
						v = values.get(temp.get(i));
					}
					int j = 0;
					int weight = 0;
					boolean flag = true;
					while (flag) {
						if ((char) allEdges.get(j).get(0) == value && (char) allEdges.get(j).get(1) == temp.get(i)) {
							weight = (int) allEdges.get(j).get(2);
							flag = false;
						}
						j++;
					}

					if (v > u + weight) {
						v = u + weight;
						values.put(temp.get(i), v);
					}

				}
				dist = values.get(value);
				shortestPath.put(value, dist);

				values.remove(value);

			}
			int x = 0;
			for (Map.Entry em : values.entrySet()) {

				x = (int) em.getValue();
				if (x < min)
					value = (char) em.getKey();

			}
		}
		shortestPath();

	}
	
	/*
	 * A method to show the shortest path distance between each possible edge
	 */
	public void shortestPath() {
		System.out.println("Shrotest Distance to each vertex from source vertex is here:");
		System.out.println("__________________________");
		char source = 'A';
		for (Map.Entry em : shortestPath.entrySet()) {
			System.out.println(
					"The distance from source " + source + " to destination " + em.getKey() + " is : " + em.getValue());
		}
	}

	public void displayNeighbs() {

		for (Map.Entry em : neighbours.entrySet()) {
			System.out.println(em.getKey() + " " + em.getValue());
		}
	}

	public static void main(String[] args) {
		DijkshtrasImplementation di = new DijkshtrasImplementation();
		di.createEdge('A', 'B', 3);
		di.createEdge('A', 'C', 6);
		di.createEdge('A', 'E', 5);
		di.createEdge('B', 'D', 2);
		di.createEdge('B', 'F', 8);
		di.createEdge('B', 'C', 1);
		di.createEdge('C', 'D', 9);
		di.createEdge('C', 'E', 4);
		di.createEdge('D', 'F', 10);
		di.createEdge('E', 'F', 7);
		di.values('A');
		// di.displayNeighbs();
		di.DjImplementation();

	}
}
