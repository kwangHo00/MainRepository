//No5944_Apple Delivery_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No5944 {
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	static boolean[] isVisited;
	static PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
	static ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
	
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
	
	static void dijkstra(int n, int end, int initDist, int size) {
		dist = new int[size + 1];
		isVisited = new boolean[size + 1];
		Arrays.fill(dist, INF);
		
		dist[n] = initDist;
		pq.add(new NodeInfo(n, initDist));
		
		while(!pq.isEmpty()) {
			int currN = pq.poll().n;
			if(currN == end) return;
			if(!isVisited[currN]) {
				isVisited[currN] = true;
				
				for(NodeInfo next : list.get(currN)) {
					if(!isVisited[next.n] && dist[currN] + next.c < dist[next.n]) {
						dist[next.n] = dist[currN] + next.c;
						pq.add(new NodeInfo(next.n, dist[next.n]));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int pathNum = Integer.parseInt(st.nextToken());
		int nodeNum = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int dir1 = Integer.parseInt(st.nextToken());
		int dir2 = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= nodeNum; i++) list.add(new ArrayList<NodeInfo>());
		
		for(int i = 0; i < pathNum; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new NodeInfo(b, c));
			list.get(b).add(new NodeInfo(a, c));
		}
		
		dijkstra(start, INF, 0, nodeNum);
		int wayPoint = dist[dir1] <= dist[dir2] ? dir1 : dir2;
		int destination = dist[dir1] > dist[dir2] ? dir1 : dir2;
		
		dijkstra(wayPoint, destination, dist[wayPoint], nodeNum);
		System.out.println(dist[destination]);
	}
}