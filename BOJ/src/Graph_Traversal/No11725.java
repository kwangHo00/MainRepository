//No11725_트리의부모찾기_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No11725 {
	static int[] sequence;
	static boolean[] isVisited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static void bfs(int n) {
		isVisited[n] = true;
		q.add(n);
		
		while(!q.isEmpty()) {
			int nowN = q.poll();
			int listSize = list.get(nowN).size();
			for(int i = 0; i < listSize; i++) {
				if(!isVisited[list.get(nowN).get(i)]) {
					isVisited[list.get(nowN).get(i)] = true;
					q.add(list.get(nowN).get(i));
					sequence[list.get(nowN).get(i)] = nowN;
				}
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		sequence = new int[n + 1];
		isVisited = new boolean[n + 1];
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		bfs(1);
		for(int i = 2; i <= n; i++) {
			System.out.println(sequence[i]);
		}
	}
}