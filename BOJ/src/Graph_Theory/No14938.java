//No14938_서강그라운드_정답
package Graph_Theory;

import java.io.*;
import java.util.*;

public class No14938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] item = new int[n + 1];
		int[][] map = new int[n + 1][n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(map[i], 1_000_000_000);
			map[i][i] = 0;
		}
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
			map[b][a] = c;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int a = 1; a <= n; a++) {
				for(int b = 1; b <= n; b++) {
					map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
				}
			}
		}
		
		int answer = 0, tmp = 0;
		for(int i = 1; i <= n; i++) {
			tmp = 0;
			for(int j = 1; j <= n; j++) {
				if(map[i][j] <= m) tmp += item[j];
			}
			answer = Math.max(answer, tmp);
		}
		System.out.println(answer);
	}
}