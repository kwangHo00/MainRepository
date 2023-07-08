//No4386_별자리만들기_정답
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No4386 {
	static class NodeInfo{
		int a, b;
		double c;
		NodeInfo(int a, int b, double c){
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
		double[] locX = new double[n], locY = new double[n];
		int[] parentNode = new int[n];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 0; i < n; i++) {
			parentNode[i] = i;
			
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			locX[i] = x;
			locY[i] = y;
		}
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				double dist = Math.sqrt(Math.pow(locX[i] - locX[j], 2) + Math.pow(locY[i] - locY[j], 2));
				list.add(new NodeInfo(i, j, dist));
			}
		}
		
		Collections.sort(list, (a, b) -> (int)(a.c - b.c));
		
		double answer = 0.0;
		for(NodeInfo i : list) {
			if(!find(parentNode, i.a, i.b)) {
				union(parentNode, i.a, i.b);
				answer += i.c;
			}
		}
		System.out.println(answer);
	}
}