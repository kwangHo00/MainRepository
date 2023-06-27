//No2206_벽부수고이동하기_다시 풀어보기
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No2206 {
	static char[][] map;
	static int[][] dist;
	static boolean[][] isVisited;
	static Queue<Pair> q = new LinkedList<Pair>();
	static ArrayList<Pair> list = new ArrayList<Pair>();
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void initArr(int sizeN, int sizeM) {
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				dist[i][j] = 1;
				isVisited[i][j] = false;
			}
		}
	}
	
	static void bfs(int a, int b, int sizeN, int sizeM) {
		isVisited[a][b] = true;
		q.add(new Pair(a, b));
		
		while(!q.isEmpty()) {
			int nowA = q.peek().x;
			int nowB = q.peek().y;
			q.poll();
			
			final int[] upDown = {-1, 1, 0, 0};
			final int[] leftRight = {0, 0, -1, 1};
			for(int i = 0; i < 4; i++) {
				int tmpA = nowA + upDown[i];
				int tmpB = nowB + leftRight[i];
				if(tmpA < 0 || tmpA > sizeN - 1 || tmpB < 0 || tmpB > sizeM - 1) continue;
				if(map[tmpA][tmpB] == '0' && !isVisited[tmpA][tmpB]) {
					isVisited[tmpA][tmpB] = true;
					q.add(new Pair(tmpA, tmpB));
					dist[tmpA][tmpB] = dist[nowA][nowB] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int minDist = 99999999;
		map = new char[n][m];
		isVisited = new boolean[n][m];
		dist = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		list.add(new Pair(0, 0));
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dist[i][j] = 1;
				if(map[i][j] == '1') list.add(new Pair(i, j));
			}
		}
		
		int listSize = list.size();
		for(int i = 0; i < listSize; i++) {
			map[list.get(i).x][list.get(i).y] = '0';
			bfs(0, 0, n, m);
			
			if(dist[n - 1][m - 1] != 1) minDist = Math.min(dist[n - 1][m - 1], minDist);
			map[list.get(i).x][list.get(i).y] = '1';
			initArr(n, m);
		}
		if(minDist == 99999999) System.out.println("-1");
		else System.out.println(minDist);
	}
}