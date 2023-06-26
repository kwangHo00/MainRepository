//No16395_파스칼의삼각형_정답
package Dynamic_Programming;

import java.io.*;
import java.util.*;
public class No16395 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[n + 1][n + 1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				arr[i][j] = 0;
			}
		}
		arr[1][1] = 1;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
		}
		System.out.println(arr[n][k]);
	}
}