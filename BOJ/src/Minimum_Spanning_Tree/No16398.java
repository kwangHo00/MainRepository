//No16398_행성연결_두번만에 정답 1) answer 범위가 int를 벗어날 수 있기 때문에 long으로 선언해야 함
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No16398 {
	static class NodeInfo{
		int a, b, c;
		NodeInfo(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	static int getParent(int[] parent, int n) {
		if(parent[n] == n) return parent[n];
		else return parent[n] = getParent(parent, parent[n]);
	}
	
	static void union(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if(aParent < bParent) parent[bParent] = aParent;
		else parent[aParent] = bParent;
	}
	
	static boolean find(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if(aParent == bParent) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] planet = new int[n + 1][n + 1];
		int[] parentNode = new int[n + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				planet[i][j] = Integer.parseInt(st.nextToken());
				if(planet[i][j] != 0) list.add(new NodeInfo(i, j, planet[i][j]));
			}
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		long answer = 0;
		for(NodeInfo i : list) {
			if(find(parentNode, i.a, i.b)) continue;
			union(parentNode, i.a, i.b);
			answer += i.c;
		}
		System.out.println(answer);
	}
}