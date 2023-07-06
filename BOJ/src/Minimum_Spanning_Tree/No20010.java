//No20010_악덕영주혜유_두번만에 정답_1) 가장 거리가 먼 두 노드 사이의 거리를 구하는 방법을 몰라서 구글링
package Minimum_Spanning_Tree;

import java.io.*;
import  java.util.*;

public class No20010 {
	static ArrayList<ArrayList<NodeInfo>> nodeList = new ArrayList<ArrayList<NodeInfo>>();
	static boolean[] isVisited;
	static long max = 0;
	static int startNode = 0;
	
	static class NodeInfo{
		int a, b, c;
		NodeInfo(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		NodeInfo(int b, int c){
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
	
	static void dfs(int n, int s) {
		isVisited[n] = true;
		if(max < s) {
			max = s;
			startNode = n;
		}
		
		int listSize = nodeList.get(n).size();
		for(int i = 0; i < listSize; i++) {
			int nextN = nodeList.get(n).get(i).b;
			int nextC = nodeList.get(n).get(i).c;
			if(!isVisited[nextN]) {
				dfs(nextN, s + nextC);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] parentNode = new int[n];
		ArrayList<NodeInfo> mst = new ArrayList<NodeInfo>();
		isVisited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			parentNode[i] = i;
			nodeList.add(new ArrayList<NodeInfo>());
		}
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			mst.add(new NodeInfo(a, b, c));
		}
		
		Collections.sort(mst, (a, b) -> a.c - b.c);
		
		long answer = 0;
		for(NodeInfo i : mst) {
			if(!find(parentNode, i.a, i.b)) {
				union(parentNode, i.a, i.b);
				answer += i.c;
				nodeList.get(i.a).add(new NodeInfo(i.b, i.c));
				nodeList.get(i.b).add(new NodeInfo(i.a, i.c));
			}
		}
		
		dfs(0, 0);
		
		max = 0;
		isVisited = new boolean[n];
		dfs(startNode, 0);
		
		System.out.println(answer);
		System.out.println(max);
	}
}