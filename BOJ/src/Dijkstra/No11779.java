//No11779_최소비용구하기2_3번만에 정답 1), 2) 경로 추적하는 로직을 잘 못 짬 _ 부계에서 2번 틀림
package Dijkstra;

import java.io.*;
import java.util.*;

public class No11779 {
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

		final int INF = Integer.MAX_VALUE;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] path = new int[n + 1];
		long[] dist = new long[n + 1];
		boolean[] isVisited = new boolean[n + 1];
		ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
		PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();
		
		for(int i = 0; i <= n; i++) {
			path[i] = 0;
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
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
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
						path[i.n] = currN;
					}
				}
			}
		}
		
		int cur = e;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		while(cur != s) {
			answer.add(cur);
            cur = path[cur];
		}
		answer.add(cur);
		
		int answerSize = answer.size();
		System.out.println(dist[e]);
		System.out.println(answerSize);
		for(int i = answerSize - 1; i >= 0; i--) {
			System.out.print(answer.get(i) + " ");
		}
	}
}