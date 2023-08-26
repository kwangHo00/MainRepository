//No1504_특정한 최단 경로_두번만에 정답_ 경로 이상하게 입력함
package Graph_Theory;

import java.io.*;
import java.util.*;

public class No1504 {
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] node = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(node[i], INF);
			node[i][i] = 0;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			node[a][b] = c;
			node[b][a] = c;
		}
		
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		for(int k = 1; k <= n; k++) {
			for(int a = 0; a <= n; a++) {
				for(int b = 0; b <= n; b++) {
					node[a][b] = Math.min(node[a][b], node[a][k] + node[k][b]);
				}
			}
		}
		
		int answer = 0;
		if(node[1][u] == INF || node[u][v] == INF || node[v][n] == INF) answer = -1;
		else answer = Math.min(node[1][u] + node[u][v] + node[v][n], node[1][v] + node[u][v] + node[u][n]);

		System.out.println(answer);
	}
}