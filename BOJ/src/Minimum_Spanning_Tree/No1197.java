//No1197_최소스패닝트리_정답
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No1197 {
	static class NodeInfo{
		int a, b, c;
		NodeInfo(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	//특정 노드의 부모 노드를 찾는 메소드
	static int getParent(int[] parent, int n) {
		if(parent[n] == n) return parent[n];
		else return parent[n] = getParent(parent, parent[n]);
	}
	
	//서로 다른 노드를 합치는 메소드
	static void union(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if(aParent < bParent) parent[bParent] = aParent;
		else parent[aParent] = bParent;
	}
	
	//서로 다른 두 노드가 연결되어 있는지 확인하는 메소드
	static boolean find(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if(aParent == bParent) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[] parentNode = new int[v + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 1; i <= v; i++) {
			parentNode[i] = i;
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new NodeInfo(a, b, c));
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		int answer = 0;
		for(NodeInfo i : list) {
			if(find(parentNode, i.a, i.b)) continue;
			union(parentNode, i.a, i.b);
			answer += i.c;
		}
		
		System.out.println(answer);
	}
}