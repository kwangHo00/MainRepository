//No4485_녹색옷입은애가젤다지??_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No4485 {
	static class Pair implements Comparable<Pair>{
		int a, b, c;
		Pair(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.c < o.c ? -1 : 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	 	int[][] map, cost;
	 	boolean[][] isVisited;
	 	final int[] upDown = {-1, 1, 0, 0};
	 	final int[] leftRight = {0, 0, -1, 1};
	 	final int INF = Integer.MAX_VALUE;	 	PriorityQueue<Pair> pq;	 	
		
	 	int cnt = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			map = new int[n][n];
			cost = new int[n][n];
			isVisited = new boolean[n][n];
			pq = new PriorityQueue<Pair>();
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}
			
			cost[0][0] = map[0][0];
			pq.add(new Pair(0, 0, cost[0][0]));
			
			while(!pq.isEmpty()) {
				int currA = pq.peek().a;
				int currB = pq.peek().b;
				pq.poll();
				
				if(!isVisited[currA][currB]) {
					isVisited[currA][currB] = true;
					
					for(int i = 0; i < 4; i++) {
						int nextA = currA + upDown[i];
						int nextB = currB + leftRight[i];
						
						if(nextA < 0 || nextA > n - 1 || nextB < 0 || nextB > n - 1) continue;
						if(!isVisited[nextA][nextB] && cost[currA][currB] + map[nextA][nextB] < cost[nextA][nextB]) {
							cost[nextA][nextB] = cost[currA][currB] + map[nextA][nextB];
							pq.add(new Pair(nextA, nextB, cost[nextA][nextB]));
						}
					}
				}
			}
			System.out.println("Problem " + cnt++ + ": "+  cost[n - 1][n - 1]);
		}
	}
}