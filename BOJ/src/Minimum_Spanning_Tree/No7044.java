//No7044_Bad Cowtractors_두번만에 정답 _ 문제 제대로 안봄
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No7044 {
	static ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
	
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
		
		int[] parentNode = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			parentNode[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(a, b, c));
		}
		
		Collections.sort(list, (a, b) -> b.c - a.c);
		
		long answer = 0;
		for(NodeInfo i : list) {
			if(!find(parentNode, i.a, i.b)) {
				union(parentNode, i.a, i.b);
				answer += i.c;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(!find(parentNode, 1, i)) {
				answer = -1;
				break;
			}
		}
		
		System.out.println(answer);
	}
}