//No18352_특정거리의도시찾기_정답
package Dijkstra;

import java.io.*;
import java.util.*;

public class No18352 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		final int INF = Integer.MAX_VALUE;
		
		int[] dist = new int[n + 1];
		boolean[] isVisited = new boolean[n + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 0; i <= n; i++) {
			dist[i] = INF;
			isVisited[i] = false;
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}
		
		dist[x] = 0;
		q.add(x);
		
		while(!q.isEmpty()) {
			int nowX = q.poll();
			if(!isVisited[nowX]) {
				isVisited[nowX] = true;
				
				if(dist[nowX] == k) answer.add(nowX);
				
				for(int i : list.get(nowX)) {
					if(!isVisited[i] && dist[nowX] + 1 < dist[i]) {
						dist[i] = dist[nowX] + 1;
						q.add(i);
					}
				}
			}
		}
		Collections.sort(answer);
		
		if(answer.size() == 0) System.out.println("-1");
		else for(int i : answer) System.out.println(i);
	}
}