//No1436_영화감독숌_정답
package Bruteforcing;

import java.io.*;
public class No1436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int n = Integer.parseInt(br.readLine());
//		int num = 666;
//		
//		while(n > 0) {
//			String strNum = String.valueOf(num);
//			int numLength = strNum.length();
//			
//			for(int i = 0; i < numLength - 2; i++) {
//				if(strNum.charAt(i) == '6' && strNum.charAt(i + 1) == '6' && strNum.charAt(i + 2) == '6') {
//					--n;
//					break;
//				}
//			}
//			num += 1;
//		}
		int n = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 666;

        while (count < n) {
            String strNum = String.valueOf(num);

            if (strNum.contains("666")) count++;
            num++;
        }
		System.out.println(num - 1);
	}
}