//No2589_보물섬_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No2589 {
	static int max = 0;
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int n, int m, int sizeN, int sizeM, Queue<Pair> queue, boolean[][] isVisited, int[][] dist, char[][] map) {
		queue.add(new Pair(n, m));
		isVisited[n][m] = true;
		
		while(!queue.isEmpty()) {
			int nowN = queue.peek().x;
			int nowM = queue.peek().y;
			queue.poll();
			
			final int[] upDown = {-1, 1, 0, 0};
			final int[] leftRight = {0, 0, -1, 1};
			for(int i = 0; i < 4; i++) {
				int nextN = nowN + upDown[i];
				int nextM = nowM + leftRight[i];
				if(nextN < 0 || nextN > sizeN - 1 || nextM < 0 || nextM > sizeM - 1) continue;
				if(map[nextN][nextM] == 'L' && !isVisited[nextN][nextM]) {
					queue.add(new Pair(nextN, nextM));
					isVisited[nextN][nextM] = true;
					dist[nextN][nextM] = dist[nowN][nowM] + 1;
				}
			}
		}
	}
	
	static void initArr(boolean[][] isVisited, int[][] dist, int sizeN, int sizeM) {
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				dist[i][j] = 0;
				isVisited[i][j] = false;
			}
		}
	}
	
	static void checkMaxDist(int[][] dist, int sizeN, int sizeM) {
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				max = dist[i][j] >= max ? dist[i][j] : max;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[n][m];
		int[][] dist = new int[n][m];
		boolean[][] isVisited = new boolean[n][m];
		Queue<Pair> queue = new LinkedList<Pair>();
		ArrayList<Pair> list = new ArrayList<Pair>();
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'L') list.add(new Pair(i, j));
			}
		}
		
		int listSize = list.size();
		for(int i = 0; i < listSize; i++) {
			initArr(isVisited, dist, n, m);
			bfs(list.get(i).x, list.get(i).y, n, m, queue, isVisited, dist, map);
			checkMaxDist(dist, n, m);
		}
		
		System.out.println(max);
	}
}