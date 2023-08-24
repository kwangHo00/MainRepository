//No17352_여러분의 다리가 되어 드리겠습니다 _ 3번만에 정답 _ parentNode[i]의 값은 i의 루트노드를 보장하지 않을 수 있음
//따라서 i의 루트노드를 찾으려면 반드시 getParent()로 찾아야 함
package Disjoint_Set;

import java.io.*;
import java.util.*;

public class No17352 {
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
		
		int n = Integer.parseInt(br.readLine());
		
		int[] parentNode = new int[n + 1];
		for(int i = 0; i <= n; i++) parentNode[i] = i;
		
		for(int i = 0; i < n - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(parentNode, a, b);
		}
		
		for(int i = 2; i <= n; i++) {
			if(getParent(parentNode, i) != getParent(parentNode, 1)) {
				System.out.println(i + " " + 1);
				break;
			}
		}
	}
}