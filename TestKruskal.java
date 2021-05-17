package week8_prim_and_kruskal;

public class TestKruskal {
	public static void main(String[] args) {

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

//	WeightGraph wGraph = new WeightGraph(7);
//	wGraph.addEdge(0, 1, 4);
//	wGraph.addEdge(0, 2, 5);
//	wGraph.addEdge(1, 2, 5);
//
//	wGraph.addEdge(3, 1, 3);
//	wGraph.addEdge(4, 1, 2);
//
//	wGraph.addEdge(4, 5, 6);
//	wGraph.addEdge(4, 6, 1);

//	System.out.println("6. Tìm cây khung: \n");
//	wGraph.BFS(0, wGraph);
//	System.out.println(wGraph.BFS(0, wGraph).printMatrix());
		System.out.println("TLQK-------------");
		System.out.println("Đồ thị có liên thông hay không? " + wGraph.checkConnected(wGraph.getAdjmatrix()));
		System.out.println("Số đỉnh: " + wGraph.numberOfVertex(wGraph.getAdjmatrix()));
		System.out.println("Số cạnh: " + wGraph.numberOfEdge(wGraph.getAdjmatrix()));
		System.out.println("Tree: Đồ thị liên thông có số cạnh = (số đỉnh - 1)");
		System.out.println("1. Đồ thị trên có phải là cây không?: " + wGraph.checkTree(wGraph.getAdjmatrix()));
		System.out.println();
//		System.out.println("Có phải cây hay không? " + graph.checkTree());
		System.out.println("Duyệt đồ thị theo chiều rộng ");
//		graph.BFS(0);
		System.out.println();
		int first0 = 0;
		for (int i = 0; i < wGraph.getLength(); i++) {
			if (i != 0) {
				System.out.println("Khoảng cách từ " + first0 + " đến " + i + " : "
						+ wGraph.getDistanceOfTwoVertex(first0, i, wGraph.getAdjmatrix()));
			}
		}
		for (int i = 0; i < wGraph.getLength(); i++) {
			System.out.println(
					"2. Độ lệch tâm của đỉnh " + i + " là: " + wGraph.getEccentricity(i, wGraph.getAdjmatrix()));
		}
		System.out.println("3. Danh sách các tâm của cây: " + wGraph.getCentersOfTree(wGraph.getAdjmatrix())
				+ " có bán kính là: " + wGraph.getCentersOfTreeSub(wGraph.getAdjmatrix()));
		System.out.println("4. Bán kính của cây: " + wGraph.getCentersOfTreeSub(wGraph.getAdjmatrix()));
//	System.out.println("sfsfsfsfsf " + wGraph.checkCircle(0, 1, wGraph.getAdjmatrix()));
		System.out.println("Đồ thị liên thông có trọng số:\n" + wGraph.printMatrix());

//	graph1.addEdge(3, 0);
//	System.out.println("Đồ thị có chu trình không? " + graph1.checkCircle());
//	System.out.println("Danh sách các cạnh \n" + checkEulerWithMatrix.getSortWeightKruskal());
//	System.out.println("Danh sách các cạnh kề với 0 \n"
//			+ checkEulerWithMatrix.listNextToVertex(0, checkEulerWithMatrix.getAdjmatrix()));
//	System.out.println(
//			"Kruskal999: \n" + checkEulerWithMatrix.getKruskal().printMatrix(checkEulerWithMatrix.getAdjmatrix()));
		System.out.println("Số đỉnh của đồ thị: " + wGraph.numberOfVertex(wGraph.getAdjmatrix()));

		System.out.println("**Thứ tự duyệt cạnh cây khung nhỏ nhất Prim: ");
		System.out.println("5. Tìm cây khung nhỏ nhất Prim: \n" + wGraph.getPrim(0).printMatrix());
		System.out.println("**Thứ tự duyệt cạnh cây khung nhỏ nhất Kruskal: ");
		System.out.println("5. Tìm cây khung nhỏ nhất Kruskal: \n" + wGraph.getKruskal().printMatrix());
//	wGraph.DFS(0, wGraph);
		System.out.println();
		System.out.println("Thứ tự duyệt khung cây nhỏ nhất DFS");
		System.out.println(wGraph.DFS_Tree(0).printMatrix());
		System.out.println("Thứ tự duyệt khung cây nhỏ nhất BFS");
		System.out.println(wGraph.BFS_Tree(0).printMatrix());
//	System.out.println(wGraph.BFS(0, wGraph));
//	System.out.println("5-1. Tìm cây khung nhỏ nhất Prim: \n" + wGraph.getPrim(0).printMatrix());
//	System.out.println("Duyệt khung cây Kruskal: \n");
//	wGraph.getKruskal().DFS(0, wGraph.getKruskal());
//	System.out.println();
		System.out.println("-------------------------------");
		WeightGraph weightGraph = new WeightGraph(8);
		weightGraph.addEdge(0, 1, 8);
		weightGraph.addEdge(1, 2, 8);
		weightGraph.addEdge(2, 3, 8);
		weightGraph.addEdge(3, 4, 4);
		weightGraph.addEdge(4, 5, 4);
//	weightGraph.addEdge(3, 0, 4);
//	weightGraph.addEdge(5, 0, 4);
//	weightGraph.addEdge(0, 7, 4);
		weightGraph.addEdge(6, 5, 4);
		weightGraph.addEdge(6, 7, 4);
//	weightGraph.addEdge(0, 7, 4);
//	weightGraph.removeEdge(3, 0);
//	System.out.println(weightGraph.printMatrix());
		for (int j = 0; j < weightGraph.getLength(); j++) {
			System.out.println("Bậc của " + j + " là: " + weightGraph.degree(j));

		}
		System.out.println("Số cạnh: " + weightGraph.numberOfEdge());
		System.out.println("Số cạnh: " + weightGraph.numberOfEdge(weightGraph.getAdjmatrix()));
//	System.out.println("Đồ thị có chu trình không? " + weightGraph.checkCircle());
		int begin = 1;
		int finish = 0;
		System.out.println("Đồ thị có chu trình khi thêm cạnh (" + begin + ", " + finish + ") vào chu trình hay không? "
				+ weightGraph.checkCircle(begin, finish, weightGraph.getAdjmatrix()));
//	System.out.println("Đồ thị có chu trình hay không? " + weightGraph.checkHasCycle(weightGraph.getAdjmatrix()));
//	System.out.println("Đồ thị có chu trình không? " + weightGraph.checkHasCycle(weightGraph.getAdjmatrix()));
//	System.out.println("Đồ thị có chu trình không? " + weightGraph.checkHasCycle(0, 9, weightGraph.getAdjmatrix()));
//	UndirectedGraph graph1 = new UndirectedGraph(4);
//	graph1.addEdge(0, 1);
		for (int i = 0; i < wGraph.getLength(wGraph); i++) {

			System.out.println("Đỉnh kề với đỉnh " + i + " là: " + wGraph.listNearByVertex(i));
		}
		System.out.println(wGraph.getEdgeWeightPrim(0));
		WeightGraph floyd = new WeightGraph(6);
		floyd.addEdgeDirected(0, 4, 1);
		floyd.addEdgeDirected(1, 3, 3);
		floyd.addEdgeDirected(1, 0, 1);
		floyd.addEdgeDirected(2, 3, 1);
		floyd.addEdgeDirected(2, 1, 2);
		floyd.addEdgeDirected(3, 4, 3);
		floyd.addEdgeDirected(4, 1, 2);
		floyd.addEdgeDirected(5, 0, 2);
		floyd.addEdgeDirected(5, 2, 1);
		System.out.println(floyd.printMatrix());
		System.out.println("Ma trận sau khi tìm đường đi ngắn nhất: ");
		floyd.floyd(floyd);
//	graph1.addEdge(1, 2);
//	graph1.addEdge(3, 2);
	}

}
