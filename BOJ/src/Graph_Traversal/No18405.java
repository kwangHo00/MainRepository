package Graph_Traversal;
//No18405_경쟁적전염_7번만에 정답_NullPointer 오류 때문에 계속 틀림_
import java.util.*;
import java.io.*;

public class No18405 {
	static int[][] examiner;
	static boolean[][] isVisited;
	static Queue<Pair> q = new LinkedList<Pair>(); // 증식한 위치를 임의 저장하는 큐
	static PriorityQueue<Pair> pq = new PriorityQueue<Pair>(); // 바이러스 번호대로 탐색할 위치를 저장하는 큐
	
	static class Pair implements Comparable<Pair>{
		int a, b, virus;
		Pair(int a, int b, int virus){
			this.a = a;
			this.b = b;
			this.virus = virus;
		}
		
		@Override
		public int compareTo(Pair target) {
			return this.virus >= target.virus ? 1 : -1;
		}
	}
	
	static void bfs(int a, int b, int sizeN) {
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		
		isVisited[a][b] = true;
		
		while(!pq.isEmpty()) {
			int currA = pq.peek().a;
			int currB = pq.peek().b;
			int virusNum = pq.peek().virus;
			pq.poll();
			for(int i = 0; i < 4; i++) {
				int nextA = currA + upDown[i];
				int nextB = currB + leftRight[i];
				if(nextA < 0 || nextA > sizeN - 1 || nextB < 0 || nextB > sizeN - 1) continue;
				if(examiner[nextA][nextB] == 0 && !isVisited[nextA][nextB]) {
					isVisited[nextA][nextB] = true;
					examiner[nextA][nextB] = virusNum;
					q.add(new Pair(nextA, nextB, examiner[nextA][nextB]));
				}
			}
		}
		
		while(!q.isEmpty()) {
			pq.add(new Pair(q.peek().a, q.peek().b, q.peek().virus));
			q.poll();
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
		examiner = new int[n][n];
		isVisited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				examiner[i][j] = Integer.parseInt(st.nextToken());
				if(examiner[i][j] != 0) pq.add(new Pair(i, j, examiner[i][j]));
			}
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		while(s-- > 0) {
			if(pq.isEmpty()) break;
			bfs(pq.peek().a, pq.peek().b, n);
		}
		System.out.println(examiner[x - 1][y - 1]);
	}
}