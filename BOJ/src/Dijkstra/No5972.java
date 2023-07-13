//No5972_택배발송_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No5972 {
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
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		final int INF = Integer.MAX_VALUE;
		
		int[] dist = new int[n + 1];
		boolean[] isVisited = new boolean[n + 1];
		ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
		PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
		
		for(int i = 0; i <= n; i++) {
			dist[i] = INF;
			isVisited[i] = false;
			list.add(new ArrayList<NodeInfo>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new NodeInfo(b, c));
			list.get(b).add(new NodeInfo(a, c));
		}
		
		dist[1] = 0;
		pq.add(new NodeInfo(1, 0));
		
		while(!pq.isEmpty()) {
			NodeInfo nowNode = pq.poll();
			if(!isVisited[nowNode.n]) {
				isVisited[nowNode.n] = true;
				
				for(NodeInfo i : list.get(nowNode.n)) {
					if(!isVisited[i.n] && dist[nowNode.n] + i.c < dist[i.n]) {
						dist[i.n] = dist[nowNode.n] + i.c;
						pq.add(new NodeInfo(i.n, dist[i.n]));
					}
				}
			}
		}
		System.out.println(dist[n]);
	}
}