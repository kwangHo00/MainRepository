package Graph_Traversal;
//No17836_공주님을 구해라_두번째만에 정답
import java.util.*;
import java.io.*;
public class No17836 {
	static int[][] castle;
	static int[][] dist1;
	static int[][] dist2;
	static boolean[][] isVisited;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static final int[] upDown = {-1, 1, 0, 0};
	static final int[] leftRight = {0, 0, -1, 1};
	static int gramX, gramY;
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void moveWithOutGram(int a, int b, int sizeN, int sizeM) {
		queue.add(new Pair(a, b));
		isVisited[a][b] = true;
		while(!queue.isEmpty()) {
			int nowX = queue.peek().x;
			int nowY = queue.peek().y;
			queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + upDown[i];
				int nextY = nowY + leftRight[i];
				if(nextX > sizeN - 1 || nextX < 0 || nextY > sizeM - 1 || nextY < 0) continue;
				if((castle[nextX][nextY] == 0 || castle[nextX][nextY] == 2) && !isVisited[nextX][nextY]) {
					queue.add(new Pair(nextX, nextY));
					isVisited[nextX][nextY] = true;
					dist1[nextX][nextY] = dist1[nowX][nowY] + 1;
				}
			}
		}
	}
	
	static void moveWithGram(int a, int b, int sizeN, int sizeM) {
		queue.add(new Pair(a, b));
		isVisited[a][b] = true;
		while(!queue.isEmpty()) {
			int nowX = queue.peek().x;
			int nowY = queue.peek().y;
			queue.poll();
			if(castle[nowX][nowY] == 2) {
				gramX = nowX; gramY = nowY;
				break;
			}
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + upDown[i];
				int nextY = nowY + leftRight[i];
				if(nextX > sizeN - 1 || nextX < 0 || nextY > sizeM - 1 || nextY < 0) continue;
				if((castle[nextX][nextY] == 0 || castle[nextX][nextY] == 2) && !isVisited[nextX][nextY]) {
					queue.add(new Pair(nextX, nextY));
					isVisited[nextX][nextY] = true;
					dist2[nextX][nextY] = dist2[nowX][nowY] + 1;
				}
			}
		}
		
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				if(i == gramX && j == gramY) continue;
				dist2[i][j] = 0;
			}
		}
		if(gramX == 0 && gramY == 0) return;
		initIsVisitedArrFalse(sizeN, sizeM);
		queue.clear();
		queue.add(new Pair(gramX, gramY));
		while(!queue.isEmpty()) {
			int nowX = queue.peek().x;
			int nowY = queue.peek().y;
			queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + upDown[i];
				int nextY = nowY + leftRight[i];
				if(nextX > sizeN - 1 || nextX < 0 || nextY > sizeM - 1 || nextY < 0) continue;
				if((castle[nextX][nextY] == 0 || castle[nextX][nextY] == 1) && !isVisited[nextX][nextY]) {
					queue.add(new Pair(nextX, nextY));
					isVisited[nextX][nextY] = true;
					dist2[nextX][nextY] = dist2[nowX][nowY] + 1;
				}
			}
		}
	}
	
	static void initIsVisitedArrFalse(int sizeN, int sizeM) {
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				isVisited[i][j] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		castle = new int[n][m];
		dist1 = new int[n][m];
		dist2 = new int[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		moveWithOutGram(0, 0, n, m);
		initIsVisitedArrFalse(n, m);
		moveWithGram(0, 0, n, m);
		
		int minTime = 0;
		if(dist1[n - 1][m - 1] == 0 || dist2[n - 1][m - 1] == 0) minTime = Math.max(dist1[n - 1][m - 1], dist2[n - 1][m - 1]);
		else minTime = Math.min(dist1[n - 1][m - 1], dist2[n - 1][m - 1]);
		
		if(minTime == 0 || minTime > t) System.out.println("Fail");
		else System.out.println(minTime);
	}
}