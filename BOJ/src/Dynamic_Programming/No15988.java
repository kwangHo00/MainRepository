//No15988_1,2,3더하기3_4번만에 정답_1)배열 크기 잘못 설정 2) 반복 횟수 잘못 설정 3) 정답 출력할 때 m이 아니라 n값을 넣어버림(dp[n] -> 이렇게)
package Dynamic_Programming;

import java.io.*;
public class No15988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        long dp[] = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 1000000; i++)
        	dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        for(int i = 0; i < n; i++){
        	int m = Integer.parseInt(br.readLine());
        	System.out.println(dp[m]);
        }
	}
}