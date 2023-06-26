//No2609_최대공약수와최소공배수_정답
package Mathematics;

import java.io.*;
import java.util.*;
public class No2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int tmp1 = Math.max(num1, num2), tmp2 = Math.min(num1, num2), remain = 0;
		while(tmp1 % tmp2 != 0) {
			remain = tmp1 % tmp2;
			tmp1 = tmp2;
			tmp2 = remain;
		}
		System.out.println(tmp2);
		System.out.println((num1 * num2) / tmp2);
	}
}