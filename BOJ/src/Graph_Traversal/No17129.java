//No17129_윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No17129 {
	static int[][] dist;
	static char[][] map;
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	
	static class Pair{
		int a, b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
	static void bfs(int a, int b, int sizeN, int sizeM) {
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		
		isVisited[a][b] = true;
		queue.add(new Pair(a, b));
		
		while(!queue.isEmpty()) {
			int currA = queue.peek().a;
			int currB = queue.peek().b;
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextA = currA + upDown[i];
				int nextB = currB + leftRight[i];
				if(nextA < 0 || nextA > sizeN - 1 || nextB < 0 || nextB > sizeM - 1) continue;
				if(map[nextA][nextB] != '1' && !isVisited[nextA][nextB]) {
					isVisited[nextA][nextB] = true;
					dist[nextA][nextB] = dist[currA][currB] + 1;
					queue.add(new Pair(nextA, nextB));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		dist = new int[n][m];
		map = new char[n][m];
		isVisited = new boolean[n][m];
		
		int s1 = -1, s2 = -1;
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '2') {
					s1 = i;
					s2 = j;
				}
			}
		}
		
		bfs(s1, s2, n, m);
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] != '1' && map[i][j] != '0' && map[i][j] != '2' && dist[i][j] != 0) {
					answer = dist[i][j] < answer ? dist[i][j] : answer;
				}
			}
		}
		
		if(answer == Integer.MAX_VALUE) System.out.println("NIE");
		else System.out.println("TAK" + '\n' + answer);
	}
}