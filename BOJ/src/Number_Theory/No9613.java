//No9613_GCD 합 _ 두번만에 정답 1) Main클래스로 안바꿈
package Number_Theory;

import java.io.*;
import java.util.*;

public class No9613 {
	static int gcd(int a, int b) {
		int tmp, n;
		if(a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		while(b != 0) {
			n = a % b;
			a = b;
			b = n;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] num = new int[n];
			
			for(int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			long answer = 0;
			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					answer += gcd(num[i], num[j]);
				}
			}
			
			System.out.println(answer);
		}
	}
}