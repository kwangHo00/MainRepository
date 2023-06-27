//No13699_점화식_정답
package Dynamic_Programming;

import java.io.*;
public class No13699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[36];
		dp[0] = 1;
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - 1 - j];
			}
		}
		System.out.println(dp[n]);
	}
}