//No24391_귀찮은 해강이_정답
package Disjoint_Set;

import java.io.*;
import java.util.*;

public class No24391 {
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
	
	static ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] parentNode = new int[n + 1];
		int[] schedule = new int[n];
		
		for(int i = 0; i <= n; i++) {
			parentNode[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new NodeInfo(a, b));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			schedule[i] = Integer.parseInt(st.nextToken());
		}
		
		for(NodeInfo i : list) {
			if(!find(parentNode, i.a, i.b)) union(parentNode, i.a, i.b);
		}
		
		int answer = 0;
		for(int i = 0; i < n - 1; i++) {
			if(!find(parentNode, schedule[i], schedule[i + 1])) answer += 1;
		}
		
		System.out.println(answer);
	}
}