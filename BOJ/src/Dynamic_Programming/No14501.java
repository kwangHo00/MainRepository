//No14501_퇴사_정답
package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class No14501 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // N까지만 일 함
		
		int[] T = new int[n + 1];
		int[] P = new int[n + 1];
		int[] dp = new int[n + 2];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = n; i > 0; i--) {
			int next = i + T[i];
			
			if(next > n + 1) dp[i] = dp[i + 1];
			else dp[i] = Math.max(dp[i + 1], P[i] + dp[next]);
		}
		
		System.out.println(dp[1]);
	}
}