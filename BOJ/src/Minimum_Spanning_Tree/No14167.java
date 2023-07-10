//No14167_MooCast_정답
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No14167 {
	static class NodeInfo{
		int a, b;
		long c;
		NodeInfo(int a, int b, long c){
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
		int[] parentNode = new int[n];
		int[] locX = new int[n], locY = new int[n];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			locX[i] = x;
			locY[i] = y;
			parentNode[i] = i;
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				long cost = (locX[i] - locX[j]) * (locX[i] - locX[j]) + (locY[i] - locY[j]) * (locY[i] - locY[j]);
				list.add(new NodeInfo(i, j, cost));
			}
		}
		Collections.sort(list, (a, b) -> (int) (a.c - b.c));
		
		long answer = 0;
		for(NodeInfo i : list) {
			if(!find(parentNode, i.a, i.b)) {
				union(parentNode, i.a, i.b);
				answer = i.c > answer ? i.c : answer;
			}
		}
		System.out.println(answer);
	}
}