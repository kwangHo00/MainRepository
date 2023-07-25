//No9694_무엇을 아느냐가 아니라 누구를 아느냐가 문제다_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No9694 {
	static class NodeInfo implements Comparable<NodeInfo>{
		int n, c;
		NodeInfo(int n, int c){
			this.n = n; 
			this.c = c;
		}
		
		public int compareTo(NodeInfo o) {
			return this.c < o.c ? -1 : 1;
		}
	}
	
	static int[] intimacy, preNode;
	static boolean[] isVisited;
	static ArrayList<ArrayList<NodeInfo>> list;
	static ArrayList<Integer> answer;
	static PriorityQueue<NodeInfo> pq = new PriorityQueue<NodeInfo>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = Integer.MAX_VALUE;
		int t = Integer.parseInt(br.readLine());
		
		for(int s = 1; s <= t; s++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			intimacy = new int[m];
			preNode = new int[m];
			isVisited = new boolean[m];
			list = new ArrayList<ArrayList<NodeInfo>>();
			answer = new ArrayList<Integer>();
			
			for(int i = 0; i < m; i++) {
				intimacy[i] = INF;
				list.add(new ArrayList<NodeInfo>());
			}
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.get(a).add(new NodeInfo(b, c));
				list.get(b).add(new NodeInfo(a, c));
			}
			
			intimacy[0] = 0;
			pq.add(new NodeInfo(0, 0));
			
			while(!pq.isEmpty()) {
				int currN = pq.poll().n;
				if(!isVisited[currN]) {
					isVisited[currN] = true;
					for(NodeInfo i: list.get(currN)) {
						int nextN = i.n;
						if(!isVisited[nextN] && intimacy[currN] + i.c < intimacy[nextN]) {
							intimacy[nextN] = intimacy[currN] + i.c;
							preNode[nextN] = currN;
							pq.add(new NodeInfo(nextN, intimacy[nextN]));
						}
					}
				}
			}
			
			int cur = m - 1;
			while(cur != 0) {
				answer.add(cur);
	            cur = preNode[cur];
			}
			answer.add(cur);
			
			int answerSize = answer.size();
			System.out.print("Case #" + s + ": ");
			
			if(intimacy[m - 1] == INF) System.out.println("-1");
			else {
				for(int i = answerSize - 1; i >= 0; i--) {
					System.out.print(answer.get(i) + " ");
				}				
			}
			System.out.println();
		}
	}
}