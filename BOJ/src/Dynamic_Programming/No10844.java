//No10844_쉬운계단수_ 구글링해서 맞음 _ 이해 못함
package Dynamic_Programming;

import java.io.*;
import java.util.*;

public class No10844 {
	static final long MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		//[자릿수][자릿값]
		long[][] dp = new long[n + 1][10];
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			
			for(int j = 1; j <= 9; j++) {
				if(j == 9) dp[i][9] = dp[i - 1][8] % MOD;
				else dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j + 1] % MOD) % MOD;
			}
		}
	
		long answer = 0;
		for(int i = 1; i <= 9; i++) {
			answer = (answer + dp[n][i]) % MOD;
		}
		System.out.println(answer);
	}
}