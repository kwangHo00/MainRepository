//No27737_버섯 농장_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No27737 {
	static int[][] map;
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static final int[] upDown = {-1, 1, 0, 0};
	static final int[] leftRight = {0, 0, -1, 1};
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int bfs(int x, int y, int sizeN) {
		int size = 1;
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
				if(map[nextX][nextY] == 0 && !isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
					queue.add(new Pair(nextX, nextY));
					size += 1;
				}
			}
		}
		return size;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		isVisited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0 && !isVisited[i][j]) {
					int areaSize = bfs(i, j, n);
					if(k == 1) answer += areaSize;
					if(k != 1 && areaSize > k) answer += areaSize / k + 1;
					else if(k != 1 && areaSize <= k) answer += 1;
				}
			}
		}
		if(answer > m || answer == 0) System.out.println("IMPOSSIBLE");
		else System.out.println("POSSIBLE\n" + (m - answer));
	}
}