//No24447_알고리즘수업-너비우선탐색4_정답
package Graph_Traversal;
import java.io.*;
import java.util.*;

public class No24447 {
	static boolean[] isVisited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static void bfs(int r, int n) {
		long[] depth = new long[n + 1];
    	long[] order = new long[n + 1];
    	int sequence = 1;
    	
    	Arrays.fill(depth, -1);
    	Arrays.fill(order, 0);
    	depth[r] = 0;
    	order[r] = sequence++;
    	
    	isVisited[r] = true;
    	q.add(r);
    	
    	while(!q.isEmpty()) {
    		int currNode = q.poll();
    		int listSize = list.get(currNode).size();
    		for(int i = 0; i < listSize; i++) {
    			int listValue = list.get(currNode).get(i);
    			if(!isVisited[listValue]) {
    				isVisited[listValue] = true;
    				q.add(listValue);
    				depth[listValue] = depth[currNode] + 1;
        			order[listValue] = sequence++;
    			}
    		}
		}

		long answer = 0L;
		for (int i = 1; i <= n; i++) {
			answer += depth[i] * order[i];
		}
		System.out.println(answer);
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		isVisited = new boolean[n + 1];
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(list.get(i));
		}
		bfs(r, n);	
	}
}