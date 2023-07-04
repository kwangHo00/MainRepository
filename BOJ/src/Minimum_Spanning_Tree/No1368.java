//No1368_물대기_정답_ 구글링해서 살짝 참고함_우물이라는 가상의 노드 (0)를 추가해주어 우물을 포함한 모든 노드를 연결시켜 주면 됨.
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No1368 {
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] parentNode = new int[n + 1];
		int[] digCost = new int[n + 1];
		int[][] connectCost = new int[n + 1][n + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		long minCost = 0;
		
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
			digCost[i] = Integer.parseInt(br.readLine());
			list.add(new NodeInfo(0, i, digCost[i]));
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				connectCost[i][j] = Integer.parseInt(st.nextToken());
				if(connectCost[i][j] != 0) list.add(new NodeInfo(i, j, connectCost[i][j]));
			}
		}
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		
		for(NodeInfo i : list) {
			if(find(parentNode, i.a, i.b)) continue;
			union(parentNode, i.a, i.b);
			minCost += i.c;
		}
		
		System.out.println(minCost);
	}
}