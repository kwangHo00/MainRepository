//No17953_디저트_정답
package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class No17953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[m][n];
		int[][] info = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < m; i++) {
			dp[i][0] = info[i][0];
		}
		
		for(int i = 1; i < n; i++) { //열
			for(int j = 0; j < m; j++) { //행
				for(int k = 0; k < m; k++) { //행
					if(j == k) {
						dp[j][i] = Math.max(info[j][i] / 2 + dp[k][i - 1], dp[j][i]);
						continue;
					}
					dp[j][i] = Math.max(info[j][i] + dp[k][i - 1], dp[j][i]);
				}
			}
		}
		
		long max = 0;
		for(int i = 0; i < m; i++) {
			max = dp[i][n - 1] >= max ? dp[i][n - 1] : max;
		}
		
		System.out.println(max);
	}
}