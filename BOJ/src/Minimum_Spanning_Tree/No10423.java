//No10423_전기가부족해_두번만에 정답_ 1) 전기가 공급되고 있는 마을을 확인하는 로직을 잘못 짬
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No10423 {
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
		int k = Integer.parseInt(st.nextToken());
		
		int[] powerStation = new int[k];
		int[] parentNode = new int[n + 1];
		boolean[] isSupply = new boolean[n + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
			isSupply[i] = false;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			powerStation[i] = Integer.parseInt(st.nextToken());
			isSupply[powerStation[i]] = true;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(a, b, c));
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		long answer = 0;
		for(NodeInfo i : list) {
			if(!find(parentNode, i.a, i.b) && (!isSupply[i.a] || !isSupply[i.b])) {
				union(parentNode, i.a, i.b);
				answer += i.c;
				if(isSupply[i.a]) {
					for(int j = 1; j <= n; j++) {
						if(find(parentNode, i.a, j)) isSupply[j] = true;
					}
				}else if(isSupply[i.b]) {
					for(int j = 1; j <= n; j++) {
						if(find(parentNode, i.b, j)) isSupply[j] = true;
					}
				}
			}
		}
		System.out.println(answer);
	}
}