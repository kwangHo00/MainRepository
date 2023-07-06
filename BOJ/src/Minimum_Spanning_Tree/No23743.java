//No23743_방탈출_정답
//이 문제처럼 특정 노드를 다른 노드와 연결하지 않고 각각의 노드를 개별적으로 해결 해야하는 경우를 고려해야 된다면,
//임의의 노드(ex_노드가 1번 부터 시작한다면 임의 노드 0번을 만듦)를 만들어서 그 해당 노드를 임의 노드와 연결해서 처리
//1368_물대기 문제도 위와 같이 풀면 됨
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No23743 {
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
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
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
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int t = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(0, i, t));
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		long answer = 0;
		for(NodeInfo i : list) {
			if(!find(parentNode, i.a, i.b)) {
				union(parentNode, i.a, i.b);
				answer += i.c;
			}
		}
		System.out.println(answer);
	}
}