//No24463_미로_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No24463 {
	static final int[] upDown = {-1, 1, 0, 0};
	static final int[] leftRight = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] isVisited;
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void dfs(int x, int y, int sizeN, int sizeM, int[] end) {
		isVisited[x][y] = true;
		map[x][y] = '.';
		
		if(x == end[0] && y == end[1]) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < sizeN; i++) sb.append(map[i]).append("\n");
			System.out.println(sb.toString());
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + upDown[i];
			int nextY = y + leftRight[i];
			if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
			if(map[nextX][nextY] == '@' && !isVisited[nextX][nextY]) {
				map[nextX][nextY] = '.';
				dfs(nextX, nextY, sizeN, sizeM, end);
				map[nextX][nextY] = '@';
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
		ArrayList<int[]> hole = new ArrayList<int[]>();
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '.' && (i == 0 || j == 0 || i == n - 1 || j == m - 1)) {
					hole.add(new int[] {i, j});
				}
				if(map[i][j] == '.') map[i][j] = '@';
			}
		}

		dfs(hole.get(0)[0], hole.get(0)[1], n, m, hole.get(1));
	}
}