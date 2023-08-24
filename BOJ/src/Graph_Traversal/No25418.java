//No25418_정수a를 k로 만들기_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No25418 {
	static int[] num, dist;
	static boolean[] isVisited;
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	static void bfs(int n, int size) {
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			int[] calculate = {1, currN * 2 - currN};
			for(int i = 0; i < 2; i++) {
				int nextN = currN + calculate[i];
				if(nextN > size) continue;
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

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		num = new int[b + 1];
		dist = new int[b + 1];
		isVisited = new boolean[b + 1];
		
		bfs(a, b);
		System.out.println(dist[b]);
	}
}