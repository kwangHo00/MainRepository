//No11727_2xN타일링2_4번만에 정답_1)%10007안함 2)배열 길이 잘못 설정 3)n이 1000과 같이 큰 수 일때 arr[n]의 값이 int형을 넘어가는데 이때
//바로 %을 안해줘서 답이 이상하게 나옴
package Dynamic_Programming;

import java.io.*;
public class No11727 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		arr[1] = 1;
		arr[2] = 3;
		for(int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
		}
		System.out.println(arr[n]);
	}
}