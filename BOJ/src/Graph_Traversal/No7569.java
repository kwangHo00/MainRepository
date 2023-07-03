//No7569_토마토_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No7569 {
	static int answer = 0;
	static int[][][] box, days;
	static Queue<Pair> q = new LinkedList<Pair>();
	static class Pair{
		int n, m, h;
		Pair(int n, int m, int h){
			this.n = n;
			this.m = m;
			this.h = h;
		}
	}
	
	static void bfs(int sizeN, int sizeM, int sizeH) {
		final int[] upDown = {1, -1, 0, 0, 0, 0}; //상 하 동 서 남 북
		final int[] leftRight = {0, 0, 1, -1, 0, 0};
		final int[] fowardBack = {0, 0, 0, 0, 1, -1};
		
		while(!q.isEmpty()) {
			int currN = q.peek().n;
			int currM = q.peek().m;
			int currH = q.peek().h;
			q.poll();
			
			for(int i = 0; i < 6; i++) {
				int nextN = currN + fowardBack[i];
				int nextM = currM + leftRight[i];
				int nextH = currH + upDown[i];
				
				if(nextN < 0 || nextN > sizeN - 1 || nextM < 0 || nextM > sizeM - 1 || nextH < 0 || nextH > sizeH - 1) continue;
				if(box[nextH][nextN][nextM] == 0 && days[nextH][nextN][nextM] == 0) {
					box[nextH][nextN][nextM] = 1;
					days[nextH][nextN][nextM] = days[currH][currN][currM] + 1;
					q.add(new Pair(nextN, nextM, nextH));
					
					answer = Math.max(days[nextH][nextN][nextM], answer);
				}
			}
		}
		
	}
	
	static boolean isAllRipe(int sizeN, int sizeM, int sizeH) {
		for(int i = 0; i < sizeH; i++) {
			for(int j = 0; j < sizeN; j++) {
				for(int k = 0; k < sizeM; k++) {
					if(box[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken()); //가로
		int n = Integer.parseInt(st.nextToken()); //세로
		int h = Integer.parseInt(st.nextToken()); //높이
		box = new int[h][n][m];
		days = new int[h][n][m];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) q.add(new Pair(j, k, i));
				}
			}
		}
		
		bfs(n, m, h);
		if(isAllRipe(n, m, h)) System.out.println(answer);
		else System.out.println("-1");
	}
}