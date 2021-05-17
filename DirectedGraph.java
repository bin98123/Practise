package week8_prim_and_kruskal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DirectedGraph {
	public int[][] adjmatrix;

	public DirectedGraph(int n) {
		adjmatrix = new int[n][n];

	}

	public int getLength() {
		return adjmatrix.length;
	}
	//////////////////////////////////////////////
	// a. Thêm/ xóa cạnh

	// thêm cạnh
	public void addEdge(int u, int v) {
		adjmatrix[u][v]++;
	}

	// xóa cạnh
	public void removeEdge(int u, int v) {
		adjmatrix[u][v]--;
	}
	//////////////////////////////////////////////
	// b. Tính bậc/ nửa bậc của 1 đỉnh

	// nửa bậc trong của đỉnh
	public int inDegree(int v) {
		int i = 0;
		for (int j = 0; j < adjmatrix.length; j++) {
			i = i + adjmatrix[j][v];
		}
		return i;
	}

	// nửa bậc ngoài của đỉnh
	public int outDegree(int v) {
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
			i += outDegree(j);
		}
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
	public String checkStrongOrWeakConnected() {
		String result = "Đồ thị không liên thông";
		if (checkConnected() == true && checkStrongConnected() == true) {
			result = "Đồ thị liên thông mạnh";

		} else if (checkConnected() == true && checkStrongConnected() == false) {
			result = "Đồ thị liên thông yếu";
		}
		return result;

	}

	// liên thông mạnh: có đường đi từ x đến y và ngược lại nhưng ko nhất thiết phải
	// đi hết toàn bộ các cạnh nên ko thể là chu trình Euler
	public boolean checkStrongConnected() {
		for (int i = 0; i < adjmatrix.length; i++) {
			for (int j = 0; j < adjmatrix.length; j++) {

				if (checkPathOfTwoPath(i, j) == false || checkPathOfTwoPath(j, i) == false) {
					return false;

				}
			}
		}
		return true;
	}

	public boolean checkConnected() {
		for (int i = 0; i < adjmatrix.length; i++) {
			for (int j = 0; j < adjmatrix.length; j++) {

				if (checkPathOfTwoPath(i, j) == false && checkPathOfTwoPath(j, i) == false) {
					return false;

				}
			}
		}
		return true;
	}

	//////////////////////////////////////////////////
	// f. Kiểm tra có đường đi giữa 2 đỉnh cho trước
	public boolean checkPathOfTwoPath(int start, int end) {
//		List<Integer> list = listVertexForPathEuler();
		boolean result = false;
		Stack<Integer> queue = new Stack<Integer>();
		int v = start;
		List<Integer> visited = new ArrayList<Integer>();
		visited.add(v);
		queue.add(v);
//		System.out.print(start);
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
//				System.out.print("=>" + j);
				v = j;
				queue.add(v);
				if (visited.contains(end)) {
					result = true;
					break;
				}

			} else if (!queue.isEmpty())
				queue.pop();
		}
		return result;
	}

	//////////////////////////////////
	// g. Lấy ra đường đi giữa 2 đỉnh (nếu có)
	public void printPathOfTwoPath(int start, int end) {
		if (checkPathOfTwoPath(start, end)) {
			System.out.print("Đường đi giữa " + (start + 1) + " và " + (end + 1) + ": ");
			Stack<Integer> stack = new Stack<Integer>();
			int v = start;
			List<Integer> visited = new ArrayList<Integer>();
			visited.add(v);
			stack.add(v);
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
					v = j;
					stack.add(v);
					if (visited.contains(end)) {
						System.out.print(stack.get(0) + 1);
						for (int vertex : stack) {
							if (vertex != stack.get(0)) {
								System.out.print("=>" + (vertex + 1));
							}
						}
						break;
					}
				} else if (!stack.isEmpty())
					stack.pop();
			}
		} else if (!checkPathOfTwoPath(start, end)) {
			System.out.println("Không có đường đi giữa " + (start + 1) + " và " + (end + 1));
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
	////////////////////////////////////////////////////

	// i. Kiểm tra đồ thị có chu trình Euler hoặc nửa Euler hay không?
	public String checkEulerOrHalfEuler() {
		String result = "Đồ thị không có đường đi Euler hoặc chu trình Euler";
		if (checkEuler()) {
			result = "Đồ thị có chu trình Euler";
		} else if (checkHalfEuler()) {
			result = "Đồ thị có đường đi Euler";
		}
		return result;
	}

	// Kiểm tra đồ thị có chu trình Euler hay không?
	public boolean checkEuler() {

		if (checkConnected()) {
			for (int i = 0; i < adjmatrix.length; i++) {
				// nếu đỉnh tại i bậc lẻ thì dừng
				if (inDegree(i) != outDegree(i) && ((listVertexForPathEuler().size()) == 0)) {
					return false;

				}
				if (inDegree(i) == outDegree(i) && ((listVertexForPathEuler().size()) == 0)) {
					return true;
				}
			}
		}
		return false;
	}

	// Kiểm tra đồ thị có nửa Euler hay không?
	public boolean checkHalfEuler() {
		// xét khi chu trình Euler không có
		if (checkConnected()) {
//				int count = 0;
			for (int i = 0; i < adjmatrix.length; i++) {
				// nếu đỉnh tại i bậc lẻ thì dừng
//					if ((degree(i) % 2) != 0) {
//						count++;
//						break;
//					}
//			Nếu tổng các đỉnh bậc lẻ = 2 thì đúng
//					for (int j = 0; j < listVertexOddForPathEuler().size(); j++) {

				if ((listVertexForPathEuler().size()) == 2) {
//						&& ((inDegree(listVertexForPathEuler().get(0)) == outDegree(listVertexForPathEuler().get(1))
//								+ 1)
//								|| (inDegree(listVertexForPathEuler().get(0))
//										+ 1 == outDegree(listVertexForPathEuler().get(1))))) {
					return true;
//			Nếu tổng các đỉnh bậc lẻ khác 2 thì sai
				} else if (listVertexForPathEuler().size() != 2) {
//						&& ((inDegree(listVertexForPathEuler().get(0)) == outDegree(listVertexForPathEuler().get(1))
//								+ 1)
//								|| (inDegree(listVertexForPathEuler().get(0))
//										+ 1 == outDegree(listVertexForPathEuler().get(1))))) {
					return false;
				}
//				}
//				}

			}
		}
		return false;
	}

	// Danh sách đỉnh nửa bậc trong = nửa bậc ngoài (+/-) 1
	public List<Integer> listVertexForPathEuler() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < adjmatrix.length; i++) {
			if ((inDegree(i) == outDegree(i) + 1) || (inDegree(i) + 1 == outDegree(i))) {
				result.add(i);

			}
		}
		return result;
	}

	///////////////////////////////////////////////
	// j. Tìm chu trình Euler hoặc đường đi Euler nếu có
	// Kiểm tra có chu trình Euler hoặc đường đi Euler không?
	public boolean checkHalfEulerOrEuler() {
		if (checkEuler() || checkHalfEuler()) {
			return true;
		}
		return false;

	}

	// In chu trình Euler hoặc đường đi Euler
	public void printHalfEulerOrEuler() {
		if (checkHalfEulerOrEuler()) {
			if (checkEuler()) {
				eulerCycle();
			} else if (checkHalfEuler()) {
				eulerPath();
			}
		}
	}

	// In chu trình Euler
	public void eulerCycle() {
		if (checkEuler()) {
			int start = 0;
			// Đoạn này giống DFS
			Stack stack = new Stack<>();
			stack.push(start);
			ArrayList listVisit = new ArrayList<>();
			while (!stack.empty()) {
				// Lấy đỉnh đầu tiên ra xét
				int current_vertex = (int) stack.peek();
				// Biến này dùng để kiểm tra xem cái đỉnh kế có cạnh đi qua hay không ý
				boolean has_edge = false;
				for (int i = 0; i < topNum(); i++) {
					// DUyệt nó thôi,nếu nó có cạnh thì vào trong if đánh dấu liền
					if (this.adjmatrix[current_vertex][i] != 0) {
						// đánh dấu nó có cạnh liền
						has_edge = true;
						// Đây đây cái này quan trọng nè,đi qua là xóa cạnh nhé,vì vô hướng nên xóa 2
						// chiều,có hướng thì nhớ là một chiều thôi nha.
						this.adjmatrix[current_vertex][i] = this.adjmatrix[i][current_vertex] = 0;
						// Nhớ push vô stack để nó chạy vòng lập nha.
						stack.push(i);
						// Khi đã có thằng có cạnh rồi thì mình dừng cái for đi (theo nguyên tắc cuộc
						// của DFS ý)
						break;
					}
				}
				// Còn đây là trường hợp không có cạnh nè
				if (!has_edge) {
					// Buộc phải lấy đỉnh khác ra test đường đi thôi
					int vertex = (int) stack.pop();
					// Khi lấy ra thì mình add vào list các đỉnh đi qua nhé
					listVisit.add(vertex);
				}
			}
			// Thông thường thì nó sẽ in ra chiều ngược nên các bạn nhớ viết đoạn code

			// để nó in ra theo chiều ngược lại
			// in ra duong di theo chieu nguoc lai
			String string = "";
			String temp = " ==> ";
			for (int k = listVisit.size() - 1; k >= 0; k--) {
				string += listVisit.get(k);
				if (k > 0) {
					string += temp;
				}
			}
			System.out.println(string);
		}
	}

	// In đường đi Euler
	public void eulerPath() {
		if (checkHalfEuler()) {
			List<Integer> list = listVertexForPathEuler();
			int start = -1;
			int listE0 = list.get(0);
			int listE1 = list.get(1);
			if (checkPathOfTwoPath(listE0, listE1)) {
				start = listE0;
			} else if (!checkPathOfTwoPath(listE0, listE1)) {
				start = listE1;
			}
			// Đoạn này giống DFS
			Stack stack = new Stack<>();
			stack.push(start);
			ArrayList listVisit = new ArrayList<>();
			while (!stack.empty()) {
				// Lấy đỉnh đầu tiên ra xét
				int current_vertex = (int) stack.peek();
				// Biến này dùng để kiểm tra xem cái đỉnh kế có cạnh đi qua hay không ý
				boolean has_edge = false;
				for (int i = 0; i < topNum(); i++) {
					// DUyệt nó thôi,nếu nó có cạnh thì vào trong if đánh dấu liền
					if (this.adjmatrix[current_vertex][i] != 0) {
						// đánh dấu nó có cạnh liền
						has_edge = true;
						// Đây đây cái này quan trọng nè,đi qua là xóa cạnh nhé,vì vô hướng nên xóa 2
						// chiều,có hướng thì nhớ là một chiều thôi nha.
						this.adjmatrix[current_vertex][i] = this.adjmatrix[i][current_vertex] = 0;
						// Nhớ push vô stack để nó chạy vòng lập nha.
						stack.push(i);
						// Khi đã có thằng có cạnh rồi thì mình dừng cái for đi (theo nguyên tắc cuộc
						// của DFS ý)
						break;
					}
				}
				// Còn đây là trường hợp không có cạnh nè
				if (!has_edge) {
					// Buộc phải lấy đỉnh khác ra test đường đi thôi
					int vertex = (int) stack.pop();
					// Khi lấy ra thì mình add vào list các đỉnh đi qua nhé
					listVisit.add(vertex);
				}
			}
			// Thông thường thì nó sẽ in ra chiều ngược nên các bạn nhớ viết đoạn code

			// để nó in ra theo chiều ngược lại
			// in ra duong di theo chieu nguoc lai
			String string = "";
			String temp = " ==> ";
			for (int k = listVisit.size() - 1; k >= 0; k--) {
				string += listVisit.get(k);
				if (k > 0) {
					string += temp;
				}
			}
			System.out.println(string);
		}
	}

	private int topNum() {
		// TODO Auto-generated method stub
		return getLength();
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
}
