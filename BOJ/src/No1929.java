//No1929_소수구하기_두번째만에 정답_범위 밖의 값도 출력해서 출력 초과로 틀림
import java.util.*;
import java.io.*;
public class No1929 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] num = new int[b + 1];
		
		for(int i = 2; i <= b; i++) {
			num[i] = i;
		}
		
		for(int i = 2; i <= b; i++) {
			if(num[i] == 0) continue;
			for(int j = 2 * i; j <= b; j += i) {
				num[j] = 0;
			}
		}
		
		for(int i = a; i <= b; i++) {
			if(num[i] != 0) System.out.println(num[i]);
		}
	}
}