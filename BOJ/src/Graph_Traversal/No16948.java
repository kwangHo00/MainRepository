package Graph_Traversal;
//No16948_데스나이트_정답
import java.util.*;
import java.io.*;
public class No16948 {
	static int[][] board;
	static boolean[][] isVisited;
	static int[][] dist;
	static Queue<Pair> queue = new LinkedList<Pair>();
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static class Pair{
		int r;
		int c;
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static void moveKnight(int r1, int c1, int r2, int c2, int sizeN) {
		queue.add(new Pair(r1, c1));
		isVisited[r1][c1] = true;
		
		final int[] upDown = {-2, -2, 0, 0, 2, 2};
		final int[] leftRight = {-1, 1, -2, 2, -1, 1};
		
		while(!queue.isEmpty()) {
			int nowR = queue.peek().r;
			int nowC = queue.peek().c;
			queue.poll();
			for(int i = 0; i < 6; i++) {
				int tmpR = nowR + upDown[i];
				int tmpC = nowC + leftRight[i];
				if(tmpR < 0 || tmpR > sizeN - 1 || tmpC < 0 || tmpC > sizeN - 1) continue;
				if(tmpR == r2 && tmpC == c2) {
					list.add(dist[nowR][nowC] + 1);
					continue;
				}
				if(!isVisited[tmpR][tmpC]) {
					queue.add(new Pair(tmpR, tmpC));
					dist[tmpR][tmpC] = dist[nowR][nowC] + 1;
					isVisited[tmpR][tmpC] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		isVisited = new boolean[n][n];
		dist = new int[n][n];
		
		moveKnight(r1, c1, r2, c2, n);
		if(list.size() == 0) System.out.println(-1);
		else System.out.println(Collections.min(list));
	}
}