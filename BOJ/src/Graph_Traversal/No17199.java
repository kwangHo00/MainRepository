//No17199_Milk Factory_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No17199 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	static boolean[] isVisited;

	static boolean bfs(int n, int size) {
		isVisited = new boolean[size + 1];
		isVisited[n] = true;
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int currN = queue.poll();
			for(Integer nextN : list.get(currN)) {
				if(!isVisited[nextN]) {
					isVisited[nextN] = true;
					queue.add(nextN);
				}
			}
		}
		
		for(int i = 1; i <= size; i++) if(!isVisited[i]) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}
		
		int answer = -1;
		for(int i = 1; i <= n; i++) {
			if(bfs(i, n)) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}