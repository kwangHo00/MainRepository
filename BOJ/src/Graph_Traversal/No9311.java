//No9311_Robot in a maze_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No9311 {
	static int[][] dist;
	static char[][] maze;
	static boolean[][] isVisited;
	static int INF = Integer.MAX_VALUE;
	static Queue<Pair> queue = new LinkedList<Pair>();
	
	static class Pair{
		int a, b;
		Pair(int a, int b){
			this.a = a; 
			this.b = b;
		}
	}
	
	static int bfs(int a, int b, int sizeR, int sizeC) {
		int answer = INF;
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		
		isVisited[a][b] = true;
		queue.add(new Pair(a, b));
		
		while(!queue.isEmpty()) {
			int currA = queue.peek().a;
			int currB = queue.peek().b;
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextA = currA + upDown[i];
				int nextB = currB + leftRight[i];
				if(nextA < 0 || nextA > sizeR - 1 || nextB < 0 || nextB > sizeC - 1) continue;
				if((maze[nextA][nextB] == 'O' || maze[nextA][nextB] == 'G' || maze[nextA][nextB] == '0') && !isVisited[nextA][nextB]) {
					isVisited[nextA][nextB] = true;
					dist[nextA][nextB] = dist[currA][currB] + 1;
					queue.add(new Pair(nextA, nextB));
					if(maze[nextA][nextB] == 'G' && dist[nextA][nextB] < answer) 
						answer = dist[nextA][nextB];
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist = new int[r][c];
			maze = new char[r][c];
			isVisited = new boolean[r][c];
			
			int s1 = -1, s2 = -1;
			for(int i = 0; i < r; i++) {
				maze[i] = br.readLine().toCharArray();
				for(int j = 0; j < c; j++) {
					if(maze[i][j] == 'S') {
						s1 = i;
						s2 = j;
					}
				}
			}
			
			int dist = bfs(s1, s2, r, c);
			if(dist == INF) System.out.println("No Exit");
			else System.out.println("Shortest Path: " + dist);
		}
	}
}