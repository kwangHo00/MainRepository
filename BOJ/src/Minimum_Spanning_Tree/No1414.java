//No1414_불우이웃돕기_정답
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No1414 {
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
		
		int n = Integer.parseInt(br.readLine());
		
		int[] parentNode = new int[n];
		char[][] connection = new char[n][n];
		int totalLength = 0, connectLength = 0;
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		
		for(int i = 0; i < n; i++) {
			parentNode[i] = i;
		}
		
		for(int i = 0; i < n; i++) {
			connection[i] = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				if(connection[i][j] == '0') continue;
				if(connection[i][j] >= 'a' && connection[i][j] <= 'z') {
					totalLength += connection[i][j] - 96;
					if(i != j) list.add(new NodeInfo(i, j, connection[i][j] - 96));
				}
				else {
					totalLength += connection[i][j] - 38;
					if(i != j) list.add(new NodeInfo(i, j, connection[i][j] - 38));
				}
			}
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		for(NodeInfo i : list) {
			if(!find(parentNode, i.a, i.b)) {
				union(parentNode, i.a, i.b);
				connectLength += i.c;
			}
		}
		
		int answer = totalLength - connectLength;
		for(int i = 0; i < n - 1; i++) {
			if(!find(parentNode, i, i + 1)) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}
}