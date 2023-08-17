//No1850_최대공약수 _ 질문게시판 보고 맞춤 _ 정답은 a와 b의 최대공약수 만큼 1이 나열된 수
package Number_Theory;

import java.io.*;
import java.util.*;

public class No1850 {
	static long gcd(long a, long b) {
		long tmp, n;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long gcd = gcd(a, b);
		for(int i = 0; i < gcd; i++) {
			sb.append('1');
		}
		System.out.println(sb);
	}
}