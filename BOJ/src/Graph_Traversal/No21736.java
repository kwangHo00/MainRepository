//No21736_헌내기는친구가필요해_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No21736 {
	static int cnt = 0;
	static void dfs(int x, int y, int sizeN, int sizeM, char[][] campus, boolean[][] isVisited) {
		isVisited[x][y] = true;
		if(campus[x][y] == 'P') cnt += 1;
		final int[] upDown = {-1, 1, 0, 0 };
		final int[] leftRight = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + upDown[i];
			int nextY = y + leftRight[i];
			if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
			if((campus[nextX][nextY] == 'O' || campus[nextX][nextY] == 'P') && !isVisited[nextX][nextY])
				dfs(nextX, nextY, sizeN, sizeM, campus, isVisited);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] campus = new char[n][m];
		boolean[][] isVisited = new boolean[n][m];
		int x = 0, y = 0;
		
		for(int i = 0; i < n; i++) {
			campus[i] = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(campus[i][j] == 'I') {
					x = i; y = j;
				}
			}
		}
		dfs(x, y, n, m, campus, isVisited);
		if(cnt == 0) System.out.println("TT");
		else System.out.println(cnt);
	}
}