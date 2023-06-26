//No2644_촌수계산_두번째만에 정답_촌수 업데이트하는 로직을 잘못 짰음
package Graph_Traversal;

import java.util.*;
import java.io.*;
public class No2644 {
	static boolean[] isVisited;
	static int[] relation;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	static void bfs(int a, int b) {
		isVisited[a] = true;
		queue.add(a);
		if(a == b) return;
		while(!queue.isEmpty()) {
			int tmpA = queue.poll();
			for(int i = 0; i < list.get(tmpA).size(); i++) {
				if(!isVisited[list.get(tmpA).get(i)]) {					
					isVisited[list.get(tmpA).get(i)] = true;
					queue.add(list.get(tmpA).get(i));
					relation[list.get(tmpA).get(i)] = relation[tmpA] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		isVisited = new boolean[n + 1];
		relation = new int[n + 1];
		
		for(int i = 0; i <= n; i++	) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(list.get(i));
		}
			
		bfs(a, b);
		if(!isVisited[b]) System.out.println("-1");
		else System.out.println(relation[b]);
	}
}