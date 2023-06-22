package Graph_Traversal;
//No14940_쉬운최단거리_정답
import java.util.*;
import java.io.*;

public class No14940 {
	static int map[][];
	static int dist[][];
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int a, int b, int sizeN, int sizeM) {
		queue.add(new Pair(a, b));
		isVisited[a][b] = true;
		
		while(!queue.isEmpty()) {
			int nowX = queue.peek().x;
			int nowY = queue.peek().y;
			queue.poll();
			
			final int[] upDown = {-1, 1, 0, 0};
			final int[] leftRight = {0, 0, -1, 1};
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + upDown[i];
				int nextY = nowY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
				if(map[nextX][nextY] == 1 && !isVisited[nextX][nextY]) {
					dist[nextX][nextY] = dist[nowX][nowY] + 1;
					queue.add(new Pair(nextX, nextY));
					isVisited[nextX][nextY] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int targetN = 0, targetM = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					targetN = i;
					targetM = j;
				}
			}
		}
		
		bfs(targetN, targetM, n, m);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !isVisited[i][j]) dist[i][j] = -1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int[] i : dist) {
			for(int j : i) {
				sb.append(j).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}