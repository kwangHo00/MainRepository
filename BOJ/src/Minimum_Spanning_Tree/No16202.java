//No16202_MST게임_정답
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No16202 {
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
		StringTokenizer st =  new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] parentNode = new int[n + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(a, b, i + 1));
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		while(k-- > 0) {
			long score = 0;
			for(int i = 1; i <= n; i++) {
				parentNode[i] = i;
			}
			
			for(NodeInfo i : list) {
				if(find(parentNode, i.a, i.b)) continue;
				union(parentNode, i.a, i.b);
				score += i.c;
			}
			
			for(int i = 1; i < n - 1; i++) {
				if(!find(parentNode, i, i + 1)) {
					score = 0;
					break;
				}
			}
			System.out.print(score + " ");
			list.remove(0);
		}
	}
}