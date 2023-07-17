//No17396_백도어_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No17396 {
	static class NodeInfo implements Comparable<NodeInfo>{
		int n;
		long c;
		NodeInfo(int n, long c){
			this.n = n;
			this.c = c;
		}
		
		@Override
		public int compareTo(NodeInfo o) {
			return this.c < o.c ? -1 : 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		final long INF = Long.MAX_VALUE;
		
		boolean[] isVisited = new boolean[n];
		long[] dist = new long[n];
		int[] sight = new int[n];
		
		ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
		PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
		
		for(int i = 0; i < n; i++) {
			isVisited[i] = false;
			dist[i] = INF;
			sight[i] = -1;
			list.add(new ArrayList<NodeInfo>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			sight[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new NodeInfo(b, c));
			list.get(b).add(new NodeInfo(a, c));
		}
		
		dist[0] = 0;
		pq.add(new NodeInfo(0, 0));
		
		while(!pq.isEmpty()) {
			int currN = pq.poll().n;
			if(!isVisited[currN]) {
				isVisited[currN] = true;
				
				for(NodeInfo i : list.get(currN)) {
					if(!isVisited[i.n] && (i.n != n - 1 && sight[i.n] != 1) || !isVisited[i.n] && (i.n == n - 1 && sight[i.n] == 1)) {
						if(dist[currN] + i.c < dist[i.n]) {
							dist[i.n] = dist[currN] + i.c;
							pq.add(new NodeInfo(i.n, dist[i.n]));
						}
					}
				}
			}
		}
		if(dist[n - 1] == INF) System.out.println("-1");
		else System.out.println(dist[n - 1]);
	}
}