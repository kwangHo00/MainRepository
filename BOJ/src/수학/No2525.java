package 수학;
//No2525_오븐시계_두번만에 맞음_ 15번째 줄 뺏셈 순서 반대로 함
import java.io.*;
import java.util.*;
public class No2525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		
		if((a * 60 + b + c) / 60 >= 24) {
			System.out.println((a * 60 + b + c) / 60 - 24 + " " + (a * 60 + b + c) % 60);			
		}
		else System.out.println((a * 60 + b + c) / 60 + " " + (a * 60 + b + c) % 60);
	}
}