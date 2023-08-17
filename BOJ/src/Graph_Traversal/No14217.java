//No14217_그래프 탐색_두번만에 정답 _1) 띄어쓰기 안붙여서 틀림
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No14217 {
	static class NodeInfo{
		int n;
		boolean isConnect = false;
		NodeInfo(int n, boolean isConnect){
			this.n = n;
			this.isConnect = isConnect;
		}
	}
	static ArrayList<ArrayList<NodeInfo>> list = new ArrayList<ArrayList<NodeInfo>>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	static boolean[] isVisited;
	static int[] dist;
	
	static void bfs(int n) {
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			for(NodeInfo next : list.get(currN)) {
				if(next.isConnect && !isVisited[next.n]) {
					isVisited[next.n] = true;
					queue.add(next.n);
					dist[next.n] = dist[currN] + 1;
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
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(j == 0) {
					list.get(i).add(new NodeInfo(0, false));
					continue;
				}
				list.get(i).add(new NodeInfo(j, false));
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).get(b).isConnect = true;
			list.get(b).get(a).isConnect = true;
		}
		
		int q = Integer.parseInt(br.readLine());
		while(q-- > 0) {
			isVisited = new boolean[n + 1];
			dist = new int[n + 1];
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				list.get(x).get(y).isConnect = true;
				list.get(y).get(x).isConnect = true;
			} else if(a == 2) {
				list.get(x).get(y).isConnect = false;
				list.get(y).get(x).isConnect = false;
			}
			bfs(1);
			
			for(int i = 1; i <= n; i++) System.out.print(isVisited[i] ? dist[i] + " " : "-1 ");
			System.out.println();
		}
	}
}