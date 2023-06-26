//No6118_숨바꼭질_두번만에 정답_최대값 구하는 라인에서 변수 잘못 사용
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No6118 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> q = new LinkedList<Integer>();
	static int[] dist;
	static boolean[] isVisited;
	
	static void bfs(int s) {
		isVisited[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			int tmpS = q.poll();
			int listSize = list.get(tmpS).size();
			for(int i = 0; i < listSize; i++) {
				if(!isVisited[list.get(tmpS).get(i)]) {
					isVisited[list.get(tmpS).get(i)] = true;
					dist[list.get(tmpS).get(i)] = dist[tmpS] + 1;
					q.add(list.get(tmpS).get(i));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dist = new int[n + 1];
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
		bfs(1);
		
		int num = 0, distAnswer = 0, cnt = 0;
		for(int i = 1; i <= n; i++) {
			distAnswer = dist[i] >= distAnswer ? dist[i] : distAnswer;
		}
		for(int i = 1; i <= n; i++) {
			if(dist[i] == distAnswer) {
				num = i;
				break;
			}
		}
		for(int i = 1; i <= n; i++) {
			if(dist[i] == distAnswer) cnt += 1;
		}
		System.out.println(num + " " + distAnswer + " " + cnt);
	}
}