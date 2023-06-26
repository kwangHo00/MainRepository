//No4948_베르트랑공준_정답
package Mathematics;

import java.io.*;
public class No4948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			int cnt = 0;
			
			int[] arr = new int[n * 2 + 1];
			for(int i = n; i <= n * 2; i++) {
				arr[i] = i;
			}
			
			for(int i = 2; i <= n * 2; i++) {
				for(int j = i * 2; j <= n * 2; j += i) {
					if(arr[j] == 0) continue;
					arr[j] = 0;
				}
			}
			
			for(int i = n + 1; i <= n * 2; i++) {
				if(arr[i] != 0) cnt += 1;
			}
			System.out.println(cnt);
		}
	}
}