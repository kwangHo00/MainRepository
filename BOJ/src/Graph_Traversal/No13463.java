//No13463_Brexit_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No13463 {
	static boolean[] isVisited, leave;
	static int[] unionCnt, leaveCnt;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	static void bfs(int n) {
		isVisited[n] = true;
		leave[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			for(int nextN : list.get(currN)) {
				leaveCnt[nextN]++;
				if(!isVisited[nextN] && leaveCnt[nextN] * 2 >= unionCnt[nextN]) {
					isVisited[nextN] = true;
					leave[nextN] = true;
					queue.add(nextN);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[N + 1];
		leave = new boolean[N + 1];
		unionCnt = new int[N + 1];
		leaveCnt = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			unionCnt[i] = list.get(i).size();
		}
		
		bfs(L);
		System.out.println(leave[X] ? "leave" : "stay");
	}
}