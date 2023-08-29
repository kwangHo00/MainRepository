//No14221편의점
package unsolved;

import java.io.*;
import java.util.*;

public class No14221 {
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
		long[] dist = new long[n + 1];
		boolean[] isVisited = new boolean[n + 1];
		
		ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
		PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i = 0; i <= n; i++) {
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
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] houseLoc = new int[p];
		int[] storeLoc = new int[q];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < p; i++) {
			houseLoc[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < q; i++) {
			storeLoc[i] = Integer.parseInt(st.nextToken());
			queue.add(storeLoc[i]);
		}
		
//		PriorityQueue<NodeInfo> answer = new PriorityQueue<NodeInfo>();
		
		long minDist = INF;
		int answer = -1;
		while(!queue.isEmpty()) {
			Arrays.fill(isVisited, false);
			Arrays.fill(dist, INF);
			
			int nowLoc = queue.poll();
			
			dist[nowLoc] = 0;
			pq.add(new NodeInfo(nowLoc, 0));
			
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
			
//			for(int i : houseLoc) {
//				answer.add(new NodeInfo(i, dist[i]));
//			}
			for(int i = 0; i < p; i++) {
				if(dist[houseLoc[i]] < minDist) {
					minDist = dist[houseLoc[i]];
					answer = houseLoc[i];
				}
			}
		}
		
		System.out.println(answer);
	}
}