package week8_prim_and_kruskal;

public class Test {
	public static void main(String[] args) {
		UndirectedGraph graph = new UndirectedGraph(7);

//		// Đường đi Hamilton
//		graph.addEdge(0, 4);
//		graph.addEdge(0, 5);
//		graph.addEdge(4, 5);
//
//		graph.addEdge(0, 1);
//
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(2, 3);

		// tree
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);

		graph.addEdge(3, 1);
		graph.addEdge(4, 1);

		graph.addEdge(4, 5);
		graph.addEdge(4, 6);

		// Chu trình Hamilton
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 4);
//		
//		graph.addEdge(2, 3);
//		
//		graph.addEdge(4, 3);

		// Chu trình Hamilton
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 7);
//		graph.addEdge(0, 8);
//
//		graph.addEdge(1, 8);
//		graph.addEdge(1, 2);
//
//		graph.addEdge(2, 8);
//		graph.addEdge(2, 3);
//
//		graph.addEdge(3, 8);
//		graph.addEdge(3, 4);
//
//		graph.addEdge(8, 4);
//		graph.addEdge(5, 4);
//
//		graph.addEdge(5, 8);
//		graph.addEdge(5, 6);
//
//		graph.addEdge(7, 6);
//		graph.addEdge(8, 6);
//
//		graph.addEdge(7, 8);

		System.out.println("-----------------------------------*^-_-^-_-^*-----------------------------------");

		// xóa cạnh
//		graph.removeEdge(0, 1);
		// tính bậc của đỉnh
		for (int i = 0; i < graph.getLength(); i++) {
			System.out.println("Bậc của đỉnh " + i + ": " + graph.degree(i));
		}

		System.out.println("-----------------------------------*^-_-^-_-^*-----------------------------------");
		// tính số cạnh
		System.out.println("Cạnh của ma trận: " + graph.numberOfEdge());

		System.out.println("-----------------------------------*^-_-^-_-^*-----------------------------------");
		// in ma trận
		System.out.print("In ma trận:\n" + graph.printMatrix());
		// kiểm tra đồ thị lưỡng phân
//		System.out.println(adjmatrix[0][3]);
//		graph.bipartiteGraphSub(1);
//		System.out.println(graph.bipartiteGraphSub(1));
//		System.out.println(graph.bipartiteGraphCheck(3, 0));
//		System.out.println(graph.bipartiteGraphCheck(3, 1));
//		System.out.println(graph.bipartiteGraphCheck(3, 2));
//		System.out.println(graph.bipartiteGraphCheck(3, 3));
//		System.out.println();
//		System.out.println(graph.bipartiteGraphCheck(1, 0));
//		System.out.println(graph.bipartiteGraphCheck(1, 1));
//		System.out.println(graph.bipartiteGraphCheck(1, 2));
//		System.out.println(graph.bipartiteGraphCheck(1, 3));
//		System.out.println();
//		System.out.println(graph.bipartiteGraphCheck(0, 0));
//		System.out.println(graph.bipartiteGraphCheck(0, 1));
//		System.out.println(graph.bipartiteGraphCheck(0, 2));
//		System.out.println(graph.bipartiteGraphCheck(0, 3));
//		System.out.println();
		System.out.println("-----------------------------------*^-_-^-_-^*-----------------------------------");
		System.out.println("Đồ thị có lưỡng phân hay ko: " + graph.bipartiteGraph());
//		System.out.println(graph.bipartiteGraph(1));
//		System.out.println(graph.bipartiteGraph(2));
//		System.out.println(graph.bipartiteGraph(3));
//		ArrayList list1 = new ArrayList<Integer>();
//		ArrayList list2 = new ArrayList<Integer>();
//		list1.add(1);
//		list1.add(2);
//		list1.add(3);
//		list1.add(4);
//
//		list2.add(6);
//		list2.add(1);
//		System.out.println(list1.contains(4));
//		System.out.println("khanh");
//		File f = new File("src//week3//Test.java");
//		System.out.println(f.getAbsolutePath());
		System.out.println();
		for (int i = 0; i < graph.getLength(); i++) {

			System.out.println("Đỉnh liên kết với " + i + " là: " + graph.listVertexSameColor(i));
		}
		System.out.println();
//		System.out.println("-----------------------");
		// kiểm tra đồ thị liên thông, kiểm tra số đỉnh trước khi check
		System.out.println("đồ thị có liên thông không: " + graph.checkConnected());
		System.out.println();
		System.out.println("DFS:");
		graph.DFS(0);
		System.out.println();
		System.out.println("BFS:");
		graph.BFS(0);
		System.out.println();
		System.out.println("DFS FOR TREE: ");
		System.out.println(graph.DFS_Tree(0));
		int start = 0;
		int end = graph.getLength() - 1;
//		int end = 0;
		System.out.println("Check path from " + start + " to " + end + ": " + graph.checkPathOfTwoVertex(start, end));
		System.out.print("Print path from " + start + " to " + end + ": ");
		graph.printPathOfTwoVertex(start, end);
		System.out.println();
//		System.out.println("Chu trình Euler: " + graph.checkEuler());
//		System.out.println();
//		System.out.println("Đường đi Euler: " + graph.checkHalfEuler());
//		System.out.println();
//		System.out.println(graph.checkEulerOrHalfEuler());
		System.out.println();
		System.out.println("Nhớ kiểm tra số thành phần đỉnh, không được có đỉnh cô lập");
		System.out.println("Số đỉnh cô lập là: " + graph.printNumberIsolationVertex());
		System.out.println("Danh sách các đỉnh cô lập là: " + graph.printIsolationVertex());
//		System.out.println("Chu trình Euler: ");
//		graph.eulerCycle1(0);
//		System.out.println(graph.printMatrix());
//		graph.eulerCycle1(0);
//		System.out.println((graph.changeEuler(graph.listVertexEuler(0, graph.adjmatrix))));
//		System.out.println((graph.changeEuler(graph.listVertexEulerSub(0, graph.adjmatrix))));
//		System.out.println((graph.changeEuler(graph.listVertexEuler(0))));
//		System.out.println(graph.printMatrix());
//		System.out.println(graph.listVertexEuler(0, graph.adjmatrix));
//		System.out.println("dsds" + graph.getListIsolation(graph.listVertexEuler(0, graph.adjmatrix)));
//		System.out.println(graph.listVertexEuler(0, graph.adjmatrix));
//		System.out.println(graph.listVertexEuler(2, graph.adjmatrix));
//		System.out.println(graph.printMatrix());
//		System.out.println(graph.listVertexEulerSub(0, graph.adjmatrix));
//		System.out.println(graph.listVertexEulerSub(0, graph.adjmatrix));
//		System.out.println(
//				"1*************************************************************************************************");
//		for (int temp : graph.getListVertexToCheckEuler()) {
//			int count = graph.getTimesEuler(temp);
////			if (graph.checkNullMatrix(temp, graph.listVertexEulerSub(temp, graph.adjmatrix))) {
////				for (int i = 0; i < graph.getLength(); i++) {
////
////					System.out.println("test có đỉnh cô lập chưa?: "
////							+ graph.checkNullMatrix(temp, graph.listVertexEulerSub(temp, graph.adjmatrix)));
////				}
////			}
//			while (count != 0) {
//				count--;
//				System.out.println(graph.listVertexEulerSub(temp, graph.adjmatrix));
//				System.out.println(temp + ": " + graph.getTimesEuler(temp));
//			}
//			System.out.println(
//					"*************************************************************************************************");
//		}
//		System.out.println(graph.printMatrix());
//		System.out.println(graph.getListVertexToCheckEuler().size());
//		System.out.println("dsd" + graph.getListEuler(0).get(0));
//		graph.eulerCycle();
		System.out.println();
//		System.out.println("Danh sách các đỉnh bậc lẻ trong đồ thị: " + graph.listVertexOddForPathEuler());
//		graph.eulerPath();
		System.out.println("Đường đi Hamilton: ");
		graph.hamiltonianCycle(3);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("----------Tuần 8:------------------");
		System.out.println("1. Đồ thị trên có phải là cây không?: " + graph.checkTree());
		System.out.println();
		int first = 0;
		for (int i = 0; i < graph.getLength(); i++) {
			if (i != 0) {
				System.out.println(
						"Khoảng cách từ " + first + " đến " + i + " : " + graph.getDistanceOfTwoVertex(first, i));
			}
		}
		for (int i = 0; i < graph.getLength(); i++) {
			System.out.println("2. Độ lệch tâm của đỉnh " + i + " là: " + graph.getEccentricity(i));
		}
		System.out.println("3. Danh sách các tâm của cây: " + graph.getCentersOfTree() + " có bán kính là: "
				+ graph.getCentersOfTreeSub());
		System.out.println("4. Bán kính của cây: " + graph.getCentersOfTreeSub());
//		System.out.print("In đường đi Euler hay nửa Euler: ");
//		graph.printHalfEulerOrEuler();
//		System.out.println(graph.getListEuler(graph.getListVertexToCheckEuler()));
//		System.out.println(graph.listVertexEuler(2, graph.adjmatrix));

//		System.out.println(graph.printMatrix());
//		System.out.println("Chu trình Euler: " + graph.checkEuler());
//		System.out.println(graph.listVertexEuler(0, graph.adjmatrix));
//		System.out.println(graph.printMatrix());
//		System.out.println("Chu trình Euler: " + graph.checkEuler());
//		System.out.println(graph.listVertexEuler(2, graph.adjmatrix));
//		System.out.println(graph.printMatrix());
//		System.out.println("Chu trình Euler: " + graph.checkEuler());
//		System.out.println(((int) (graph.degree(1) % 2)));
//		System.out.println(((int) (graph.degree(2) % 2)));

		// Đồ thị duyệt Kruskal

		// VD Đồ thị trong slide duyệt khung cây Kruskal

		WeightGraph wGraph = new WeightGraph(9);
		wGraph.addEdge(0, 1, 8);
		wGraph.addEdge(0, 5, 3);

		wGraph.addEdge(1, 2, 9);
		wGraph.addEdge(1, 5, 7);
		wGraph.addEdge(1, 4, 12);

		wGraph.addEdge(2, 4, 18);
		wGraph.addEdge(2, 3, 4);

		wGraph.addEdge(3, 4, 6);

		wGraph.addEdge(4, 6, 5);

		wGraph.addEdge(5, 6, 10);

		wGraph.addEdge(6, 8, 1);
		wGraph.addEdge(6, 7, 11);

		// Cây

//		WeightGraph wGraph = new WeightGraph(7);
//		wGraph.addEdge(0, 1, 4);
//		wGraph.addEdge(0, 2, 5);
//		wGraph.addEdge(1, 2, 5);
//
//		wGraph.addEdge(3, 1, 3);
//		wGraph.addEdge(4, 1, 2);
//
//		wGraph.addEdge(4, 5, 6);
//		wGraph.addEdge(4, 6, 1);

//		System.out.println("6. Tìm cây khung: \n");
//		wGraph.BFS(0, wGraph);
//		System.out.println(wGraph.BFS(0, wGraph).printMatrix());
		System.out.println("TLQK-------------");
		System.out.println("Đồ thị có liên thông hay không? " + wGraph.checkConnected(wGraph.getAdjmatrix()));
		System.out.println("Số đỉnh: " + wGraph.numberOfVertex(wGraph.getAdjmatrix()));
		System.out.println("Số cạnh: " + wGraph.numberOfEdge(wGraph.getAdjmatrix()));
		System.out.println("Tree: Đồ thị liên thông có số cạnh = (số đỉnh - 1)");
		System.out.println("1. Đồ thị trên có phải là cây không?: " + wGraph.checkTree(wGraph.getAdjmatrix()));
		System.out.println();
		System.out.println("Có phải cây hay không? " + graph.checkTree());
		System.out.println("Duyệt đồ thị theo chiều rộng ");
		graph.BFS(0);
		System.out.println();
		int first0 = 0;
		for (int i = 0; i < wGraph.getLength(); i++) {
			if (i != 0) {
				System.out.println("Khoảng cách từ " + first0 + " đến " + i + " : "
						+ wGraph.getDistanceOfTwoVertex(first, i, wGraph.getAdjmatrix()));
			}
		}
		for (int i = 0; i < graph.getLength(); i++) {
			System.out.println(
					"2. Độ lệch tâm của đỉnh " + i + " là: " + wGraph.getEccentricity(i, wGraph.getAdjmatrix()));
		}
		System.out.println("3. Danh sách các tâm của cây: " + wGraph.getCentersOfTree(wGraph.getAdjmatrix())
				+ " có bán kính là: " + graph.getCentersOfTreeSub());
		System.out.println("4. Bán kính của cây: " + wGraph.getCentersOfTreeSub(wGraph.getAdjmatrix()));
//		System.out.println("sfsfsfsfsf " + wGraph.checkCircle(0, 1, wGraph.getAdjmatrix()));
		System.out.println("Đồ thị liên thông có trọng số:\n" + wGraph.printMatrix());

//		graph1.addEdge(3, 0);
//		System.out.println("Đồ thị có chu trình không? " + graph1.checkCircle());
//		System.out.println("Danh sách các cạnh \n" + checkEulerWithMatrix.getSortWeightKruskal());
//		System.out.println("Danh sách các cạnh kề với 0 \n"
//				+ checkEulerWithMatrix.listNextToVertex(0, checkEulerWithMatrix.getAdjmatrix()));
//		System.out.println(
//				"Kruskal999: \n" + checkEulerWithMatrix.getKruskal().printMatrix(checkEulerWithMatrix.getAdjmatrix()));
		System.out.println("Số đỉnh của đồ thị: " + wGraph.numberOfVertex(wGraph.getAdjmatrix()));
		System.out.println("**Thứ tự duyệt cạnh cây khung nhỏ nhất Kruskal: ");
		System.out.println("5. Tìm cây khung nhỏ nhất Kruskal: \n" + wGraph.getKruskal().printMatrix());
//		wGraph.DFS(0, wGraph);
		System.out.println();
//		System.out.println("Duyệt cây khung nhỏ nhất BFS: ");
//		System.out.println(graph.BFS_Tree(0).printMatrix());
		System.out.println("Duyệt cây khung nhỏ nhất DFS: ");
		System.out.println(graph.DFS_Tree(0).printMatrix());
//		System.out.println(wGraph.BFS(0, wGraph));
//		System.out.println("5-1. Tìm cây khung nhỏ nhất Prim: \n" + wGraph.getPrim(0).printMatrix());
//		System.out.println("Duyệt khung cây Kruskal: \n");
//		wGraph.getKruskal().DFS(0, wGraph.getKruskal());
//		System.out.println();
		System.out.println("-------------------------------");
		WeightGraph weightGraph = new WeightGraph(8);
		weightGraph.addEdge(0, 1, 8);
		weightGraph.addEdge(1, 2, 8);
		weightGraph.addEdge(2, 3, 8);
		weightGraph.addEdge(3, 4, 4);
		weightGraph.addEdge(4, 5, 4);
//		weightGraph.addEdge(3, 0, 4);
//		weightGraph.addEdge(5, 0, 4);
//		weightGraph.addEdge(0, 7, 4);
		weightGraph.addEdge(6, 5, 4);
		weightGraph.addEdge(6, 7, 4);
//		weightGraph.addEdge(0, 7, 4);
//		weightGraph.removeEdge(3, 0);
//		System.out.println(weightGraph.printMatrix());
		for (int j = 0; j < weightGraph.getLength(); j++) {
			System.out.println("Bậc của " + j + " là: " + weightGraph.degree(j));

		}
		System.out.println("Số cạnh: " + weightGraph.numberOfEdge());
		System.out.println("Số cạnh: " + weightGraph.numberOfEdge(weightGraph.getAdjmatrix()));
//		System.out.println("Đồ thị có chu trình không? " + weightGraph.checkCircle());
		int begin = 1;
		int finish = 0;
		System.out.println("Đồ thị có chu trình khi thêm cạnh (" + begin + ", " + finish + ") vào chu trình hay không? "
				+ weightGraph.checkCircle(begin, finish, weightGraph.getAdjmatrix()));
//		System.out.println("Đồ thị có chu trình hay không? " + weightGraph.checkHasCycle(weightGraph.getAdjmatrix()));
//		System.out.println("Đồ thị có chu trình không? " + weightGraph.checkHasCycle(weightGraph.getAdjmatrix()));
//		System.out.println("Đồ thị có chu trình không? " + weightGraph.checkHasCycle(0, 9, weightGraph.getAdjmatrix()));
//		UndirectedGraph graph1 = new UndirectedGraph(4);
//		graph1.addEdge(0, 1);
		for (int i = 0; i < wGraph.getLength(wGraph); i++) {

			System.out.println("Đỉnh kề với đỉnh " + i + " là: " + wGraph.listNearByVertex(i));
		}
//		System.out.println(wGraph.getSortWeightPrim(6, wGraph.listNearByVertex(6)));
//		graph1.addEdge(1, 2);
//		graph1.addEdge(3, 2);
	}

}
