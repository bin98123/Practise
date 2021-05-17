package week8_prim_and_kruskal;

//import week7_finish_euler.DirectedGraph;

public class TestDirectedGraph {
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(8);
		// thêm cạnh
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 1);
//		graph.addEdge(2, 1);
//		graph.addEdge(2, 1);
//		graph.addEdge(2, 1);
//		graph.addEdge(2, 1);
//		graph.addEdge(3, 1);
//		graph.addEdge(3, 0);
//		graph.addEdge(0, 3);
//		graph.addEdge(0, 2);
//		graph.addEdge(0, 1);
//		graph.addEdge(1, 0);
//		graph.addEdge(2, 0);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 2);

//		graph.addEdge(0, 1);
//		graph.addEdge(0, 3);
//		graph.addEdge(2, 1);
//		graph.addEdge(2, 3);

		// ---------------------------------------------

//		// lưỡng phân
//
//		graph.addEdge(0, 6);
//		graph.addEdge(0, 3);
//		graph.addEdge(1, 6);
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 5);
//		graph.addEdge(2, 6);
//		graph.addEdge(2, 5);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 2);
//		graph.addEdge(3, 1);
//		graph.addEdge(3, 0);
//		graph.addEdge(3, 4);
//		graph.addEdge(4, 3);
//		graph.addEdge(4, 5);
//		graph.addEdge(4, 6);
//		graph.addEdge(5, 1);
//		graph.addEdge(5, 4);
//		graph.addEdge(6, 0);
//		graph.addEdge(6, 4);

		// -----------------------------------------------------
		// lưỡng phân

//		graph.addEdge(1, 0);
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 3);
		// -----------------------------------------------------
		// ko lưỡng phân

//		graph.addEdge(0, 1);
//		graph.addEdge(1, 2);// bỏ (1,2) thì sẽ lưỡng phân
//		graph.addEdge(2, 0);
//		graph.addEdge(2, 3);
//		graph.addEdge(4, 5);
//		graph.addEdge(4, 6);
//		graph.addEdge(6, 5);
//		

		// ---------------------------------------------
		// ko lưỡng phân

//		graph.addEdge(0, 1);
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 0);
//		graph.addEdge(2, 0);

		// ---------------------------------------------
		// ko lưỡng phân

//		graph.addEdge(0, 1);
//		graph.addEdge(1, 2);// loại (2,1) và (2,3)=> lưỡng phân
//		graph.addEdge(2, 3);// loại (2,3) và (2,1) => lưỡng phân
//		graph.addEdge(2, 4);
//		graph.addEdge(3, 0);
//		graph.addEdge(2, 0);//

		// ---------------------------------------------
		// ko lưỡng phân

//		graph.addEdge(0, 1);
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 3);
//		graph.addEdge(2, 3);

		// ko lưỡng phân

//		graph.addEdge(0, 1);
//		graph.addEdge(0, 5);
//		graph.addEdge(0, 4);
//		graph.addEdge(1, 0);
//		graph.addEdge(1, 2);
//		graph.addEdge(1, 3);
//		graph.addEdge(1, 4);
//		graph.addEdge(1, 5);
//		graph.addEdge(2, 1);
//		graph.addEdge(2, 5);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 2);
//		graph.addEdge(3, 1);
//		graph.addEdge(3, 4);
//		graph.addEdge(4, 3);
//		graph.addEdge(4, 5);
//		graph.addEdge(4, 0);
//		graph.addEdge(4, 1);
//		graph.addEdge(5, 1);
//		graph.addEdge(5, 4);
//		graph.addEdge(5, 0);
//		graph.addEdge(5, 2);
		// liên thông
//
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(3, 2);// ko liên thông
//		graph.addEdge(3, 7);// ko liên thông
//		graph.addEdge(4, 5);
//		graph.addEdge(6, 7);
//		graph.addEdge(3, 6);
//		graph.addEdge(4, 2);// ko liên thông
		// ko liên thông

//		graph.addEdge(0, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(3, 2);
//		graph.addEdge(3, 4);// ko liên thông
//		graph.addEdge(3, 5);
//		graph.addEdge(6, 5);

		// liên thông
//
//		graph.addEdge(0, 8);
//		graph.addEdge(9, 8);
//		graph.addEdge(11, 8);
//		graph.addEdge(9, 10);
//		graph.addEdge(10, 2);
//		graph.addEdge(11, 7);
//		graph.addEdge(7, 3);
//
//		graph.addEdge(6, 4);
////		graph.addEdge(2, 4);// bỏ dòng này sẽ ko liên thông
//		graph.addEdge(6, 5);
//		graph.addEdge(1, 5);

		// liên thông

//		graph.addEdge(0, 8);
//		graph.addEdge(9, 8);
//		graph.addEdge(11, 8);
//		graph.addEdge(9, 10);
//		graph.addEdge(10, 2);
//		graph.addEdge(11, 7);
//		graph.addEdge(7, 3);
//
//		graph.addEdge(6, 4);
//		graph.addEdge(11, 4);// bỏ dòng này sẽ ko liên thông
//		graph.addEdge(6, 5);
//		graph.addEdge(1, 5);
//		graph.addEdge(1, 4);

		// // liên thông
//		
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 5);
//		graph.addEdge(6, 1);
////		graph.addEdge(2, 1);
//		graph.addEdge(2, 7);
//		graph.addEdge(7, 8);
//		graph.addEdge(8, 9);
//		graph.addEdge(8, 10);
//		graph.addEdge(13, 10);
//		graph.addEdge(13, 14);
//		graph.addEdge(15, 14);
//		graph.addEdge(15, 16);
//		graph.addEdge(17, 16);
//		graph.addEdge(17, 18);
//		graph.addEdge(18, 19);
//		graph.addEdge(19, 20);
//		graph.addEdge(20, 21);
//		graph.addEdge(17, 21);
//		
//		graph.addEdge(9, 12);
//		graph.addEdge(19, 12);
//		graph.addEdge(3, 12);
//		graph.addEdge(3, 11);
//		graph.addEdge(4, 3);
//		graph.addEdge(4, 11);
//		graph.addEdge(12, 11);

		// // liên thông
//		
//		graph.addEdge(0, 3);
//		graph.addEdge(0, 5);
//		graph.addEdge(3, 1);
//		graph.addEdge(0, 1);
////		graph.addEdge(7, 1);// xóa dòng này sẽ ko liên thông
//		
//		graph.addEdge(2, 8);
//		graph.addEdge(6, 8);
//		graph.addEdge(7, 8);
//		graph.addEdge(4, 8);

		// liên thông

//		graph.addEdge(0, 1);
//		graph.addEdge(2, 1);
//		graph.addEdge(0, 2);
//		graph.addEdge(3, 2);
//		graph.addEdge(3, 1);

		// liên thông

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);

		graph.addEdge(2, 5);
		graph.addEdge(5, 2);

		graph.addEdge(5, 4);
		graph.addEdge(4, 7);
		graph.addEdge(7, 6);
		graph.addEdge(6, 5);

		System.out.println("-----------------------------------*^-_-^-_-^*-----------------------------------");

		// xóa cạnh
//		graph.removeEdge(0, 1);
		// tính bậc của đỉnh
		for (int i = 0; i < graph.getLength(); i++) {
			System.out.println("Nửa bậc ngoài của đỉnh " + i + ": " + graph.outDegree(i));
			System.out.println("Nửa bậc trong của đỉnh " + i + ": " + graph.inDegree(i));
			System.out.println("---------------------------------");
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
//		for (int i = 0; i < graph.getLength(); i++) {
//
//			System.out.println("các đỉnh liên kết với " + i + " là: " + graph.getListConnected(i));
//		}
//		System.out.println();
//		System.out.println("-----------------------");
		// kiểm tra đồ thị liên thông, kiểm tra số đỉnh trước khi check
		System.out.println("đồ thị có liên thông mạnh hay yếu: " + graph.checkStrongOrWeakConnected());
		System.out.println("đồ thị có liên thông mạnh không: " + graph.checkStrongConnected());
		System.out.println("đồ thị có liên thông không: " + graph.checkConnected());
		System.out.println();
		System.out.println("DFS:");
		graph.DFS(0);
		System.out.println();
		System.out.println("BFS:");
		graph.BFS(0);
		System.out.println();
		int start = 5;
		int end = 2;
//		int start = 0;
//		int end = graph.getLength() - 1;
		System.out.println("Check path from " + start + " to " + end + ": " + graph.checkPathOfTwoPath(start, end));
		System.out.print("Print path from " + start + " to " + end + ": ");
		graph.printPathOfTwoPath(start, end);
		System.out.println();
		System.out.println("Check path from " + 2 + " to " + 5 + ": " + graph.checkPathOfTwoPath(2, 5));
		System.out.print("Print path from " + 2 + " to " + 5 + ": ");
		graph.printPathOfTwoPath(2, 5);
		System.out.println();
		System.out.println("Chu trình Euler: " + graph.checkEuler());
		System.out.println();
		System.out.println("Đường đi Euler: " + graph.checkHalfEuler());
		System.out.println();
		System.out.println(graph.checkEulerOrHalfEuler());
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
		System.out.println("Danh sách các đỉnh bậc trong = đỉnh bậc ngoài (+/-) 1 trong đồ thị: "
				+ graph.listVertexForPathEuler());
//		graph.eulerPath();
		System.out.print("In đường đi Euler hay nửa Euler: ");
		graph.printHalfEulerOrEuler();
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
	}

}
