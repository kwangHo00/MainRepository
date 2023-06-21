package 그래프탐색;
//No3187_양치기꿍_정답
import java.io.*;
import java.util.*;
public class No3187 {
	static char[][] map;
	static boolean[][] isVisited;
	static int cntWolf, cntSheep, totalWolf, totalSheep;
	
	static void dfs(int a, int b, int sizeR, int sizeC) {
		if(map[a][b] == 'k') cntSheep += 1;
		else if(map[a][b] == 'v') cntWolf += 1;
		isVisited[a][b] = true;
		
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int nextA = a + upDown[i];
			int nextB = b + leftRight[i];
			if(nextA < 0 || nextA > sizeR - 1 || nextB < 0 || nextB > sizeC - 1) continue;
			if((map[nextA][nextB] == '.' || map[nextA][nextB] == 'v' || map[nextA][nextB] == 'k') && !isVisited[nextA][nextB]) 
				dfs(nextA, nextB, sizeR, sizeC);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		isVisited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				cntWolf = 0;
				cntSheep = 0;
				if((map[i][j] == '.' || map[i][j] == 'v' || map[i][j] == 'k') && !isVisited[i][j]) {
					dfs(i, j, r, c);
					totalSheep += cntSheep > cntWolf ? cntSheep : 0;
					totalWolf += cntWolf >= cntSheep ? cntWolf : 0;
				}
			}
		}
		System.out.println(totalSheep + " " + totalWolf);
	}
}