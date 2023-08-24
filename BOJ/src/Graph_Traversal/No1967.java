//No1967_트리의 지름_정답 _ 트리의 지름 구하는 방법
//루트 노드에서 가장 먼 노드 탐색 -> 가장 먼 노드에서 다시 가장 먼 노드까지의 거리 구하기
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No1967 {
	static int[] dist;
	static int[] farNode;
	static boolean[] isVisited;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static ArrayList<ArrayList<Pair>> list = new ArrayList<ArrayList<Pair>>();
	
	static class Pair{
		int n, c;
		Pair(int n, int c){
			this.n = n; 
			this.c = c;
		}
	}
	
	static void bfs(int n, int size) {
		dist = new int[size + 1];
		isVisited = new boolean[size + 1];
		farNode = new int[] {0, -1};
		
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			for(Pair next : list.get(currN)) {
				if(!isVisited[next.n]) {
					isVisited[next.n] = true;
					dist[next.n] = dist[currN] + next.c;
					if(dist[next.n] > farNode[0]) {
						farNode[0] = dist[next.n];
						farNode[1] = next.n;
					}
					queue.add(next.n);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) list.add(new ArrayList<Pair>());
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Pair(b, c));
			list.get(b).add(new Pair(a, c));
		}
		
		if(n == 1) System.out.println("0");
		else {
			bfs(1, n);
			bfs(farNode[1], n);
			System.out.println(farNode[0]);
		}
	}
}