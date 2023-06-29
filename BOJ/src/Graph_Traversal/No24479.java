//No24479_알고리즘수업-깊이우선탐색1_3번만에 정답_첫번째 두번째 제출은 그냥 깊이우선탐색 개념 모르고 막 푼거라 틀림
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No24479 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static int[] isVisited;
	static int sequence = 1;
	
	static void dfs(int n) {
		isVisited[n] = sequence++;
		
		int listSize = list.get(n).size();
		for(int i = 0; i < listSize; i++) {
			int nextNode = list.get(n).get(i);
			if(isVisited[nextNode] == 0) dfs(nextNode);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		isVisited = new int[n + 1];
		
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
			Collections.sort(list.get(i));
		}
		
		dfs(r);
		for(int i = 1; i <= n; i++) {
			System.out.println(isVisited[i]);
		}
	}
}