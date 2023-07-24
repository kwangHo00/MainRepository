//No20040_사이클 게임_정답
package Disjoint_Set;

import java.io.*;
import java.util.*;

public class No20040 {
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
	
	static class NodeInfo{
		int a, b;
		NodeInfo(int a, int b){
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] parentNode = new int[n];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 0; i < n; i++) {
			parentNode[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(a, b));
		}
		
		int answer = 0, isConnect = 0;
		for(NodeInfo i : list) {
			if(!find(parentNode, i.a, i.b)) {
				union(parentNode, i.a, i.b);
				answer += 1;
			}
			else {
				answer += 1;
				isConnect = 1;
				break;
			}
		}
		
		if(isConnect == 1) System.out.println(answer);
		else System.out.println("0");
	}
}