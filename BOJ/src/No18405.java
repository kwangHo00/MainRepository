//No18405_경쟁적전염_다시 풀어보기_계속 시간초과
import java.util.*;
import java.io.*;

public class No18405 {
	static int[][] examiner;
	static boolean[][] isVisited;
	static ArrayList<ArrayList<Pair>> locationList = new ArrayList<ArrayList<Pair>>();
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void infect(Pair p, int virusNum, int examinerSize) {
		isVisited[p.x][p.y] = true;
		
		final int upDown[] = {-1, 1, 0, 0};
		final int leftRight[] = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int tempX = p.x + upDown[i];
			int tempY = p.y + leftRight[i];
			if(tempX < 0 || tempX > examinerSize || tempY < 0 || tempY > examinerSize) continue;
			if(examiner[tempX][tempY] == 0 && !isVisited[tempX][tempY]) {
				examiner[tempX][tempY] = virusNum;
				locationList.get(virusNum).add(new Pair(tempX, tempY));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		examiner = new int[n + 1][n + 1];
		isVisited = new boolean[n + 1][n + 1];
		
		for(int i = 0; i <= k; i++) {
			locationList.add(i, new ArrayList<Pair>());
		}
		
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n + 1; j++) {
				examiner[i][j] = Integer.parseInt(st.nextToken());
				locationList.get(examiner[i][j]).add(new Pair(i, j));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		while(s > 0) {
			for(int i = 1; i <= k; i++) {
				int listSize = locationList.get(i).size();
				for(int j = 0; j < listSize; j++) {
					if(isVisited[locationList.get(i).get(j).x][locationList.get(i).get(j).y]) continue;
					infect(locationList.get(i).get(j), i, n);
				}
			}
			s--;
		}
		System.out.println(examiner[x][y]);
	}
}