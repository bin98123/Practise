package week8_prim_and_kruskal;

public class Edge implements Comparable<Edge> {
	int begin, end;
	double weight;

	public Edge(int begin, int end, double weight) {
		super();
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.weight < o.weight) {
			return -1;
		} else if (this.weight > o.weight) {
			return 1;
		} else {
			return 0;
		}
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [begin=" + begin + ", end=" + end + ", weight=" + weight + "]";
	}

}
