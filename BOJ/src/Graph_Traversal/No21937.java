//No21937_작업_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No21937 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static boolean[] isVisited;
	static int answer = -1;
	
	static void dfs(int n) {
		isVisited[n] = true;
		answer += 1;
		
		int listSize = list.get(n).size();
		for(int i = 0; i < listSize; i++) {
			int nextN = list.get(n).get(i);
			if(!isVisited[nextN]) dfs(nextN);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}
		
		int s = Integer.parseInt(br.readLine());
		
		dfs(s);
		System.out.println(answer);
	}
}