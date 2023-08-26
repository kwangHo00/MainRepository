//No1167_트리의 지름_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No1167 {
	static ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	static boolean[] isVisited;
	static int[] dist;
	static int[] farNode = {0, -1}; //거리, 노드번호
	
	static class NodeInfo{
		int n, c;
		NodeInfo(int n, int c){
			this.n = n; 
			this.c = c;
		}
	}
	
	static void bfs(int n, int size) {
		isVisited = new boolean[size + 1];
		dist = new int[size + 1];
		
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			for(NodeInfo next : list.get(currN)) {
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
		
		for(int i = 0; i <= n; i++) list.add(new ArrayList<NodeInfo>());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			while(true) {
				int b = Integer.parseInt(st.nextToken());
				if(b == -1) break;
				int c = Integer.parseInt(st.nextToken());
				list.get(a).add(new NodeInfo(b, c));
				list.get(b).add(new NodeInfo(a, c));
			}
		}
		
		bfs(1, n);
		bfs(farNode[1], n);
		System.out.println(farNode[0]);
	}
}