//No17608_막대기
import java.io.*;
public class No17608 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int max = 0;
		int maxIndex = 0;
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] >= max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		
		int temp = arr[n - 1];
		for(int i = n - 2; i >= maxIndex; i--) {
			if(arr[i] > temp) {
				cnt++;
				temp = arr[i];
			}
		}
		System.out.println(cnt + 1);
	}
}