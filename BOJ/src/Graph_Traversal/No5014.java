//No5014_스타트링크_정답
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No5014 {
	static int[] floor;
	static int[] time;
	static boolean[] isVisited;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int answer = 0;
	
	static void bfs(int f, int s, int g, int u, int d) {
		final int[] upDown = {u, -d};
		
		isVisited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int currS = queue.poll();
			if(currS == g) break;
			
			for(int i = 0; i < 2; i++) {
				int nextS = currS + upDown[i];
				if(nextS < 1 || nextS > f) continue;
				if(!isVisited[nextS]) {
					isVisited[nextS] = true;
					time[nextS] = time[currS] + 1;
					queue.add(nextS);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		floor = new int[f + 1];
		time = new int[f + 1];
		isVisited = new boolean[f + 1];
		
		bfs(f, s, g, u, d);
		if(s != g && time[g] == 0) System.out.println("use the stairs");
		else System.out.println(time[g]);
	}
}