//No16509_장군_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No16509 {
	static int[][] board = new int[10][9];
	static int[][] dist = new int[10][9];
	static boolean[][] isVisited = new boolean[10][9];
	static Queue<Pair> queue = new LinkedList<Pair>();
	
	static class Pair{
		int a, b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
	static void bfs(int a, int b, int e1, int e2) {
		final int[] upDown = {-3, -2, 2, 3, 3, 2, -2, -3};
		final int[] leftRight = {2, 3, 3, 2, -2, -3, -3, -2};
		final int[][] route = {{1, -1}, {1, -1}, {-1, -1}, {-1, -1}, {-1, 1}, {-1, 1}, {1, 1}, {1, 1}};
		
		isVisited[a][b] = true;
		queue.add(new Pair(a, b));
		
		while(!queue.isEmpty()) {
			int currA = queue.peek().a;
			int currB = queue.peek().b;
			queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nextA = currA + upDown[i];	
				int nextB = currB + leftRight[i];
				if(nextA < 0 || nextA > 9 || nextB < 0 || nextB > 8) continue;
				if((nextA + route[i][0] == e1 && nextB + route[i][1] == e2) ||
					(nextA + route[i][0] * 2 == e1 && nextB + route[i][1] * 2 == e2)) continue;
				if(!isVisited[nextA][nextB]) {
					dist[nextA][nextB] = dist[currA][currB] + 1;
					isVisited[nextA][nextB] = true;
					queue.add(new Pair(nextA, nextB));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R1 = Integer.parseInt(st.nextToken());
		int C1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int R2 = Integer.parseInt(st.nextToken());
		int C2 = Integer.parseInt(st.nextToken());
		
		bfs(R1, C1, R2, C2);
		System.out.println(dist[R2][C2]);
	}
}