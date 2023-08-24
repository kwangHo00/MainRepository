//No11404_플로이드_정답 _ 무한대값 초기화할때 오버플로우나지 않을 정도로 초기화하기
//아래 코드에서 INF를 Long.MAX_VALUE로 초기화하면 city가 long 타입이라 city[a][k] + city[k][b]할 때 오버플로우 발생
package Graph_Theory;

import java.io.*;
import java.util.*;

public class No11404 {
	static int INF = Integer.MAX_VALUE;
	static long[][] city;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		city = new long[n + 1][n + 1];
		for(int i = 0; i <= n; i++) {
			Arrays.fill(city[i], INF);
			city[i][i] = 0;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(city[a][b] > c) city[a][b] = c;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int a = 1; a <= n; a++) {
				for(int b = 1; b <= n; b++) {
					city[a][b] = Math.min(city[a][b], city[a][k] + city[k][b]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(city[i][j] == INF) System.out.print(0 + " ");
				else System.out.print(city[i][j] + " ");
			}
			System.out.println();
		}
	}
}