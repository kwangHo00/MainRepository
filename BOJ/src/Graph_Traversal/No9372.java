//No9372_상근이의여행_두번만에 정답_테스트 케이스 마다 list를 초기화 해주지 않고 그냥 사용해서 arrayIndexOutOfBounds 에러 발생
//list.clear()추가하고 해결
package Graph_Traversal;

import java.io.*;
import java.util.*;
public class No9372 {
	static boolean[] isVisited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static int bfs(int s) {
		int cnt = 0;
		isVisited[s] = true;
		q.add(s);
		
		while(!q.isEmpty()) {
			int tmpS = q.poll();
			cnt += 1;
			int listSize = list.get(tmpS).size();
			for(int i = 0; i < listSize; i++) {
				if(!isVisited[list.get(tmpS).get(i)]) {
					isVisited[list.get(tmpS).get(i)] = true;
					q.add(list.get(tmpS).get(i));
				}
			}
		}
		return cnt - 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
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
			System.out.println(bfs(1));
			list.clear();
		}
	}
}