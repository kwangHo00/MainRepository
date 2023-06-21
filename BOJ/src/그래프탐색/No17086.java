package 그래프탐색;
//No17086_아기상어2_두번째만에 정답
import java.util.*;
import java.io.*;
public class No17086{
	static int[][] space;
	static int[][] dist;
	static boolean[][] isVisited;
	static int safeDist, answer = 0;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y, int sizeN, int sizeM) {
		queue.add(new Pair(x, y));
		isVisited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int nowX = queue.peek().x;
			int nowY = queue.peek().y;
			queue.poll();
			
			final int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1};
			final int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
			for(int i = 0; i < 8; i++) {
				int nextX = nowX + upDown[i];
				int nextY = nowY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
				if(!isVisited[nextX][nextY]) {
					queue.add(new Pair(nextX, nextY));
					isVisited[nextX][nextY] = true;
					dist[nextX][nextY] = dist[nowX][nowY] + 1;
				}
				if(space[nextX][nextY] == 1) safeDist = dist[nextX][nextY] <= safeDist ? dist[nextX][nextY] : safeDist;
			}
		}
	}
	
	static void initArr(int sizeN, int sizeM) {
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				isVisited[i][j] = false;
				dist[i][j] = 0;
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		space = new int[n][m];
		dist = new int[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(space[i][j] == 1) continue;
				safeDist = 2500;
				initArr(n, m);
				bfs(i, j, n, m);
				answer = safeDist >= answer ? safeDist : answer;
			}
		}
		System.out.println(answer);
	}
}