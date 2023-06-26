//No24445_알고리즘수업_너비우선탐색2_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No24445 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int sequence = 1;
	static int[] isVisited;
	
	static void bfs(int r) {
		isVisited[r] = sequence++;
		queue.add(r);
		
		while(!queue.isEmpty()) {
			int nextR = queue.poll();
			
			int listSize = list.get(nextR).size();
			for(int i = 0; i < listSize; i++) {
				if(isVisited[list.get(nextR).get(i)] == 0) {					
					isVisited[list.get(nextR).get(i)] = sequence++;
					queue.add(list.get(nextR).get(i));
				}
			}
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
			//내림차순 정렬
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		bfs(r);
		
		for(int i = 1; i <= n; i++) System.out.println(isVisited[i]);
	}
}