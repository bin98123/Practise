package week8_prim_and_kruskal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class UndirectedGraph {

	public int[][] adjmatrix;

	public UndirectedGraph(int n) {
		adjmatrix = new int[n][n];

	}

// size
	public int getLength() {
		return adjmatrix.length;
	}

///////////////////////////////////////////////////////
// In ma trận
	public String printMatrix() {
		String result = "";
		for (int i = 0; i < adjmatrix.length; i++) {
			for (int j = 0; j < adjmatrix.length; j++) {
				if (j != adjmatrix.length - 1) {
					result += adjmatrix[i][j] + " ";
				} else if (j == adjmatrix.length - 1) {
					result += adjmatrix[i][j] + "\n";
				}
			}
		}

		return result;

	}

// In danh sách đỉnh cô lập
	public List<Integer> printIsolationVertex() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < adjmatrix.length; i++) {
			int count = 0;
			for (int j = 0; j < adjmatrix.length; j++) {
				if (adjmatrix[i][j] == 1) {
					count++;
				}
			}
			if (count == 0) {
				result.add(i);
			}
		}

		return result;

	}

// In số đỉnh cô lập
	public int printNumberIsolationVertex() {
		int result = printIsolationVertex().size();
		return result;

	}

	//////////////////////////////////////////////
	// a. Thêm/ xóa cạnh

	// thêm cạnh
	public void addEdge(int u, int v) {
		adjmatrix[u][v]++;
		adjmatrix[v][u]++;
	}

// xóa cạnh
	public void removeEdge(int u, int v) {
		adjmatrix[u][v]--;
		adjmatrix[v][u]--;
	}
	//////////////////////////////////////////////
	// b. Tính bậc/ nửa bậc của 1 đỉnh

// bậc của đỉnh
	public int degree(int v) {
		int i = 0;
		for (int j = 0; j < adjmatrix.length; j++) {
			i = i + adjmatrix[v][j];
		}
		return i;
	}
	//////////////////////////////////////////////
	// c. Tính số cạnh của đồ thị

// số cạnh của matrix
	public int numberOfEdge() {
		int i = 0;
		for (int j = 0; j < adjmatrix.length; j++) {
			i += degree(j);
		}
		i = i / 2;
		return i;
	}

	//////////////////////////////////////////////
	// d. Duyệt đồ thị theo chiều sâu/ rộng/ In mỗi đỉnh khi đến thăm
	// DFS
	public void DFS(int start) {

		Stack<Integer> stack = new Stack<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		stack.push(v);
		System.out.print(start);
//		UndirectedGraph T = new UndirectedGraph(getLength());
		while (!stack.empty()) {
			v = stack.peek();
			int j = -1;
			for (int k = 0; k < this.getLength(); k++) {
				if (adjmatrix[v][k] > 0 && !visited.contains(k)) {
					j = k;
					break;
				}
			}
			if (j >= 0) {
				visited.add(j);
//				System.out.print(j);
				System.out.print("=>" + j);
				v = j;
				stack.push(v);

			} else if (!stack.empty())
				stack.pop();
		}
	}

	// Duyệt cây khung nhỏ nhất DFS
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
				if (adjmatrix[v][k] > 0 && !visited.contains(k) && checkCircle(v, j) == false) {
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

	// Duyệt cây khung nhỏ nhất BFS
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
				if (adjmatrix[v][k] > 0 && !visited.contains(k) && checkCircle(v, j) == false) {
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

	// Kiểm tra có chu trình con hay không?
	public boolean checkCircle(int begin, int end) {
		// Nếu có đường đi giữa 2 đỉnh của cạnh đc thêm thì thêm cạnh đó vào
		// sẽ trở thành 1 chu trình
		if (checkPathOfTwoVertex(begin, end) == true) {
			return true;
		} else if (checkPathOfTwoVertex(begin, end) == false) {
			return false;
		}
		return false;
	}

	// DFS
	public void DFS0(int start) {

		Stack<Integer> stack = new Stack<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		stack.push(v);
		System.out.print(start);
		while (!stack.empty()) {
			v = stack.peek();
			int j = -1;
			for (int k = 0; k < this.getLength(); k++) {
//				if (adjmatrix[v][k] > 0) {
				if (adjmatrix[v][k] > 0 && !visited.contains(k)) {
					j = k;
					adjmatrix[v][k] = adjmatrix[k][v] = 0;
					break;
				}
			}
			if (j >= 0) {
				visited.add(j);
//				System.out.print(j);
				System.out.print("=>" + j);
				v = j;
				stack.push(v);

			} else if (!stack.empty())

				stack.pop();
//				break;
		}
	}

	// BFS
	public void BFS(int start) {

		Queue<Integer> queue = new LinkedList<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		queue.add(v);
		System.out.print(start);
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
				System.out.print("=>" + j);
				v = j;
				queue.add(v);

			} else if (!queue.isEmpty())
				queue.poll();
		}
	}

	// e. Kiểm tra sự liên thông của đồ thị (áp dụng duyệt đồ thị)

	// kiểm tra đồ thị liên thông hay không, nếu trong danh sách có phần tử đỉnh của
	// đồ thị thì suy ra đồ thị có liên thông
	public boolean checkConnected() {
		for (int i = 1; i < adjmatrix.length; i++) {

			if (!checkPathOfTwoVertex(0, i)) {
				return false;

			}
		}
		return true;
	}

	//////////////////////////////////////////////////
	// f. Kiểm tra có đường đi giữa 2 đỉnh cho trước
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

	//////////////////////////////////
	// g. Lấy ra đường đi giữa 2 đỉnh (nếu có)
	public void printPathOfTwoVertex(int start, int end) {
		if (checkPathOfTwoVertex(start, end)) {
			System.out.print("Đường đi giữa " + start + " và " + end + ": ");
			Stack<Integer> queue = new Stack<Integer>();
			int v = start;
			List<Integer> visited = new ArrayList<Integer>();
			visited.add(v);
			queue.add(v);
			System.out.print(start);
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
					System.out.print("=>" + j);
					v = j;
					queue.add(v);
					if (visited.contains(end)) {
						break;
					}

				} else if (!queue.isEmpty())
					queue.pop();
			}
		} else if (!checkPathOfTwoVertex(start, end)) {
			System.out.println("Không có đường đi giữa " + start + " và " + end);
		}
	}

	//////////////////////////////////
	// h. Kiểm tra đồ thị có lưỡng phân hay không
// Lý thuyết: 2 đỉnh bất kỳ kề nhau thì khác màu => các đỉnh cùng màu thì ko đc kề nhau
// Xét lưỡng phân hay không, duyệt đồ thị chọn mark là đỉnh đc tô màu
	public boolean bipartiteGraph() {

		boolean result = true;

		// i: phần tử thứ i của list
		for (int mark = 0; mark < adjmatrix.length; mark++) {
			// Xét hết các đỉnh trong đồ thị để lọc ra danh sách những đỉnh kề với nó
			ArrayList<Integer> list = listVertexSameColor(mark);

			for (int i = 0; i < list.size(); i++) {
				// k: phần tử thứ k của list
				for (int k = 0; k < list.size(); k++) {
					// giá trị của phần tử các đỉnh ko đc tô màu
					// nếu các đỉnh đang cùng màu mà kề nhau thì loại
					if (adjmatrix[(int) list.get(i)][(int) list.get(k)] == 1) {
						result = false;
						break;
					}
				}
			}
		}

		return result;

	}

	// Danh sách các đỉnh kề với đỉnh đc tô màu (các đỉnh trong list sẽ cùng chung
	// màu với nhau)
	public ArrayList<Integer> listVertexSameColor(int mark) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < adjmatrix.length; j++) {
			if (adjmatrix[mark][j] == 1) {
				list.add(j);
			}
		}

		return list;

	}

	// Chúng ta làm việc với chu trình trước nhé các bạn
	public boolean checkHamiltonCycle() {
		// Dựa vào định lý dirac nè các bạn
		// Dirac (1952) Xét G là đơn đồ thị vô hướng với n đỉnh (n ≥ 3). Nếu d(x) ≥ n/2
		// với mọi đỉnh x của G thì G là đồ thị Hamilton.
		int top = topNum();
		if (top < 3)
			return false;
		for (int i = 0; i < adjmatrix.length; i++) {
			int sum = topDegree(i);
			if (sum < (top / 2))
				return false;
		}
		return true;
	}

	// Tìm chu trình
	// như mọi lần mình cần mãng visited để dánh dấu các đỉnh đã thăm
	boolean visited[];
	// hc là mãng chứa chu trình tìm được
	int[] hc;

	public void hamiltonianCycle(int index) {
		// Bước khởi tạo
		visited = new boolean[topNum()];
		hc = new int[topNum()];

		// Đánh dấu vị trí đỉnh index được viếng thăm
		for (int j = 0; j < this.adjmatrix.length; j++) {
			visited[j] = false;
			hc[index] = 0;
			visited[index] = true;
		}
		// Phương thức đệ quy để duyệt chu trình nếu có
		Expand(1);

	}

	private void Expand(int i) {
		for (int j = 0; j < topNum(); j++)
			if (!visited[j] && this.adjmatrix[hc[i - 1]][j] > 0) {
				hc[i] = j;
				if (i < topNum() - 1) {
					visited[j] = true;
					Expand(i + 1);
					visited[j] = false;
				} else if (this.adjmatrix[hc[i]][0] > 0) {
					printHamiltonCycle(hc);
				}
			}
	}

	// Phương thức in ra chu trình
	private void printHamiltonCycle(int[] arr) {
		String string = "";
		String temp = " ==> ";
		for (int k = 0; k < arr.length; k++) {
			string += arr[k];
			if (k < arr.length - 1) {
				string += temp;
			}
		}
		System.out.println(string + temp + arr[0]);
	}

	// Đây là phần tìm đường đi hamilton ==> đây là thuật toán mình tham khảo từ một
	// trang online
	List<Integer> listVisitHamiltonian = new ArrayList<>();

	public boolean check_using_dfs() {
		int count = 0;
		String label[] = new String[topNum()];
		int n = topNum();
		for (int i = 0; i < n; i++)
			label[i] = "NOT_IN_STACK";
		for (int i = 0; i < n; i++) {
			label[i] = "IN_STACK";
			if (dfs(i, label, 1)) {
				listVisitHamiltonian.add(i);
				for (int k = listVisitHamiltonian.size() - 1; k >= 0; k--)
					System.out.print(listVisitHamiltonian.get(k) + " \t ");
				System.out.println();
				listVisitHamiltonian.removeAll(listVisitHamiltonian);
				for (int j = 0; j < n; j++)
					label[j] = "NOT_IN_STACK";
				count++;
			}
			label[i] = "NOT_IN_STACK";
		}
		return (count > 0) ? true : false;
	}

	public boolean dfs(int v, String label[], int instack_count) {
		int n = topNum();
		if (instack_count == n)
			return true;
		for (int i = 0; i < n; i++)
			if (this.adjmatrix[v][i] > 0 && label[i].equals("NOT_IN_STACK")) {
				label[i] = "IN_STACK";
				if (dfs(i, label, instack_count + 1)) {
					listVisitHamiltonian.add(i);
					return true;
				}
				label[i] = "NOT_IN_STACK";
			}
		return false;
	}

	// bậc của đỉnh
	public int topDegree(int v) {
		int i = 0;
		for (int j = 0; j < adjmatrix.length; j++) {
			i = i + adjmatrix[v][j];
		}
		return i;
	}

	private int topNum() {
		// TODO Auto-generated method stub
		return getLength();
	}

	///
//	Kiểm tra đồ thị có phải là cây hay ko
	public boolean checkTree() {
		// Nếu đồ thị là cây thì: Đồ thị liên thông và có số cạnh = (tổng số đỉnh -1)
		if (checkConnected() && numberOfEdge() == adjmatrix.length - 1) {
			return true;
		}
		return false;
	}

// Tính độ lệch tâm của 1 đỉnh trong cây
	// độ lệch tâm của 1 đỉnh = max(khoảng cách từ đỉnh đó đến các đỉnh còn lại)
	public int getEccentricity(int vertex) {
		int result = 0;
		for (int i = 0; i < adjmatrix.length; i++) {
			int max = 0;
			if (i != vertex) {
				// Khoảng cách từ đỉnh đc xét đến các đỉnh còn lại
				max = getDistanceOfTwoVertex(vertex, i);

			}
			// lấy khoảng cách lớn nhất từ đỉnh đc xét đến các đỉnh còn lại
			if (result < max) {
				result = max;
			}
		}
		return result;

	}

// Tìm các tâm của cây
	// Tâm = đỉnh có độ lệch tâm nhỏ nhất trong cây
	public Set<Integer> getCentersOfTree() {
		Set<Integer> result = new HashSet<Integer>();

		for (int i = 0; i < adjmatrix.length; i++) {
			// Nếu độ lệch tâm của 1 đỉnh = độ lệch tâm nhỏ nhất trong cây thì là tâm
			// => đưa vào danh sách
			if (getEccentricity(i) == getCentersOfTreeSub()) {
				result.add(i);
			}
		}
		return result;
	}

// Lấy độ lệch tâm nhỏ nhất trong cây
	// Bán kinh
	// Bán kính = độ lệch tâm nhỏ nhất trong cây
	public int getCentersOfTreeSub() {
		int result = Integer.MAX_VALUE;
//		tìm độ lệch nhỏ nhất
		int min = 0;
		for (int i = 0; i < adjmatrix.length; i++) {
			// độ lệch tâm của từng đỉnh
			min = getEccentricity(i);
			// Lấy ra độ lệch tâm nhỏ nhất trong cây
			if (min < result) {
				result = min;
			}
		}
		return result;
	}

// Khoảng cách từ 1 đỉnh đến 1 đỉnh
	public int getDistanceOfTwoVertex(int start, int end) {
//		Stack<Integer> result = new Stack<Integer>();
		int result = 0;
		if (checkPathOfTwoVertex(start, end)) {
//			System.out.print("Đường đi giữa " + start + " và " + end + ": ");
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
					if (adjmatrix[v][k] > 0 && !visited.contains(k)) {
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
//			System.out.println("Không có đường đi giữa " + start + " và " + end);
		}
		return result;
	}

	public boolean checkCircle() {
		int count = 0;
		for (int i = 0; i < adjmatrix.length; i++) {
			if (degree(i) >= 2) {
				count++;
			}
			if (count == adjmatrix.length) {
				return true;
//				break;
			}
			if (count == adjmatrix.length) {
				return true;
//				break;
			}
		}
		return false;
	}

}
