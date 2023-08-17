//No1697_숨바꼭질_정답	
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No1697 {
	static final int SIZE = 100_001;
	static int[] dist = new int[SIZE];
	static boolean[] isVisited = new boolean[SIZE];
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	static void bfs(int n, int k) {
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			if(currN == k) return;
			
			int[] move = {-1, 1, currN * 2 - currN};
			for(int i = 0; i < 3; i++) {
				int nextN = currN + move[i];
				if(nextN < 0 || nextN > SIZE - 1) continue;
				if(!isVisited[nextN]) {
					isVisited[nextN] = true;
					queue.add(nextN);
					dist[nextN] = dist[currN] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bfs(n, k);
		System.out.println(dist[k]);
	}
}