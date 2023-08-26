//No25516_거리가 k이하인 트리 노드에서 사과 수확하기_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No25516 {
	static int answer = 0;
	static int[] dist, apple;
	static boolean[] isVisited;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	static void bfs(int n, int limit) {
		isVisited[n] = true;
		queue.add(n);
		
		if(dist[n] <= limit) answer += apple[n];
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			for(Integer nextN : list.get(currN)) {
				if(!isVisited[nextN]) {
					isVisited[nextN] = true;
					dist[nextN] = dist[currN] + 1;
					if(dist[nextN] <= limit) answer += apple[nextN];
					queue.add(nextN);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dist = new int[n];
		apple = new int[n];
		isVisited = new boolean[n];
		
		for(int i = 0; i < n; i++) list.add(new ArrayList<Integer>());
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) apple[i] = Integer.parseInt(st.nextToken());
		
		bfs(0, k);
		System.out.println(answer);
	}
}