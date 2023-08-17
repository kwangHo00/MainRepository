//No12761_돌다리_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No12761 {
	static final int size = 100_001;
	static int a, b, n, m;
	static int[] dist = new int[size];
	static boolean[] isVisited = new boolean[size];
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	static void bfs() {
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			n = queue.poll();
			if(n == m) return;
			
			for(int i = 0; i < 8; i++) {
				final int[] move = {-1, 1, a, -a, b, -b, a * n - n, b * n - n};
				int nextN = n + move[i];
				
				if(nextN < 0 || nextN > size - 1) continue;
				if(!isVisited[nextN]) {
					dist[nextN] = dist[n] + 1;
					isVisited[nextN] = true;
					queue.add(nextN);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(dist[m]);
	}
}