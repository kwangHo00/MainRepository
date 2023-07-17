//No11085_군사 이동_ 두번만에 정답 _ 좁은 길 찾는 로직을 잘못 짬
package Disjoint_Set;

import java.io.*;
import java.util.*;

public class No11085 {
	static class NodeInfo {
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

		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] parentNode = new int[p];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 0; i < p; i++) {
			parentNode[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(a, b, t));
		}
		
		Collections.sort(list, (a, b) -> b.c - a.c);
		
		int answer = 0;
		for(NodeInfo i : list) {
			union(parentNode, i.a, i.b);
			if(find(parentNode, c, v)) {
				answer = i.c;
				break;
			}
		}
		System.out.println(answer);
	}
}