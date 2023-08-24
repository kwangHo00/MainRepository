//No5958_Space Exploration_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No5958 {
	static final int[] upDown = {-1, 1, 0, 0};
	static final int[] leftRight = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y, int sizeN) {
		isVisited[x][y] = true;
		queue.add(new Pair(x, y));
		
		while(!queue.isEmpty()) {
			int currX = queue.peek().x;
			int currY = queue.peek().y;
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = currX + upDown[i];
				int nextY = currY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeN - 1) continue;
				if(map[nextX][nextY] == '*' && !isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
					queue.add(new Pair(nextX, nextY));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		map = new char[n][n];
		isVisited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == '*' && !isVisited[i][j]) {
					bfs(i, j, n);
					answer += 1;
				}
			}
		}
		System.out.println(answer);
	}
}