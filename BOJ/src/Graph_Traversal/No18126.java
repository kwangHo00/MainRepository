//No18126_너구리구구_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No18126 {
	static ArrayList<ArrayList<Pair>> list = new ArrayList<ArrayList<Pair>>();
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean[] isVisited;
	static long[] dist;
	static long maxDist = 0;
	static class Pair{
		int nextNode, dist;
		Pair(int nextNode, int dist){
			this.nextNode = nextNode;
			this.dist = dist;
		}
	}

	static void bfs(int n) {
		isVisited[n] = true;
		q.add(n);
		
		while(!q.isEmpty()) {
			int currN = q.poll();
			int listSize = list.get(currN).size();
			for(int i = 0; i < listSize; i++) {
				int nextNode = list.get(currN).get(i).nextNode;
				int distPerNode = list.get(currN).get(i).dist;
				if(!isVisited[nextNode]) {
					isVisited[nextNode] = true;
					q.add(nextNode);
					dist[nextNode] = dist[currN] + distPerNode;
					maxDist = dist[nextNode] >= maxDist ? dist[nextNode] : maxDist;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		isVisited = new boolean[n + 1];
		dist = new long[n + 1];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<Pair>());
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Pair(b, c));
			list.get(b).add(new Pair(a, c));
		}
		bfs(1);
		System.out.println(maxDist);
	}
}