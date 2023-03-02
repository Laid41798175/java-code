package algorithms;

//Do Not Modify From
import java.io.*;
import java.util.*;

public class TwoSAT {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static StringTokenizer stk;
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int T;
	static int n;
	static int m;
	// Do Nod Modify To

	static Vertex[] X;
	static Vertex[] revX;
	static boolean[] isVisited;

	static Stack<Integer> s = new Stack<>();
	static ArrayList<ArrayList<Integer>> SCClist = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		solve();
		System.out.println(sb);
	}

	public static void solve() throws IOException {
		str = br.readLine();
		stk = new StringTokenizer(str);
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		X = new Vertex[2 * n + 1];
		revX = new Vertex[2 * n + 1];
		for (int i = 1; i <= 2 * n; i++) {
			X[i] = new Vertex();
			revX[i] = new Vertex();
		}

		for (int i = 0; i < m; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			if (a > 0 && b > 0) {
				X[n + a].add(b);
				X[n + b].add(a);

				revX[b].add(n + a);
				revX[a].add(n + b);
			} else if (a > 0 && b < 0) {
				X[n + a].add(n - b);
				X[-b].add(a);

				revX[n - b].add(n + a);
				revX[a].add(-b);
			} else if (a < 0 && b > 0) {
				X[-a].add(b);
				X[n + b].add(n - a);

				revX[b].add(-a);
				revX[n - a].add(n + b);
			} else {
				X[-a].add(n - b);
				X[-b].add(n - a);

				revX[n - b].add(-a);
				revX[n - a].add(-b);
			}
		}

		for (int i = 1; i <= 2 * n; i++) {
			X[i].sort();
			revX[i].sort();
		}

		kosaraju();

		int[] sccNumber = new int[2 * n + 1];
		for (int i = 0; i < SCClist.size(); i++) {
			for (int n : SCClist.get(i)) {
				sccNumber[n] = i;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (sccNumber[i] == sccNumber[n + i]) {
				sb.append(0 + "\n");
				return;
			}
		}
		sb.append(1 + "\n");

		int[] ret = new int[n + 1];
		Arrays.fill(ret, -1);
		Pair[] p = new Pair[2 * n];
		for (int i = 0; i < 2 * n; i++) {
			p[i] = new Pair(i + 1, sccNumber[i + 1]);
		}
		Arrays.sort(p);;

		for (int i = 0; i < 2 * n; i++) {
			int tgt = p[i].x;
			if (tgt > n) {
				if (ret[tgt - n] == -1) {
					ret[tgt - n] = 1;
				}
			} else {
				if (ret[tgt] == -1) {
					ret[tgt] = 0;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			sb.append(ret[i] + " ");
		}
		sb.append('\n');
	}

	public static void kosaraju() {
		isVisited = new boolean[2 * n + 1];
		for (int i = 1; i <= 2 * n; i++) {
			if (!isVisited[i]) {
				dfs(i);
			}
		}

		isVisited = new boolean[2 * n + 1];
		while (!s.isEmpty()) {
			int i = s.pop();
			if (isVisited[i]) {
				continue;
			}
			scc = new ArrayList<>();
			dfsRev(scc, i);
			SCClist.add(scc);
		}
	}

	public static ArrayList<Integer> scc;

	public static void dfs(int curr) {
		isVisited[curr] = true;
		for (int to : X[curr].edges) {
			if (!isVisited[to]) {
				dfs(to);
			}
		}
		s.add(curr);
	}

	public static void dfsRev(ArrayList<Integer> scc, int curr) {
		isVisited[curr] = true;
		scc.add(curr);
		for (int to : revX[curr].edges) {
			if (!isVisited[to]) {
				dfsRev(scc, to);
			}
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int a, int b) {
			x = a;
			y = b;
		}

		public int compareTo(Pair o) {
			return y - o.y;
		}

		public String toString() {
			return x + ": " + y;
		}
	}

	static class Vertex {
		boolean bool;
		ArrayList<Integer> edges;

		Vertex() {
			bool = false;
			edges = new ArrayList<>();
		}

		void add(int i) {
			edges.add(i);
		}

		void sort() {
			edges.sort(null);
		}
	}
}