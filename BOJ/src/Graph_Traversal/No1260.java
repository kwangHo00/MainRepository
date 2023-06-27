//No1260_DFS와BFS_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No1260 {
	static boolean[] isVisited;
	static ArrayList<Integer> sequenceList = new ArrayList<Integer>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static void dfs(int n) {
		isVisited[n] = true;
		sequenceList.add(n);
		int listSize = list.get(n).size();
		for(int i = 0; i < listSize; i++) {
			if(!isVisited[list.get(n).get(i)]) dfs(list.get(n).get(i));
		}
	}
	
	static void bfs(int n) {
		isVisited[n] = true;
		q.add(n);
		sequenceList.add(n);
		while(!q.isEmpty()) {
			int curN = q.poll();
			int listSize = list.get(curN).size();
			for(int i = 0; i < listSize; i++) {
				if(!isVisited[list.get(curN).get(i)]) {
					isVisited[list.get(curN).get(i)] = true;
					q.add(list.get(curN).get(i));
					sequenceList.add(list.get(curN).get(i));
				}
			}
		}
	}
	
	static void initIsVisitedFalse(int n) {
		for(int i = 0; i <= n; i++) {
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		isVisited = new boolean[n + 1];
		
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
		
		dfs(v);
		for(int i : sequenceList) System.out.print(i + " ");
		System.out.println();
		initIsVisitedFalse(n);
		sequenceList.clear();
		bfs(v);
		for(int i : sequenceList) System.out.print(i + " ");
	}
}