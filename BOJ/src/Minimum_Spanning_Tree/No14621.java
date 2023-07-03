//No14621_나만안되는연애_3번만에 정답_ 1), 2) 모든 학교를 연결하는 경로가 없는 상황을 잘 못 체크함
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No14621 {
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
		char[] schoolInfo = new char[n + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			schoolInfo[i] = st.nextToken().charAt(0);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(a, b, c));
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		int answer = 0;
		for(NodeInfo i : list) {
			if(find(parentNode, i.a, i.b) || schoolInfo[i.a] == schoolInfo[i.b]) continue;
			union(parentNode, i.a, i.b);
			answer += i.c;
		}
		
		for(int i = 1; i < n; i++) {
			if(!find(parentNode, i, i + 1)) answer = -1;
		}
		System.out.println(answer);
	}
}