//No1976_여행가자_정답
package Disjoint_Set;

import java.io.*;
import java.util.*;

public class No1976 {
	static int getParent(int[] parent, int node) {
		if(parent[node] == node) return parent[node];
		else return parent[node] = getParent(parent, parent[node]);
		// parent[node] = getParent(parent, parent[node])라고 하는 이유는
		//1 2 3이 연결되어있고 5 6 7이 연결되어있을때 3과 5를 연결한다고 가정한다면 6과 7은 여전히 5를 부모로 가짐.
		//이때 6에대해 getParent를 하게되면 재귀를타고 1을 돌려받는데 이경우에 parent테이블상 6의 부모를 5에서 1로 갱신하기 위함.
		//재귀 호출을 하기 때문에 부모 노드를 찾는 것에는 문제가 없지만, 부모 노드를 저장하는 테이블을 갱신해야 됨.
	}
	
	static void union(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a > b) parent[a] = b;
		else parent[b] = a;
	}
	
	static boolean find(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a == b) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] plan = new int[m], parentNode = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int city = Integer.parseInt(st.nextToken());
				if(city == 1) union(parentNode, i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		String answer = "YES";
		for(int i = 0; i < m - 1; i++) {
			if(!find(parentNode, plan[i], plan[i + 1])) answer = "NO";
		}
		
		System.out.println(answer);
	}
}