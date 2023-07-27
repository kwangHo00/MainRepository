//No25195_Yes or yes_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No25195 {
	static boolean[] isVisited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	static boolean bfs(int n) {
		if(isVisited[n]) return false ;
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			if(list.get(currN).size() == 0) return true;
			for(Integer i : list.get(currN)) {
				int nextN = i;
				if(!isVisited[nextN]) {
					isVisited[nextN] = true;
					queue.add(nextN);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
		}
		
		int s = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < s; i++) {
			int a = Integer.parseInt(st.nextToken());
			isVisited[a] = true;
		}
		
		System.out.println(bfs(1) ? "yes" : "Yes");
	}
}