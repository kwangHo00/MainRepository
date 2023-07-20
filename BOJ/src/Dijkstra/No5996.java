//No5996_HeatWave_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No5996 {
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		final int INF = Integer.MAX_VALUE;
		
		int[] dist = new int[t + 1];
		boolean[] isVisited = new boolean[t + 1];
		
		ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
		PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
		
		for(int i = 0; i <= t; i++) {
			list.add(new ArrayList<NodeInfo>());
			dist[i] = INF;
			isVisited[i] = false;
		}
		
		for(int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(a).add(new NodeInfo(b, w));
			list.get(b).add(new NodeInfo(a, w));
		}
		
		dist[s] = 0;
		pq.add(new NodeInfo(s, 0));
		
		while(!pq.isEmpty()) {
			int currN = pq.poll().n;
			if(!isVisited[currN]) {
				isVisited[currN] = true;
				for(NodeInfo i : list.get(currN)) {
					if(!isVisited[i.n] && dist[currN] + i.c < dist[i.n]) {
						dist[i.n] = dist[currN] + i.c;
						pq.add(new NodeInfo(i.n, dist[i.n]));
					}
				}
			}
		}
		
		System.out.println(dist[e]);
	}
}