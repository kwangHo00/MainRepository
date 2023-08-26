//No15092_Sheba’s Amoebas_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No15092 {
	static final int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1};
	static final int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
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
	
	static void bfs(int x, int y, int sizeN, int sizeM) {
		isVisited[x][y] = true;
		queue.add(new Pair(x, y));
		
		while(!queue.isEmpty()) {
			int currX = queue.peek().x;
			int currY = queue.peek().y;
			queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nextX = currX + upDown[i];
				int nextY = currY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
				if(map[nextX][nextY] == '#' && !isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
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
		
		map = new char[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '#' && !isVisited[i][j]) {
					bfs(i, j, n, m);
					answer += 1;
				}
			}
		}
		System.out.println(answer);
	}
}