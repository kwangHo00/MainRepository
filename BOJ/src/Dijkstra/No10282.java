//No10282_해킹_ 두번만에 정답 _ 1) 클래스명 Main으로 안바꿔서 컴파일 에러
package Dijkstra;

import java.io.*;
import java.util.*;

public class No10282 {
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
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		
		long[] dist;
		boolean[] isVisited;
		final long INF = Long.MAX_VALUE;
		
		ArrayList<ArrayList<NodeInfo>> list;
		PriorityQueue<NodeInfo> pq;
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist = new long[n + 1];
			isVisited= new boolean[n + 1];
			list = new ArrayList<ArrayList<NodeInfo>>();
			pq = new PriorityQueue<NodeInfo>();
			
			for(int i = 0; i <= n; i++) {
				list.add(new ArrayList<NodeInfo>());
				dist[i] = INF;
				isVisited[i] = false;
			}
			
			for(int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list.get(b).add(new NodeInfo(a, s));
			}
			
			int cnt = 0;
			long time = 0;
			
			dist[c] = 0;
			pq.add(new NodeInfo(c, 0));
			
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
			
			for(int i = 1; i <= n; i++) {
				if(dist[i] != INF) {
					cnt += 1;
					time = dist[i] > time ? dist[i] : time;
				}
			}
			
			System.out.println(cnt + " " + time);
		}
	}
}