//No1427_소트인사이드_두번만에 정답_클래스명 main으로 안바꿈
package Sorting;

import java.io.*;
public class No1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] numArr = br.readLine().toCharArray();
		
		int numLength = numArr.length;
		char tmp;
		for(int i = 0; i < numLength - 1; i++) {
			for(int j = i + 1; j < numLength; j++) {
				if(numArr[j] > numArr[i]) {
					tmp = numArr[j];
					numArr[j] = numArr[i];
					numArr[i] = tmp;
				}
			}
		}
		for(char i : numArr) System.out.print(i);
	}
}