//No1065_한수_정답
package Bruteforcing;

import java.io.*;
public class No1065 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			String num = String.valueOf(i);
            int length = num.length();

            if (length <= 2) cnt += 1;
            else {
                int d = num.charAt(1) - num.charAt(0);
                for (int j = 2; j < length; j++) {
                    if (num.charAt(j) - num.charAt(j - 1) != d) break;
                    cnt += 1;
                }
            }
		}
		System.out.println(cnt);
	}
}