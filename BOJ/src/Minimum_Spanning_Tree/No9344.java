//No9344_도로_두번만에 정답 _ 1) 연결됐는지 확인하는 2차원 배열을 생성해서 메모리 초과 발생
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No9344 {
	static class NodeInfo{
		int a, b, c;
		NodeInfo(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	static int getParent(int[] parent, int n) {
		if(parent[n] == n) return parent[n];
		else return parent[n] = getParent(parent, parent[n]);
	}
	
	static void union(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if(aParent < bParent) parent[bParent] = aParent;
		else parent[aParent] = bParent;
	}
	
	static boolean find(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		if(aParent == bParent) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int[] parentNode = new int[n + 1];
			int[] usedWith = new int[n + 1];
			ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
			
			for(int i = 1; i <= n; i++) {
				parentNode[i] = i;
				usedWith[i] = 0;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				list.add(new NodeInfo(u, v, w));
			}
			Collections.sort(list, (a, b) -> (int)(a.c - b.c));
			
			for(NodeInfo i : list) {
				if(!find(parentNode, i.a, i.b)) {
					union(parentNode, i.a, i.b);
					usedWith[i.a] = i.b;
					usedWith[i.b] = i.a;
				}
			}
			if(usedWith[p] == q || usedWith[q] == p) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}