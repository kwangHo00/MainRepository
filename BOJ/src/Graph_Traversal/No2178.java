package Graph_Traversal;
//No2178_미로탐색_정답
import java.util.*;
import java.io.*;
public class No2178 {
	static char[][] maze;
	static boolean[][] isVisited;
	static int[][] length;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void findExit(int a, int b, int sizeN, int sizeM) {
		queue.add(new Pair(a, b));
		isVisited[a][b] = true;
		
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			for(int i = 0; i < 4; i++) {
				int tmpA = x + upDown[i];
				int tmpB = y + leftRight[i];
				if(tmpA < 0 || tmpA > sizeN - 1 || tmpB < 0 || tmpB > sizeM - 1) continue;
				if(maze[tmpA][tmpB] == '1' && !isVisited[tmpA][tmpB]) {
					queue.add(new Pair(tmpA, tmpB));
					length[tmpA][tmpB] = length[x][y] + 1;
					isVisited[tmpA][tmpB] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		maze = new char[n][m];
		isVisited = new boolean[n][m];
		length = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			maze[i] = br.readLine().toCharArray();
		}
		
		length[0][0] = 1;
		findExit(0, 0, n, m);
		System.out.println(length[n - 1][m - 1]);
	}
}