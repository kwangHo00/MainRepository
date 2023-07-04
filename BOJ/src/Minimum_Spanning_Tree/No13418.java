//No13418_학교탐방하기_정답
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No13418 {
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
		int m = Integer.parseInt(st.nextToken());
		int best = 0, worst = 0;
		int[] parentNode = new int[n + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 0; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(a, b, c));
		}
		
		//최악의 경우
		Collections.sort(list, (a, b) -> a.c - b.c);
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
		}
		for(NodeInfo i : list) {
			if(find(parentNode, i.a, i.b)) continue;
			if(i.c == 0) worst += 1;
			union(parentNode, i.a, i.b);
		}
		
		//최선의 경우
		Collections.sort(list, (a, b) -> b.c - a.c);
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
		}
		for(NodeInfo i : list) {
			if(find(parentNode, i.a, i.b)) continue;
			if(i.c == 0) best += 1;
			union(parentNode, i.a, i.b);
		}
		
		System.out.println((int) Math.abs(Math.pow(worst, 2) - Math.pow(best, 2)));
	}
}