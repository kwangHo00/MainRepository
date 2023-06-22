package Graph_Traversal;
//No24444_알고리즘 수업-너비우선탐색1_시간 초과 해결을 못하겠음_4번만에 정답_arrayList와 linkedList의 성능 차이를 까먹어서 틀림
//원소의 빠른 검색을 위해서는 arrayList가 linkedList보다 빠름 O(1) -> random access
import java.util.*;
import java.io.*;
public class No24444 {
	static boolean isVisited[];
	static int num[];
	static int sequence = 1;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	static void bfs(int start) {
		queue.add(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			int nowNum = queue.poll();
			num[nowNum] = sequence++;
			
			for(int i : list.get(nowNum)) {
				if(!isVisited[i]) {
					queue.add(i);
					isVisited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		isVisited = new boolean[n + 1];
		num = new int[n + 1];
		
		for(int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i < n + 1; i++) {
			Collections.sort(list.get(i));
		}
		
		bfs(r);
		
		StringBuilder sb = new StringBuilder();
        for (int i = 1; i < num.length; i++) {
            sb.append(num[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}