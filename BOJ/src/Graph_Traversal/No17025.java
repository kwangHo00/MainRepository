//No17025_Ice Perimeter_두번만에 정답 _ 같은 크기의 조각이 있을 경우 가장 작은 둘레를 구하는 로직을 빼먹음
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No17025 {
	static int answerArea = 0, answerPerimeter = 0;
	static final int[] upDown = {-1, 1, 0, 0};
	static final int[] leftRight = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int x, int y, int sizeN) {
		int area = 0, perimeter = 0;
		
		isVisited[x][y] = true;
		area += 1;
		perimeter += getPerimeter(x, y, sizeN);
		queue.add(new Pair(x, y));
		
		while(!queue.isEmpty()) {
			int currX = queue.peek().x;
			int currY = queue.peek().y;
			queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextX = currX + upDown[i];
				int nextY = currY + leftRight[i];
				if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeN - 1) continue;
				if(map[nextX][nextY] == '#' && !isVisited[nextX][nextY]) {
					isVisited[nextX][nextY] = true;
					area += 1;
					perimeter += getPerimeter(nextX, nextY, sizeN);
					queue.add(new Pair(nextX, nextY));
				}
			}
		}
		
		if(area > answerArea) { 
			answerArea = area;
			answerPerimeter = perimeter;
		}
		else if(area == answerArea) {
			answerArea = area;
			answerPerimeter = Math.min(answerPerimeter, perimeter);
		}
	}
	
	static int getPerimeter(int x, int y, int sizeN) {
		int tmpPerimeter = 0;
		for(int i = 0; i < 4; i++) {
			int sideX = x + upDown[i];
			int sideY = y + leftRight[i];
			
			if(sideX < 0 || sideX > sizeN - 1 || sideY  < 0 || sideY > sizeN - 1) {
				tmpPerimeter += 1;
				continue;
			}
			if(map[sideX][sideY] == '.') tmpPerimeter += 1;
		}
		return tmpPerimeter;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		isVisited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == '#' && !isVisited[i][j]) {
					bfs(i, j , n);
				}
			}
		}
		System.out.println(answerArea + " " + answerPerimeter);
	}
}