//No22352_항체 인식_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No22352 {
	static final int[] upDown = {-1, 1, 0, 0};
	static final int[] leftRight = {0, 0, -1, 1};
	static int[][] before, after;
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y, int valueBf, int valueAf, int sizeN, int sizeM) {
		isVisited[x][y] = true;
		queue.add(new Pair(x, y));
		before[x][y] = valueAf;
		
		while(!queue.isEmpty()) {
			int currX = queue.peek().x;
			int currY = queue.peek().y;
			queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = currX + upDown[i];
				int nextY = currY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
				if(before[nextX][nextY] == valueBf && !isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
					queue.add(new Pair(nextX, nextY));
					before[nextX][nextY] = valueAf;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		before = new int[n][m];
		after = new int[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				before[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				after[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int checkCnt = 0;
		for(int i = 0; i < n; i++) {
			if(checkCnt != 0) break;
			for(int j = 0; j < m; j++) {
				if(before[i][j] != after[i][j] && checkCnt == 0) {
					bfs(i, j, before[i][j], after[i][j], n, m);
					checkCnt += 1;
				}
			}
		}
		
		String answer = "YES";
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(before[i][j] != after[i][j]) answer = "NO";
			}
		}
		System.out.println(answer);
	}
}