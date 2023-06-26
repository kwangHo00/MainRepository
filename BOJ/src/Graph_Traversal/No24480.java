//No24480_3번만에 정답_방문 여부 확인하는걸 잘못 짰음
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No24480 {
	static boolean[] isVisited;
	static int[] arr;
	static int sequence = 1;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	static void dfs(int s) {
		isVisited[s] = true;
		arr[s] = sequence++;
		
		int listSize = list.get(s).size();
		for(int i = 0; i < listSize; i++) {
			if(!isVisited[list.get(s).get(i)]) dfs(list.get(s).get(i));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		isVisited = new boolean[n + 1];
		arr = new int[n + 1];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		
		dfs(r);
		
		for(int i = 1; i <= n; i++) {
			System.out.println(arr[i]);
		}
	}
}