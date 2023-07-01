//No6593_상범빌딩_정답_두번만에 정답_각 층별 사이의 빈칸을 br.readLine()이 아니라 System.out.println()으로 처리해서 틀림
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No6593 {
	static char[][][] building;
	static int[][][] dist;
	static Queue<Pair> q = new LinkedList<Pair>();
	static class Pair{
		int l, r, c;
		Pair(int l, int r, int c){
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}
	
	static void bfs(int l, int r, int c, int sizeL, int sizeR, int sizeC) {
		final int[] upDown = {1, -1 , 0, 0, 0, 0}; //상 하 동 서 남 북
		final int[] leftRight = {0, 0, 1, -1, 0, 0};
		final int[] fowardBack = {0, 0, 0, 0, 1, -1};
		
		q.add(new Pair(l, r, c));
		
		while(!q.isEmpty()) {
			int currL = q.peek().l;
			int currR = q.peek().r;
			int currC = q.peek().c;
			q.poll();
			
			for(int p = 0; p < 6; p++) {
				int nextL = currL + upDown[p];
				int nextR = currR + fowardBack[p];
				int nextC = currC + leftRight[p];
				if(nextL < 0 || nextL > sizeL - 1 || nextR < 0 || nextR > sizeR - 1 || nextC < 0 || nextC > sizeC - 1) continue;
				if((building[nextL][nextR][nextC] == '.' || building[nextL][nextR][nextC] == 'E') && dist[nextL][nextR][nextC] == 0) {
					dist[nextL][nextR][nextC] = dist[currL][currR][currC] + 1;
					q.add(new Pair(nextL, nextR, nextC));
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) break;
			
			building = new char[L][R][C];
			dist = new int[L][R][C];
			
			int s_L = 0, s_R = 0, s_C = 0, e_L = 0, e_R = 0, e_C = 0;
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j ++) {
					building[i][j] = br.readLine().toCharArray();
					for(int k = 0; k < C; k++) {
						if(building[i][j][k] == 'S') {
							s_L = i;
							s_R = j;
							s_C = k;
						}else if(building[i][j][k] == 'E') {
							e_L = i;
							e_R = j;
							e_C = k;
						}
					}
				}
				br.readLine();
			}
			
			bfs(s_L, s_R, s_C, L, R, C);
			if(dist[e_L][e_R][e_C] != 0) System.out.println("Escaped in " + dist[e_L][e_R][e_C] + " minute(s).");
			else System.out.println("Trapped!");
		}
	}
}