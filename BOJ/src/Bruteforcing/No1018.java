package Bruteforcing;
//No1018_체스판다시칠하기_정답
import java.io.*;
import java.util.*;
public class No1018 {
	static int cntA = 0, cntB = 0;

	static void check(char[][] board, String[] boardStartW, String[] boardStartB, int n, int m) {
		for (int i = n, a = 0; i < n + 8; i++, a++) {
			for (int j = m, b = 0; j < m + 8; j++, b++) {
				if(board[i][j] != boardStartW[a].charAt(b)) cntA += 1;
				if(board[i][j] != boardStartB[a].charAt(b)) cntB += 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] board = new char[n][m];
		String[] boardStartB = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};
		String[] boardStartW = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
		
		for(int i = 0; i < n; i++) {
			board[i] =  br.readLine().toCharArray();
		}
		
		int min = 64;
		for(int i = 0; i <= n - 8; i++) { 
			for(int j = 0; j <= m - 8; j++) {
				check(board, boardStartW, boardStartB, i, j);
				min = (cntA < cntB ? cntA : cntB) <= min ? (cntA < cntB ? cntA : cntB) : min;
				cntA = 0; cntB = 0;
			}
		}
		System.out.println(min);
	}
}