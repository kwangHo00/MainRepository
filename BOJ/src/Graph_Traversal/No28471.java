//No28471_W키가 빠진 성원이_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No28471 {
	static int[] upDown = {-1, -1, 0, 1, 0, 1, 0, -1};
	static int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
	static int answer = 0;
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
			
			for(int i = 0; i < 8; i++) {
				int nextX = currX + upDown[i];
				int nextY = currY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeN - 1) continue;
				if(map[nextX][nextY] == '.' && !isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
					queue.add(new Pair(nextX, nextY));
					answer += 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		isVisited = new boolean[n][n];
		int[] start = new int[] {-1, -1};
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 'F') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		
		bfs(start[0], start[1], n);
		System.out.println(answer);
	}
}