//No1833_고속철도설계하기_두번만에 정답 1) 2차원배열을 탐색하면서 중복되는 간선이 있기 때문에 
//57번째 줄에서 매번 값을 / 2를 하고 더해줬는데 만약 값이 5같이 홀수로 들어오면 원하는대로 / 2가 안되기 때문에
//중복되는 값도 전부 더하고 나중에 절반으로 나누어 주었음
package Minimum_Spanning_Tree;

import java.io.*;
import java.util.*;

public class No1833 {
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
		
		int n = Integer.parseInt(br.readLine());
		int[][] city = new int[n + 1][n + 1];
		int[] parentNode = new int[n + 1];
		ArrayList<NodeInfo> list = new ArrayList<NodeInfo>();
		int answer = 0;
		
		for(int i = 1; i <= n; i++) {
			parentNode[i] = i;
		}

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				
				if(city[i][j] < 0) {
					union(parentNode, i, j);
					answer += Math.abs(city[i][j]);
				} else if(city[i][j] > 0) {
					list.add(new NodeInfo(i, j, city[i][j]));
				}
			}
		}
		
		Collections.sort(list, (a, b) -> a.c - b.c);
		
		answer /= 2;
		ArrayList<int[]> addList = new ArrayList<int[]>();
		for(NodeInfo i : list) {
			int[] addArr = new int[2];
			if(!find(parentNode, i.a, i.b)) {
				union(parentNode, i.a, i.b);
				answer += i.c;
				addArr[0] = i.a;
				addArr[1] = i.b;
				addList.add(addArr);
			}
		}
		System.out.println(answer + " " + addList.size());
		for(int[] i : addList) System.out.println(i[0] + " " + i[1]);
	}
}