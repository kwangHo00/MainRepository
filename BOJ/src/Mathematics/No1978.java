package Mathematics;
//No1978_소수찾기_정답
import java.io.*;
import java.util.*;
public class No1978 {
	
	static boolean isPrimeNum(int n) {
		int answer = 0;
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) answer += 1;
		}
		
		if(answer == 2) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(isPrimeNum(num)) cnt += 1;
		}
		System.out.println(cnt);
	}
}