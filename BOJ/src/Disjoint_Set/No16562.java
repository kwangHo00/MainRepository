//No16562_친구비_정답_두번만에 정답_ 1) minFee값 업데이트하는 로직을 잘못 짬
package Disjoint_Set;

import java.io.*;
import java.util.*;

public class No16562 {
	
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
	
	static int bfs(int n, int sizeN, int[] parent, int[] fee, boolean[] isVisited) {
		Queue<Integer> q = new LinkedList<Integer>();
		int minFee = fee[n];
		isVisited[n] = true;
		q.add(n);
		
		while(!q.isEmpty()) {
			int currN = q.poll();
			for(int i = 1; i <= sizeN; i++) {
				if(find(parent, currN, i) && !isVisited[i]) {
					isVisited[i] = true;
					q.add(i);
					minFee = fee[i] <= minFee ? fee[i] : minFee;
				}
			}
		}
		return minFee;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] parentNode = new int[n + 1];
		int[] fee = new int[n + 1];
		boolean[] isVisited = new boolean[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
			fee[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(!find(parentNode, v, w)) union(parentNode, v, w);
		}
		
		int totalFee = 0;
		for(int i = 1; i <= n; i++) {
			if(!isVisited[i]) {
				totalFee += bfs(i, n, parentNode, fee, isVisited);
			}
		}
		if(totalFee <= k) System.out.println(totalFee);
		else System.out.println("Oh no");
	}
}