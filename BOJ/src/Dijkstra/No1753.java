//No1753_최단경로_정답 _ 한번 방문한 노드는 이미 최단거리를 가진다는 것이 보장되기 때문에 다시 방문할 필요가 없다는 것 잊지 말기
package Dijkstra;

import java.io.*;
import java.util.*;

public class No1753 {
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		final int INF = Integer.MAX_VALUE;
		
		int[] dist = new int[v + 1];
		boolean[] isVisited = new boolean[v + 1];
		ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
		PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
		
		for(int i = 0; i <= v; i++) {
			list.add(new ArrayList<NodeInfo>());
			dist[i] = INF;
			isVisited[i] = false;
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			list.get(u).add(new NodeInfo(f, o));
		}
		
		dist[k] = 0;
		pq.add(new NodeInfo(k, 0));
		
		while(!pq.isEmpty()) {
			int nowV = pq.poll().n;
			if(!isVisited[nowV]) {
				isVisited[nowV] = true;
				
				for(NodeInfo i : list.get(nowV)) {
					if(!isVisited[i.n] && dist[nowV] + i.c < dist[i.n]) {
						dist[i.n] = dist[nowV] + i.c;
						pq.add(new NodeInfo(i.n, dist[i.n]));
					}
				}
			}
		}
		
		for(int i = 1; i <= v; i++) {
			if(dist[i] == INF) bw.write("INF" + "\n");
			else bw.write(dist[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}