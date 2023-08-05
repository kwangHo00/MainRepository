//No18404_현명한 나이트_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No18404 {
	static int[][] board;
	static int[][] dist;
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static ArrayList<Pair> list = new ArrayList<Pair>();
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y, int sizeN) {
		final int[] upDown = {-2, -1, 1, 2, 2, 1, -1, -2};
		final int[] leftRight = {1, 2, 2, 1, -1, -2, -2, -1};
		
		isVisited[x][y] = true;
		queue.add(new Pair(x, y));
		
		while(!queue.isEmpty()) {
			int currX = queue.peek().x;
			int currY = queue.peek().y;
			queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nextX = currX + upDown[i];
				int nextY = currY + leftRight[i];
				if(nextX < 0 || nextX > sizeN || nextY < 0 || nextY > sizeN) continue;
				if(!isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
					dist[nextX][nextY] = dist[currX][currY] + 1;
					queue.add(new Pair(nextX, nextY));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		board = new int[n + 1][n + 1];
		dist = new int[n + 1][n + 1];
		isVisited = new boolean[n + 1][n + 1];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Pair(a, b));
		}
		
		bfs(x, y, n);
		
		for(Pair i : list) {
			System.out.print(dist[i.x][i.y] + " ");
		}
	}
}