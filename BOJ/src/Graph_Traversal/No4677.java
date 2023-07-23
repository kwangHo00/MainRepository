//No4677_Oil Deposits_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No4677 {
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
	
	static void bfs(int a, int b, int sizeM, int sizeN) {
		final int[] upDown = {-1, -1, 0, 1, 1, 1, 0, -1};
		final int[] leftRight = {0, 1, 1, 1, 0, -1, -1, -1};
		
		isVisited[a][b] = true;
		queue.add(new Pair(a, b));
		
		while(!queue.isEmpty()) {
			int currA = queue.peek().a;
			int currB = queue.peek().b;
			queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nextA = currA + upDown[i];
				int nextB = currB + leftRight[i];
				if(nextA < 0 || nextA > sizeM - 1 || nextB < 0 || nextB > sizeN - 1) continue;
				if(map[nextA][nextB] == '@' && !isVisited[nextA][nextB]) {
					isVisited[nextA][nextB] = true;
					queue.add(new Pair(nextA, nextB));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n == 0) break;
			
			map = new char[m][n];
			isVisited = new boolean[m][n];
			
			for(int i = 0; i < m; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int answer = 0;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == '@' && !isVisited[i][j]) {
						bfs(i, j, m, n);
						answer += 1;
					}
				}
			}
			System.out.println(answer);
		}
	}
}