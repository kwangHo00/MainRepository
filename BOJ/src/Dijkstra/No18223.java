//No18223_민준이와 마산 그리고 건우_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No18223 {
	static int INF = Integer.MAX_VALUE;
	static int[] dist;
	static boolean[] isVisited;
	static ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
	static PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
	
	static class NodeInfo implements Comparable<NodeInfo>{
		int n, c;
		NodeInfo(int n, int c){
			this.n = n;
			this.c = c;
		}
		
		@Override
		public int compareTo(NodeInfo o) {
			return this.c < o.c ? -1 : 1;
		}
	}
	
	static int dijkstra(int s, int e, int v) {
		dist = new int[v + 1];
		isVisited = new boolean[v + 1];
		
		for(int i = 0; i <= v; i++) {
			dist[i] = INF;
			isVisited[i] = false;
		}
		
		dist[s] = 0;
		pq.add(new NodeInfo(s, 0));
		
		while(!pq.isEmpty()) {
			int currN = pq.poll().n;
			if(!isVisited[currN]) {
				isVisited[currN] = true;
				
				for(NodeInfo i : list.get(currN)) {
					if(!isVisited[i.n] && dist[currN] + i.c < dist[i.n]) {
						dist[i.n] = dist[currN ] + i.c;
						pq.add(new NodeInfo(i.n, dist[i.n]));
					}
				}
			}
		}
		return dist[e];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= v; i++) {
			list.add(new ArrayList<NodeInfo>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new NodeInfo(b, c));
			list.get(b).add(new NodeInfo(a, c));
		}
		
		int minDist = dijkstra(1, v, v);
		int minDistWithP = dijkstra(1, p, v) + dijkstra(p, v, v);
		
		if(minDist == minDistWithP) System.out.println("SAVE HIM");
		else System.out.println("GOOD BYE");
	}
}