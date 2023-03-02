package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologicalSort {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;

	static int n;
	static int m;

	static MyList[] edge;
	static int[] inDegree;
	static boolean[] isVisited;

	static String str;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		stk = new StringTokenizer(str);
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		edge = new MyList[n + 1];
		for (int i = 1; i <= n; i++) {
			edge[i] = new MyList();
		}
		inDegree = new int[n + 1];
		isVisited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			edge[a].q.add(b);
			
			inDegree[b]++; // edge가 들어오는 수를 셈
		}		
		
		Queue<Integer> q = new LinkedList<>();		
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		Queue<Integer> ans = new LinkedList<>();
		while (!q.isEmpty()) {
			int curr = q.poll();
			Queue<Integer> currQ = edge[curr].q;
			while (!currQ.isEmpty()) {
				int to = currQ.poll();
				inDegree[to]--;
				if (inDegree[to] == 0) {
					q.add(to);
				}
			}
			ans.add(curr);
		}
		
		while (!ans.isEmpty()) {
			sb.append(ans.poll() + " ");
		}
		System.out.println(sb);
	}
}

class MyList {
	Queue<Integer> q;
	
	MyList(){
		q = new LinkedList<>();
	}
}