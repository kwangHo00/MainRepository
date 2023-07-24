//No4993_Red and Black_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No4993 {
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
	
	static int bfs(int a, int b, int sizeH, int sizeW) {
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		int answer = 1;
		
		isVisited[a][b] = true;
		queue.add(new Pair(a, b));
		
		while(!queue.isEmpty()) {
			int currA = queue.peek().a;
			int currB = queue.peek().b;
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextA = currA + upDown[i];
				int nextB = currB + leftRight[i];
				if(nextA < 0 || nextA > sizeH - 1 || nextB < 0 || nextB > sizeW - 1) continue;
				if(map[nextA][nextB] == '.' && !isVisited[nextA][nextB]) {
					isVisited[nextA][nextB] = true;
					answer += 1;
					queue.add(new Pair(nextA, nextB));
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new char[h][w];
			isVisited = new boolean[h][w];
			
			int a = -1, b = -1;
			for(int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < w; j++) {
					if(map[i][j] == '@') {
						a = i;
						b = j;
					}
				}
			}
			
			System.out.println(bfs(a, b, h, w));
		}
	}
}