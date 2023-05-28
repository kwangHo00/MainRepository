//No17086_아기상어2
import java.util.*;
import java.io.*;
public class No17086 {
	static int[][] space;
	static boolean[][] isVisited;
	static int[][] dist;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static class Pair{
		int r;
		int c;
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	
	static void checkDist(int a, int b, int sizeN, int sizeM) {
		queue.add(new Pair(a, b));
		isVisited[a][b] = true;
		final int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1};
		final int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
		
		while(!queue.isEmpty()) {
			int nowR = queue.peek().r;
			int nowC = queue.peek().c;
			queue.poll();
			for(int i = 0; i < 8; i++) {
				int tmpR = nowR + upDown[i];
				int tmpC = nowC + leftRight[i];
				if(tmpR < 0 || tmpR > sizeN - 1 || tmpC < 0 || tmpC > sizeM - 1) continue;
				if(space[tmpR][tmpC] == 1) {
					
				}
				if(space[tmpR][tmpC] == 0 && !isVisited[tmpR][tmpC]) {
					queue.add(new Pair(tmpR, tmpC));
					isVisited[tmpR][tmpC] = true;
					dist[tmpR][tmpC] = dist[nowR][nowC] + 1;
				}
			}
		}
	}
	
	static void initIsVisitedArrFalse(int sizeN, int sizeM) {
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				isVisited[i][j] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		space = new int[n][m];
		isVisited= new boolean[n][m];
		dist = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(space[i][j] == 0) checkDist(i, j, n, m);
			}
		}
		
		
		int maxDist = dist[0][0];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(dist[i][j] >= maxDist) maxDist = dist[i][j];
			}
		}
		System.out.println(maxDist);
	}
}