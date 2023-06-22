package Graph_Traversal;
//No7576_토마토_정답
import java.util.*;
import java.io.*;
public class No7576 {
	static int[][] tomato;
	static int[][] cntDays;
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int sizeN, int sizeM) {
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		while(!queue.isEmpty()) {
			int nowX = queue.peek().x;
			int nowY = queue.peek().y;
			isVisited[nowX][nowY] = true;
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + upDown[i];
				int nextY = nowY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
				if(tomato[nextX][nextY] == 0 && !isVisited[nextX][nextY]) {
					tomato[nextX][nextY] = 1;
					cntDays[nextX][nextY] = cntDays[nowX][nowY] + 1;
					queue.add(new Pair(nextX, nextY));
				}
			}
		}
	}
	
	static int getMinDays(int sizeN, int sizeM) {
		int min = 0;
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				if(tomato[i][j] == 0 && cntDays[i][j] == 0) return -1;
				min = cntDays[i][j] >= min ? cntDays[i][j] : min;
			}
		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		tomato = new int[n][m];
		cntDays = new int[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] == 1) queue.add(new Pair(i, j));
			}
		}
		
		bfs(n, m);
		System.out.println(getMinDays(n, m));
	}
}