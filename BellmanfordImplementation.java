import java.util.*;

/*
 *
 * @author Alankar Singh
 *
 * This class shows the implementaton of Bellman Ford.
 */
public class BellmanfordImplementation {

	ArrayList<Object> edges;
	ArrayList<ArrayList> allEdges = new ArrayList<>();
	HashMap<Character, Integer> weightAtVertex = new HashMap<Character, Integer>();
	int infinity = 999;

	/*
	 * Forming an edge between two destination with respective weight
	 * @param char u
	 * @param char v
	 *
	 */
	public void createEdge(char u, char v, int weight) {
		edges = new ArrayList<Object>();
		edges.add(u);
		edges.add(v);
		edges.add(weight);
		allEdges.add(edges);
	}

	/*
	 * To add a new vertex in arraylist of all the vertices with the weight.
	 * @param char val
	 *
	 */
	public void weightAtvertex(char val) {
		
		Iterator<ArrayList> check = allEdges.iterator();
		weightAtVertex.put(val, 0);
		while (check.hasNext()) {
			ArrayList<Object> temp = check.next();
			if (!weightAtVertex.containsKey(temp.get(0)))
				weightAtVertex.put((char) temp.get(0), infinity);
		}
	}

	/*
	 * Forming an edge between two destination with respective weight
	 * @param char u
	 * @param char v
	 *
	 */
	public void BellmanFord() {

		int u, v;
		Iterator check = allEdges.iterator();
		ArrayList<Object> temp;
		int weight;
		for (int i = 0; i < weightAtVertex.size() - 1; i++) {
			while (check.hasNext()) {
				temp = (ArrayList<Object>) check.next();
				u = weightAtVertex.get(temp.get(0));
				v = weightAtVertex.get(temp.get(1));
				weight = (int) temp.get(2);

				if (v > u + weight) {
					v = u + weight;
					weightAtVertex.put((char) temp.get(1), v);
				}
			}
		}

	}

	/*
	 * To check whether a negative cycle is present
	 *
	 */
	public boolean checkCycle() {

		int u, v;
		Iterator check = allEdges.iterator();
		ArrayList<Object> temp;
		int weight;
		while (check.hasNext()) {
			temp = (ArrayList<Object>) check.next();
			u = weightAtVertex.get(temp.get(0));
			v = weightAtVertex.get(temp.get(1));
			weight = (int) temp.get(2);
			if (v > u + weight)
				return true;

		}
		return false;
	}

	/*
	 * This method is optional. Only if you want to check all the edges with the weight.
	 *
	 */
	public void printEdges() {

		for (Map.Entry me : weightAtVertex.entrySet()) {
			System.out.println("Key is : " + me.getKey() + " Value is : " + me.getValue());
		}
	}


	/*
	 * A main method.
	 */
	public static void main(String[] args) {

		BellmanfordImplementation bi = new BellmanfordImplementation();
		bi.createEdge('s', 't', 6);
		bi.createEdge('s', 'y', 7);
		bi.createEdge('t', 'y', 8);
		bi.createEdge('t', 'z', -4);
		bi.createEdge('t', 'x', 5);
		bi.createEdge('y', 'x', -3);
		bi.createEdge('y', 'z', 9);
		bi.createEdge('x', 't', -2);
		bi.createEdge('z', 's', 8);
		bi.createEdge('z', 'x', 7);
		bi.weightAtvertex('s');
		bi.BellmanFord();
		bi.printEdges();
		boolean ans = bi.checkCycle();
		if (ans == true)
			System.out.println("Negative cycle Exists.");
		else
			System.out.println("Negative cycle does not exist.");
		

	}

}
