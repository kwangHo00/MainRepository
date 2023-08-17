//No1240_노드사이의 거리_두번만에 정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No1240 {
	static class NodeInfo{
		int n, c;
		NodeInfo(int n, int c){
			this.n = n;
			this.c = c;
		}
	}
	
	static boolean[] isVisited;
	static int[] dist;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
	
	static void bfs(int n) {
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			for(NodeInfo i : list.get(currN)) {
				NodeInfo next = i;
				if(!isVisited[next.n]) {
					isVisited[next.n] = true;
					queue.add(next.n);
					dist[next.n] = dist[currN] + next.c;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<NodeInfo>());
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new NodeInfo(b, c));
			list.get(b).add(new NodeInfo(a, c));
		}
		
		while(m-- > 0) {
			isVisited = new boolean[n + 1];
			dist = new int[n + 1];
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			bfs(x);
			System.out.println(dist[y]);
		}
	}
}