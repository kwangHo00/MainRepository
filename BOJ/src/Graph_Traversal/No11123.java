//No11123_양한마리..양두마리.._정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No11123 {
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

	static void bfs(int a, int b, int sizeH, int sizeW) {
		isVisited[a][b] = true;
		queue.add(new Pair(a, b));
		
		while(!queue.isEmpty()) {
			int nowA = queue.peek().a;
			int nowB = queue.peek().b;
			queue.poll();
			
			final int[] upDown = {-1, 1, 0, 0};
			final int[] leftRight = {0, 0, -1, 1};
			
			for(int i = 0; i < 4; i++) {
				int nextA = nowA + upDown[i];
				int nextB = nowB + leftRight[i];
				if(nextA < 0 || nextA > sizeH - 1 || nextB < 0 || nextB > sizeW - 1) continue;
				if(map[nextA][nextB] == '#' && !isVisited[nextA][nextB]) {
					isVisited[nextA][nextB] = true;
					queue.add(new Pair(nextA, nextB));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			isVisited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int answer = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == '#' && !isVisited[i][j]) {
						bfs(i, j, h, w);
						answer += 1;
					}
				}
			}
			System.out.println(answer);
		}
	}
}