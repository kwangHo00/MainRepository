//No18405_경쟁적전염_다시 풀어보기
import java.util.*;
import java.io.*;

public class No18405 {
	static int[][] examiner;
	static boolean[][] isVisited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	static void increaseVirus(int[] a, int num, int sizeN) {
		isVisited[a[0]][a[1]] = true;
		queue.poll();
		
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			int[] tmp = new int[2];
			tmp[0] = a[0] + upDown[i];
			tmp[1] = a[1] + leftRight[i];
			
			if(tmp[0] < 1 || tmp[0] > sizeN || tmp[1] < 1 || tmp[1] > sizeN) continue;
			if(examiner[tmp[0]][tmp[1]] == 0 && !isVisited[tmp[0]][tmp[1]]) {
				examiner[tmp[0]][tmp[1]] = num;
				queue.add(tmp);
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
		ArrayList<Integer> virusNum = new ArrayList<Integer>();
		int[] virusXY = new int[2];
		
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n + 1; j++) {
				examiner[i][j] = Integer.parseInt(st.nextToken());
				if (examiner[i][j] != 0 && !virusNum.contains(examiner[i][j])) virusNum.add(examiner[i][j]);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		Collections.sort(virusNum);
		
		for(Integer p : virusNum) {
			for(int i = 1; i < n + 1; i++) {
				for(int j = 1; j < n + 1; j++) {
					if(examiner[i][j] == p) {
						virusXY = new int[2];
						virusXY[0] = i;
						virusXY[1] = j;
						queue.add(virusXY);
					}
				}
			}
		}
		
		while(s > 0) {
			for(Integer i : virusNum) {
				increaseVirus(queue.peek(), i, n);
			}
			s--;
		}
		System.out.println(examiner[x][y]);
	}
}