//No11265_끝나지 않는 파티_정답
package Graph_Theory;

import java.io.*;
import java.util.*;

public class No11265 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < n; k++) {
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < n; b++) {
					dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			if(c < dist[a][b]) System.out.println("Stay here");
			else System.out.println("Enjoy other party");
		}
	}
}