//No12834_주간미팅_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No12834 {
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

		final int INF = Integer.MAX_VALUE;

		int n = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[] houseLoc = new int[n + 1], distPerPerson = new int[n + 1], dist = new int[v + 1];
		boolean[] isVisited = new boolean[v + 1];
		ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
		PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
		
		for(int i = 0; i <= v; i++) {
			list.add(new ArrayList<NodeInfo>());
		}
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			houseLoc[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new NodeInfo(b, c));
			list.get(b).add(new NodeInfo(a, c));
		}
		
		long answer = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= v; j++) {
				dist[j] = INF;
				isVisited[j] = false;
			}
			
			dist[houseLoc[i]] = 0;
			pq.add(new NodeInfo(houseLoc[i], 0));
			
			while(!pq.isEmpty()) {
				int currN = pq.poll().n;
				if(!isVisited[currN]) {
					isVisited[currN] = true;
					for(NodeInfo nextNode : list.get(currN)) {
						if(!isVisited[nextNode.n] && dist[currN] + nextNode.c < dist[nextNode.n]) {
							dist[nextNode.n] = dist[currN] + nextNode.c;
							pq.add(new NodeInfo(nextNode.n, dist[nextNode.n]));
						}
					}
				}
			}
			
			if(dist[A] == INF) dist[A] = -1;
			if(dist[B] == INF) dist[B] = -1;
			distPerPerson[i] = dist[A] + dist[B];
			answer += distPerPerson[i];
		}
		System.out.println(answer);
	}
}