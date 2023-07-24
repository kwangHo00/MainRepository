//No2156_포도주 시식_정답
package Dynamic_Programming;

import java.io.*;
public class No2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int n = Integer.parseInt(br.readLine());
 
		int[] info = new int[n + 1];
		int[] dp = new int[n + 1];
 
		for (int i = 1; i <= n; i++) {
			info[i] = Integer.parseInt(br.readLine());
		}
 
		dp[1] = info[1];
		
		if (n > 1) dp[2] = info[1] + info[2];
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + info[i], dp[i - 3] + info[i - 1] + info[i]));
		}
		
		System.out.println(dp[n]);
	}
}