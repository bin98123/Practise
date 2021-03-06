package week8_prim_and_kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class WeightGraph {
	private double[][] adjmatrix;
	private double weight = Double.POSITIVE_INFINITY;
	private List<Edge> list = new ArrayList<Edge>();

	public List<Edge> getList() {
		return list;
	}

	public void setList(List<Edge> list) {
		this.list = list;
	}

	public WeightGraph(int n) {
		adjmatrix = new double[n][n];

	}

	public double[][] getAdjmatrix() {
		return adjmatrix;
	}

	public void setAdjmatrix(double[][] adjmatrix) {
		this.adjmatrix = adjmatrix;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private int numOfVertices() {
		// TODO Auto-generated method stub
		return adjmatrix[0].length;
	}

	public void addEdge(int u, int v, double w) {
		for (int i = 0; i < adjmatrix.length; i++) {
			for (int j = 0; j < adjmatrix.length; j++) {
				if (adjmatrix[i][j] == 0 || adjmatrix[j][i] == 0) {
					adjmatrix[i][j] = adjmatrix[j][i] = weight;
				}
			}
		}
		adjmatrix[u][v] = w;
		adjmatrix[v][u] = w;

	}

	public void addEdgeDirected(int u, int v, double w) {
		for (int i = 0; i < adjmatrix.length; i++) {
			for (int j = 0; j < adjmatrix.length; j++) {
				if (adjmatrix[i][j] == Double.POSITIVE_INFINITY) {
					adjmatrix[i][j] = weight;
				}
				if (adjmatrix[i][j] == 0) {
					adjmatrix[i][j] = Double.POSITIVE_INFINITY;
				}
			}
		}
		adjmatrix[u][v] = w;

	}

	public void addEdge(int u, int v, WeightGraph input) {
//		for (int i = 0; i < input.; i++) {
//			for (int j = 0; j < input.length; j++) {
		if (!checkPathOfTwoVertex(u, v)) {
			input.adjmatrix[u][v] = input.adjmatrix[v][u] = 1;
		}
//			}
//		}

	}

	public void removeEdge(int u, int v) {
//		adjmatrix[u][v] = Integer.MAX_VALUE;
//		adjmatrix[v][u] = Integer.MAX_VALUE;
		adjmatrix[u][v] = weight;
		adjmatrix[v][u] = weight;

	}

	public void DFS(int start, WeightGraph input) {
		getWeightGraphForDFS(input);
		Stack<Integer> stack = new Stack<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		stack.push(v);
		WeightGraph T = new WeightGraph(input.getLength());
		System.out.print(start);
		while (!stack.empty()) {
			v = stack.peek();
			int j = -1;
			for (int k = 0; k < input.getLength(input); k++) {
				if (input.getAdjmatrix()[v][k] != Double.POSITIVE_INFINITY && !visited.contains(k)) {
					j = k;
					break;
				}
			}
			if (j != Double.POSITIVE_INFINITY) {
//				System.out.print(j);
				System.out.print("=>" + j);
				stack.push(v);
				T.addEdge(v, j, input);
				v = j;
				visited.add(j);

			} else if (!stack.empty())
				stack.pop();
		}
		System.out.println("Khung c??y: " + T);
	}

	public WeightGraph BFS(int start, WeightGraph input) {
		getWeightGraphForDFS(input);
		Queue<Integer> stack = new LinkedList<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
//		WeightGraph T = new WeightGraph(input.getLength());
		WeightGraph T = new WeightGraph(input.getLength());
		visited.add(v);
		stack.add(v);
		System.out.print(start);
		while (!stack.isEmpty()) {
			v = stack.peek();
			int j = -1;
			for (int k = 0; k < input.getLength(input); k++) {
				if (input.getAdjmatrix()[v][k] != Double.POSITIVE_INFINITY && !visited.contains(k)
						&& checkCircle(v, j, input.getAdjmatrix()) == false) {

					j = k;
					break;
				}
			}
//			if (j >= 0 && !checkCircle(v, j, input.getAdjmatrix())) {
			if (j != Double.POSITIVE_INFINITY) {
				visited.add(j);
//				System.out.print(j);
				System.out.print("=>" + j);
				T.addEdge(v, j, input);
				v = j;
				stack.add(v);

			} else if (!stack.isEmpty())
				stack.poll();
		}
		return T;
	}

	public WeightGraph getKruskal() {
		WeightGraph graph = new WeightGraph(adjmatrix.length);
		getWeightGraph(graph);
		int count = 0;
//		while (graph.numberOfEdge(graph.adjmatrix) <= (graph.getLength() - 1)) {
		List<Edge> listEdge = getSortWeightKruskal();
//		Edge temp = listEdge.get(i);
		for (int i = 0; i < listEdge.size(); i++) {
			Edge temp = listEdge.get(i);
			// n???u s??? c???nh ??c th??m t??ng ?????n (t???ng s??? ?????nh -1) th?? d???ng
			if (count == (graph.getLength() - 1)) {
				graph.numberOfEdge(graph.adjmatrix);
				break;
			} else if (graph.checkCircle(temp.getBegin(), temp.getEnd(), graph.getAdjmatrix()) == false) {
				graph.addEdge(temp.getBegin(), temp.getEnd(), temp.getWeight());
				// ?????m s??? l???n th??m c???nh
				count++;
				// In th??? t??? duy???t
				System.out.println(" " + count + ". " + new Edge(temp.getBegin(), temp.getEnd(), temp.getWeight()));
			}
		}
//		System.out.println("--------------------");
//		}
		return graph;
	}

	public WeightGraph getTree() {
		WeightGraph graph = new WeightGraph(adjmatrix.length);
		getWeightGraph(graph);
		int count = 0;
//		while (graph.numberOfEdge(graph.adjmatrix) <= (graph.getLength() - 1)) {
		List<Edge> listEdge = getTreeSub();
//		Edge temp = listEdge.get(i);
		for (int i = 0; i < listEdge.size(); i++) {
			Edge temp = listEdge.get(i);
			// n???u s??? c???nh ??c th??m t??ng ?????n (t???ng s??? ?????nh -1) th?? d???ng
			if (count == (graph.getLength() - 1)) {
				graph.numberOfEdge(graph.adjmatrix);
				break;
			} else if (graph.checkCircle(temp.getBegin(), temp.getEnd(), graph.getAdjmatrix()) == false) {
				graph.addEdge(temp.getBegin(), temp.getEnd(), temp.getWeight());
				// ?????m s??? l???n th??m c???nh
				count++;
				// In th??? t??? duy???t
				System.out.println(" " + count + ". " + new Edge(temp.getBegin(), temp.getEnd(), temp.getWeight()));
			}
		}
//		System.out.println("--------------------");
//		}
		return graph;
	}

	public List<Edge> getSortWeightKruskal() {
		List<Edge> result = new ArrayList<Edge>();
		for (int i = 0; i < adjmatrix.length; i++) {
			for (int j = 0; j < adjmatrix.length; j++) {
				result.add(new Edge(i, j, adjmatrix[i][j]));
			}
		}
		Collections.sort(result);
		return result;

	}

	public List<Edge> getTreeSub() {
//		Set<Edge> result = new HashSet<Edge>();
		List<Edge> result = new ArrayList<Edge>();
		for (int i = 0; i < adjmatrix.length; i++) {
			for (int j = 0; j < adjmatrix.length; j++) {
				result.add(new Edge(i, j, adjmatrix[i][j]));
			}
		}
		return result;

	}

	public WeightGraph getPrim(int input) {
		WeightGraph graph = new WeightGraph(adjmatrix.length);
		getWeightGraph(graph);
		List<Integer> list = new ArrayList<Integer>();
		list.add(input);
		int count = 0;
		List<Edge> listEdge = getEdgeWeightPrim(input);
		// s???p x???p danh s??ch c???nh
		getSortWeightPrimSub(listEdge);

		for (int i = 0; i < listEdge.size(); i++) {
			for (int j = 0; j < listEdge.size(); j++) {
				Edge temp = listEdge.get(j);
				// n???u s??? c???nh ??c th??m t??ng ?????n (t???ng s??? ?????nh -1) th?? d???ng
				if (count == (graph.getLength(graph)) - 1) {
					break;
				} else if (graph.checkCircle(temp.getBegin(), temp.getEnd(), graph.getAdjmatrix()) == false) {
					// ?????m s??? l???n th??m c???nh
					count++;
					graph.addEdge(temp.getBegin(), temp.getEnd(), temp.getWeight());
					// T??m c??c ?????nh ??c th??m v??o ????? x??t
					List<Integer> l = listNearByVertex(temp.begin);
					for (int m : l) {
						list.add(m);
//						Th??m c???nh ch???a c??c ?????nh v??o danh s??ch x??t
						List<Edge> listTemp = getEdgeWeightPrim(m);
						for (Edge k : listTemp) {
							listEdge.add(k);
						}
					}
					// In th??? t??? duy???t
					System.out.println(" " + count + ". " + new Edge(temp.getBegin(), temp.getEnd(), temp.getWeight()));
					// s???p x???p l???i danh s??ch c???nh sau khi th??m c???nh
					getSortWeightPrimSub(listEdge);
//					System.out.println("Danh s??ch c??c c???nh ch??? x??t: " + listEdge);

				}
			}
		}
		return graph;

	}

	public List<Edge> getSortWeightPrim(List<Integer> input, List<Integer> list) {
//		Set<Edge> result = new HashSet<Edge>();
		List<Edge> result = new ArrayList<Edge>();
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				result.add(new Edge(i, j, adjmatrix[input.get(i)][list.get(j)]));
			}
		}
		Collections.sort(result);
		return result;

	}

	// L???y c??c c???nh ch???a ?????nh ??ang x??t
	public List<Edge> getEdgeWeightPrim(int input) {
		List<Edge> result = new ArrayList<Edge>();
		for (int j = 0; j < adjmatrix.length; j++) {
			if (adjmatrix[input][j] != Double.POSITIVE_INFINITY) {
				result.add(new Edge(input, j, adjmatrix[input][j]));
			}
		}
		Collections.sort(result);
		return result;

	}

	// S???p x???p c??c c???nh
	public void getSortWeightPrimSub(List<Edge> input) {
		Collections.sort(input);

	}

	public List<Integer> listNearByVertex(int vertex) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < adjmatrix.length; i++) {
			if (adjmatrix[vertex][i] != Double.POSITIVE_INFINITY && !result.contains(i)) {
				result.add(i);
			}
		}
		return result;
	}

	// In ma tr???n
	public String printMatrix() {
		String result = "";
		for (int i = 0; i < adjmatrix.length; i++) {
			for (int j = 0; j < adjmatrix.length; j++) {
				if (j != adjmatrix.length - 1) {
//					if (adjmatrix[i][j] < Double.POSITIVE_INFINITY) {
					if (adjmatrix[i][j] < 10) {
						result += adjmatrix[i][j] + "      ";
					} else if (adjmatrix[i][j] == Double.POSITIVE_INFINITY) {
						result += adjmatrix[i][j] + " ";
					}
				} else if (adjmatrix[i][j] > 10 && adjmatrix[i][j] < Double.POSITIVE_INFINITY) {
					result += adjmatrix[i][j] + "     ";
				} else if (j == adjmatrix.length - 1) {
					result += adjmatrix[i][j] + "\n";
				}
			}
		}

		return result;

	}

	private void addEdge(Edge edge) {
		// TODO Auto-generated method stub
		list.add(edge);

	}

	private void removeEdge(Edge edge) {
		// TODO Auto-generated method stub
		list.remove(edge);

	}

	// s??? c???nh c???a matrix
	public int numberOfEdge() {
		int i = 0;
		for (int j = 0; j < adjmatrix.length; j++) {
			i += degree(j);
		}
		i = i / 2;
		return i;
	}

	public int numberOfEdge(double[][] input) {
		int i = 0;
		for (int j = 0; j < input.length; j++) {
			i += degree(j, input);
		}
		i = i / 2;
		return i;
	}

	// b???c c???a ?????nh
	public int degree(int v) {
		int i = 0;
		for (int j = 0; j < adjmatrix.length; j++) {
			if (adjmatrix[v][j] != Double.POSITIVE_INFINITY) {
				i++;
			}
		}
		return i;
	}

	public int getLength() {
		return adjmatrix.length;
	}

	public int getLength(WeightGraph input) {
		return input.getAdjmatrix().length;
	}

	public int degree(int v, double[][] input) {
		int i = 0;
		for (int j = 0; j < input.length; j++) {
			if (input[v][j] != Double.POSITIVE_INFINITY) {
				i++;
			}
		}
		return i;
	}

	public void addEdge(int u, int v, int w, double[][] input) {
//		input[u][v]++;
//		input[v][u]++;
//		input[u][v] = weight;
//		input[v][u] = weight;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i][j] == 0 || input[j][i] == 0) {
					input[i][j] = input[j][i] = weight;
				}
			}
		}
		input[u][v] = w;
		input[v][u] = w;
	}

	public void removeEdge(int u, int v, double[][] input) {
		input[u][v]--;
		input[v][u]--;
		input[u][v] = weight;
		input[v][u] = weight;

	}

	public boolean checkConnected() {
		for (int i = 1; i < adjmatrix.length; i++) {

			if (!checkPathOfTwoVertex(0, i)) {
				return false;

			}
		}
		return true;
	}

	public boolean checkConnected(double[][] input) {
		for (int i = 1; i < input.length; i++) {

			if (!checkPathOfTwoVertex(0, i)) {
				return false;

			}
		}
		return true;
	}

	//////////////////////////////////////////////////
	// f. Ki???m tra c?? ???????ng ??i gi???a 2 ?????nh cho tr?????c
	public boolean checkPathOfTwoVertex(int start, int end) {
		boolean result = false;
		Queue<Integer> queue = new LinkedList<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		queue.add(v);
		while (!queue.isEmpty()) {
			v = queue.peek();
			int j = -1;
			for (int k = 0; k < this.getLength(); k++) {
				if (adjmatrix[v][k] > 0 && !visited.contains(k)) {
					j = k;
					break;
				}
			}
			if (j >= 0) {
				visited.add(j);
				v = j;
				queue.add(v);
				if (visited.contains(end)) {
					result = true;
					break;
				}

			} else if (!queue.isEmpty())
				queue.poll();
		}
		return result;
	}

// Ki???m tra c?? ???????ng ??i gi???a 2 ?????nh
	public boolean checkPathOfTwoVertex(int start, int end, double[][] input) {
		boolean result = false;
		Stack<Integer> stack = new Stack<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		stack.add(v);
		while (!stack.isEmpty()) {
			v = stack.peek();
			int j = -1;
			for (int k = 0; k < this.getLength(); k++) {
				if (input[v][k] != Double.POSITIVE_INFINITY && !visited.contains(k)) {
					j = k;
					break;
				}
			}
			if (j >= 0) {
				visited.add(j);
				v = j;
				stack.add(v);
				if (visited.contains(end)) {
					result = true;
					break;
				}

			} else if (!stack.isEmpty())
				stack.pop();
		}
		return result;
	}

// Ki???m tra c?? ???????ng ??i gi???a 2 ?????nh
	public boolean checkPathOfTwoVertex(int start, int end, int[][] input) {
		boolean result = false;
		Stack<Integer> stack = new Stack<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		stack.add(v);
		while (!stack.isEmpty()) {
			v = stack.peek();
			int j = -1;
			for (int k = 0; k < this.getLength(); k++) {
				if (input[v][k] != Double.POSITIVE_INFINITY && !visited.contains(k)) {
					j = k;
					break;
				}
			}
			if (j >= 0) {
				visited.add(j);
				v = j;
				stack.add(v);
				if (visited.contains(end)) {
					result = true;
					break;
				}

			} else if (!stack.isEmpty())
				stack.pop();
		}
		return result;
	}

// Ki???m tra c?? chu tr??nh con hay kh??ng?
	public boolean checkCircle(int begin, int end, double[][] input) {
		// N???u c?? ???????ng ??i gi???a 2 ?????nh c???a c???nh ??c th??m th?? th??m c???nh ???? v??o
		// s??? tr??? th??nh 1 chu tr??nh
		if (checkPathOfTwoVertex(begin, end, input) == true) {
			return true;
		} else if (checkPathOfTwoVertex(begin, end, input) == false) {
			return false;
		}
		return false;
	}

	public boolean checkCircle(int begin, int end, int[][] input) {
		// N???u c?? ???????ng ??i gi???a 2 ?????nh c???a c???nh ??c th??m th?? th??m c???nh ???? v??o
		// s??? tr??? th??nh 1 chu tr??nh
		if (checkPathOfTwoVertex(begin, end, input) == true) {
			return true;
		} else if (checkPathOfTwoVertex(begin, end, input) == false) {
			return false;
		}
		return false;
	}

// 
	public List<Integer> listNextToVertex(int vertex, int[][] input) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (input[vertex][i] != Double.POSITIVE_INFINITY) {
				result.add(i);
			}
		}
		return result;

	}

	// Thi???t l???p gi?? tr??? cho ????? th??? c?? tr???ng s???
	public void getWeightGraph(WeightGraph input) {
		for (int i = 0; i < input.adjmatrix.length; i++) {
			for (int j = 0; j < input.adjmatrix.length; j++) {
				input.adjmatrix[i][j] = weight;
			}
		}
	}

	public void getWeightGraphForDFS(WeightGraph input) {
		for (int i = 0; i < input.adjmatrix.length; i++) {
			for (int j = 0; j < input.adjmatrix.length; j++) {

				if (input.adjmatrix[i][j] == weight) {
					input.adjmatrix[i][j] = 0;
				}
			}
		}
	}

	// Ki???m tra ????? th??? c?? ph???i l?? c??y hay ko
	public boolean checkTree(double[][] input) {
		// N???u ????? th??? l?? c??y th??: ????? th??? li??n th??ng v?? c?? s??? c???nh = (t???ng s??? ?????nh -1)
		if (checkConnected(input) && numberOfEdge() == input.length - 1) {
			return true;
		}
		return false;
	}

	// Kho???ng c??ch t??? 1 ?????nh ?????n 1 ?????nh
	public int getDistanceOfTwoVertex(int start, int end, double[][] input) {
//		Stack<Integer> result = new Stack<Integer>();
		int result = 0;
		if (checkPathOfTwoVertex(start, end)) {
//			System.out.print("???????ng ??i gi???a " + start + " v?? " + end + ": ");
			Stack<Integer> stack = new Stack<Integer>();
			int v = start;
			List<Integer> visited = new ArrayList<Integer>();
			visited.add(v);
			stack.add(v);
//			System.out.print(start);
			while (!stack.isEmpty()) {
				v = stack.peek();
				int j = -1;
				for (int k = 0; k < this.getLength(); k++) {
					if (input[v][k] != Double.POSITIVE_INFINITY && !visited.contains(k)) {
						j = k;
						break;
					}
				}
				if (j >= 0) {
					visited.add(j);
//					System.out.print("=>" + j);
					v = j;
					stack.add(v);
					if (visited.contains(end)) {
						break;
					}

				} else if (!stack.isEmpty())
					stack.pop();
			}
			result = stack.size() - 1;
		} else if (!checkPathOfTwoVertex(start, end)) {
//			System.out.println("Kh??ng c?? ???????ng ??i gi???a " + start + " v?? " + end);
		}
		return result;
	}

	// T??nh ????? l???ch t??m c???a 1 ?????nh trong c??y
	// ????? l???ch t??m c???a 1 ?????nh = max(kho???ng c??ch t??? ?????nh ???? ?????n c??c ?????nh c??n l???i)
	public int getEccentricity(int vertex, double[][] input) {
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			int max = 0;
			if (i != vertex) {
				// Kho???ng c??ch t??? ?????nh ??c x??t ?????n c??c ?????nh c??n l???i
				max = getDistanceOfTwoVertex(vertex, i, input);

			}
			// l???y kho???ng c??ch l???n nh???t t??? ?????nh ??c x??t ?????n c??c ?????nh c??n l???i
			if (result < max) {
				result = max;
			}
		}
		return result;

	}

	// T??m c??c t??m c???a c??y
	// T??m = ?????nh c?? ????? l???ch t??m nh??? nh???t trong c??y
	public Set<Integer> getCentersOfTree(double[][] input) {
		Set<Integer> result = new HashSet<Integer>();

		for (int i = 0; i < input.length; i++) {
			// N???u ????? l???ch t??m c???a 1 ?????nh = ????? l???ch t??m nh??? nh???t trong c??y th?? l?? t??m
			// => ????a v??o danh s??ch
			if (getEccentricity(i, input) == getCentersOfTreeSub(input)) {
				result.add(i);
			}
		}
		return result;
	}

	// L???y ????? l???ch t??m nh??? nh???t trong c??y
	// B??n kinh
	// B??n k??nh = ????? l???ch t??m nh??? nh???t trong c??y
	public double getCentersOfTreeSub(double[][] input) {
		double result = Double.POSITIVE_INFINITY;
//			t??m ????? l???ch nh??? nh???t
		int min = 0;
		for (int i = 0; i < input.length; i++) {
			// ????? l???ch t??m c???a t???ng ?????nh
			min = getEccentricity(i, input);
			// L???y ra ????? l???ch t??m nh??? nh???t trong c??y
			if (min < result) {
				result = min;
			}
		}
		return result;
	}

	public int numberOfVertex(double[][] input) {
		return input.length;
	}

	public boolean checkHasCycle(double[][] input) {
		if (getDegree2Vertex(input) == input.length || getMoreDegree2Vertex(input) > 0) {
			return true;
		}
		return false;

	}

	public int getDegree2Vertex(double[][] input) {
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			if (degree(i, input) == 2) {
				result++;
			}
		}
		return result;
	}

	public int getMoreDegree2Vertex(double[][] input) {
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			if (degree(i, input) > 2) {
				result++;

			}
		}
		return result;
	}

	public UndirectedGraph DFS_Tree(int start) {

		Stack<Integer> stack = new Stack<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		stack.push(v);
//		System.out.print(start);
		UndirectedGraph T = new UndirectedGraph(getLength());
		while (!stack.empty()) {
			v = stack.peek();
			int j = -1;
			for (int k = 0; k < this.getLength(); k++) {
				if (adjmatrix[v][k] != Double.POSITIVE_INFINITY && !visited.contains(k)
						&& checkCircle(v, j, T.adjmatrix) == false) {
					j = k;
					T.addEdge(v, j);
					System.out.println("(" + v + ", " + j + ")");
//					break;
				}
			}
			if (j >= 0) {
				visited.add(j);
//				System.out.print(j);
//				System.out.print("=>" + j);
				v = j;
//				T.addEdge(v, j);
				stack.push(v);

			} else if (!stack.empty())
				stack.pop();
		}
		return T;
	}

	public UndirectedGraph BFS_Tree(int start) {

		Queue<Integer> queue = new LinkedList<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		queue.add(v);
//		System.out.print(start);
		UndirectedGraph T = new UndirectedGraph(getLength());
		while (!queue.isEmpty()) {
			v = queue.peek();
			int j = -1;
			for (int k = 0; k < this.getLength(); k++) {
				if (adjmatrix[v][k] != Double.POSITIVE_INFINITY && !visited.contains(k)
						&& checkCircle(v, j, T.adjmatrix) == false) {
					j = k;
					T.addEdge(v, j);
					System.out.println("(" + v + ", " + j + ")");
//					break;
				}
			}
			if (j >= 0) {
				visited.add(j);
//				System.out.print(j);
//				System.out.print("=>" + j);
				v = j;
//				T.addEdge(v, j);
				queue.add(v);

			} else if (!queue.isEmpty())
				queue.poll();
		}
		return T;
	}

	public void floyd(WeightGraph w) {
		int n = numberOfVertex(w.adjmatrix);
		System.out.println(n);
		int[][] P0, P1;
		double[][] w0, w1;
//		w0 = new double[n][n];
		w1 = new double[n][n];
		P0 = new int[n][n];
//		w0 = w.adjmatrix.clone();
//		w0 = w.getAdjmatrix().clone();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (w.adjmatrix[i][j] != Double.POSITIVE_INFINITY) {
					P0[i][j] = j;
				} else {

					P0[i][j] = -1;
				}
			}
		}
		for (int k = 0; k < n; k++) {
			w1 = new double[n][n];
			P1 = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (w.getAdjmatrix()[i][j] > w.getAdjmatrix()[i][k] + w.getAdjmatrix()[k][j]) {
						w1[i][j] = w.getAdjmatrix()[i][k] + w.getAdjmatrix()[k][j];
//						P1[i][j] = P0[i][k];
						P1[i][j] = k;
					} else {
						w1[i][j] = w.getAdjmatrix()[i][j];
//						P1[i][j] = P0[i][j];
						P1[i][j] = j;
					}
				}
//				if (w0[i][j] > w0[i][k] + w0[k][j]) {
//					w1[i][j] = w0[i][k] + w0[k][j];
//					P1[i][j] = P0[i][k];
//				} else {
//					w1[i][j] = w0[i][j];
//					P1[i][j] = P0[i][j];
//				}
//			}
				w.adjmatrix = w1;
				P0 = P1;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(w1[i][j] + " ");
//					System.out.print(P1[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
