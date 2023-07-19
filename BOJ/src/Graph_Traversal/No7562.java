//No7562_나이트의 이동_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No7562 {
	static int[][] dist;
	static boolean[][] isVisited;
	static Queue<Pair> q;
	
	static class Pair{
		int a, b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
	static void bfs(int startA, int startB, int endA, int endB, int sizeN) {
		final int[] upDown = {-2, -1, 1, 2, 2, 1, -1, -2};
		final int[] leftRight = {1, 2, 2, 1, -1, -2, -2, -1};
		
		isVisited[startA][startB] = true;
		q.add(new Pair(startA, startB));
		
		while(!q.isEmpty()) {
			int currA = q.peek().a;
			int currB = q.peek().b;
			q.poll();
			
			if(currA == endA && currB == endB) return;
			
			for(int i = 0; i < 8; i++) {
				int nextA = currA + upDown[i];
				int nextB = currB + leftRight[i];
				
				if(nextA < 0 || nextA > sizeN - 1 || nextB < 0 || nextB > sizeN - 1) continue;
				if(!isVisited[nextA][nextB]) {
					isVisited[nextA][nextB] = true;
					dist[nextA][nextB] = dist[currA][currB] + 1;
					q.add(new Pair(nextA, nextB));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			dist = new int[n][n];
			isVisited = new boolean[n][n];
			q = new LinkedList<Pair>();
			
			st = new StringTokenizer(br.readLine());
			int startA = Integer.parseInt(st.nextToken());
			int startB = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endA = Integer.parseInt(st.nextToken());
			int endB = Integer.parseInt(st.nextToken());
			
			bfs(startA, startB, endA, endB, n);
			System.out.println(dist[endA][endB]);
		}
	}
}