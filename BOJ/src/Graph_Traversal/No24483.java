//No24483_알고리즘수업-깊이우선탐색5_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No24483 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static boolean[] isVisited;
	static long[] depth, sequenceArr;
	static int sequence = 1;
	
	static void dfs(int s) {
		isVisited[s] = true;
		sequenceArr[s] = sequence++;
		
		int listSize = list.get(s).size();
		for(int i = 0; i < listSize; i++) {
			int nextNode = list.get(s).get(i);
			
			if(!isVisited[nextNode]) {
				depth[nextNode] = depth[s] + 1;
				dfs(nextNode);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[n + 1];
		depth = new long[n + 1];
		sequenceArr = new long[n + 1];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
			depth[i] = -1;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(list.get(i));
		}
		
		depth[r] = 0;
		dfs(r);
		
		long answer = 0;
		for(int i = 1; i <= n; i++) {
			answer += depth[i] * sequenceArr[i];
		}
		System.out.println(answer);
	}
}