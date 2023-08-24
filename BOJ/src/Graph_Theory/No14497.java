//No14497_주난의 난_세번만에 정답 _ 0인 부분을 먼저 탐색해줘야 함
//0인 부분이 먼저 탐색되도록 0의 위치를 addFirst로 앞에 추가해주고 1인 부분은 나중에 탐색되도록
//addLast로 맨 뒤에 추가해줌
package Graph_Theory;

import java.io.*;
import java.util.*;

public class No14497 {
	static final int[] upDown = {-1, 1, 0, 0};
	static final int[] leftRight = {0, 0, -1, 1};
	static int[][] dist;
	static char[][] map;
	static boolean[][] isVisited;
	static Deque<Pair> deque = new LinkedList<Pair>();
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(int x, int y, int sizeN, int sizeM) {
		isVisited[x][y] = true;
		deque.add(new Pair(x, y));
		
		while(!deque.isEmpty()) {
			int currX = deque.peek().x;
			int currY = deque.peek().y;
			deque.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = currX + upDown[i];
				int nextY = currY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
				if(map[nextX][nextY] == '0' && !isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
					dist[nextX][nextY] = dist[currX][currY] + 0;
					deque.addFirst(new Pair(nextX, nextY));
				}
				if((map[nextX][nextY] == '1' || map[nextX][nextY] == '#') && !isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
					dist[nextX][nextY] = dist[currX][currY] + 1;
					deque.addLast(new Pair(nextX, nextY));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y1 = Integer.parseInt(st.nextToken()) - 1;
		int x2 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;
		
		dist = new int[n][m];
		map = new char[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		bfs(x1, y1, n, m);
		System.out.println(dist[x2][y2]);
	}
}