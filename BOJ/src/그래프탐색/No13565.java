package 그래프탐색;
//No13565_침투_정답
import java.io.*;
import java.util.*;
public class No13565 {
	static char[][] grid;
	static boolean[][] isVisited;
	
	static void dfs(int a, int b, int sizeM, int sizeN) {
		isVisited[a][b] = true;
		
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		for(int i = 0; i < 4; i++) {
			int nextA = a + upDown[i];
			int nextB = b + leftRight[i];
			if(nextA < 0 || nextA > sizeM - 1 || nextB < 0 || nextB > sizeN - 1) continue;
			if(grid[nextA][nextB] == '0' && !isVisited[nextA][nextB]) {
				dfs(nextA, nextB, sizeM, sizeN);
			}
		}
	}
	
	static boolean permeability(int sizeM, int sizeN) {
		for(int i = 0; i < sizeN; i++) {
			if(isVisited[sizeM - 1][i]) return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		grid = new char[m][n];
		isVisited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			if(grid[0][i] == '0') dfs(0, i, m, n);
		}
		
		if(permeability(m, n)) System.out.println("YES");
		else System.out.println("NO");
	}
}