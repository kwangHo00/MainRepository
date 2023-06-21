package 그래프탐색;
//No14716_현수막_정답
import java.io.*;
import java.util.*;
public class No14716 {
	static void dfs(int[][] banner, boolean[][] isVisited, int m, int n, int sizeM, int sizeN) {
		isVisited[m][n] = true;
		
		final int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1};
		final int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
		
		for(int i = 0; i < 8; i++) {
			int nextM = m + upDown[i];
			int nextN = n + leftRight[i];
			if(nextM < 0 || nextM > sizeM - 1 || nextN < 0 || nextN > sizeN - 1) continue;
			if(banner[nextM][nextN] == 1 && !isVisited[nextM][nextN])
				dfs(banner, isVisited, nextM, nextN, sizeM, sizeN);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] banner = new int[m][n];
		boolean[][] isVisited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				banner[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(banner[i][j] == 1 && !isVisited[i][j]) {
					dfs(banner, isVisited, i, j, m, n);
					answer += 1;
				}
			}
		}
		System.out.println(answer);
	}
}