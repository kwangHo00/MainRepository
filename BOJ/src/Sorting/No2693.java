//No2693_n번째큰수_정답
package Sorting;

import java.util.*;
import java.io.*;
public class No2693 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int tmp;
		
		for(int i = 0; i < n; i++) {
			int[] num = new int[10];
			st = new StringTokenizer(br.readLine());
			for(int p = 0; p < 10; p++) {
				num[p] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 0; j < 9; j++) {
				for(int k = j + 1; k < 10; k++) {
					if(num[k] > num[j]) {
						tmp = num[k];
						num[k] = num[j];
						num[j] = tmp;
					}
				}
			}
			System.out.println(num[2]);
		}
	}
}