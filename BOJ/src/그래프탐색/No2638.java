package 그래프탐색;
//No2638_치즈_3번째 만에 정답_처음 오답은 main으로 안바꾸고 제출해서 틀리고 두번째는 알고리즘 오류
import java.util.*;
import java.io.*;

public class No2638 {
	static int[][] graphPaper;
	static boolean[][] isVisited;
	static int totalTime = 0;
	
	//공기가 외부 공기인지 확인하는 메소드
	static void checkAir(int a, int b, int sizeN, int sizeM) {
		isVisited[a][b] = true;
		graphPaper[a][b] = 2; //외부공기는 2로 표시
		
		final int[] upDown = {-1, 1, 0, 0}; //상하좌우
		final int[] leftRight = {0, 0, -1, 1}; //상하좌우
		for(int i = 0; i < 4; i++) {
			int tmpA = a + upDown[i];
			int tmpB = b + leftRight[i];
			if(tmpA < 0 || tmpA > sizeN - 1 || tmpB < 0 || tmpB > sizeM - 1) continue;
			if((graphPaper[tmpA][tmpB] == 0 || graphPaper[tmpA][tmpB] == 2) && !isVisited[tmpA][tmpB]) checkAir(tmpA, tmpB, sizeN, sizeM);
		}
	}
	
	//외부 공기와 접촉한 모든 치즈를 녹이는 메소드
	static void melt(int a, int b, int sizeN, int sizeM) {
		int contactCnt = 0;
		final int[] upDown = {-1, 1, 0, 0};
		final int[] leftRight = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) {
			int tmpA = a + upDown[i];
			int tmpB = b + leftRight[i];
			if (graphPaper[tmpA][tmpB] == 2) contactCnt += 1;
			if (contactCnt >= 2) {
				graphPaper[a][b] = 3;
				break;
			}
		}
	}
	
	static boolean isAllMelt(int sizeN, int sizeM) {
		for(int i = 0; i < sizeN; i++) {
			for(int j = 0; j < sizeM; j++) {
				if(graphPaper[i][j] == 1) return false; // 치즈가 하나라도 남아있으면 false
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graphPaper = new int[n][m];
		isVisited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				graphPaper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			checkAir(0, 0, n, m); // 외부 공기 확인
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					isVisited[i][j] = false;
				}
			}
			
			for(int i = 1; i < n - 1; i++) {
				for(int j = 1; j < m - 1; j++) {
					if(graphPaper[i][j] == 1) melt(i, j, n, m);
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(graphPaper[i][j] == 3) graphPaper[i][j] = 2;
				}
			}
			totalTime += 1;
			if(isAllMelt(n,m)) break;
		}
		
		System.out.println(totalTime);
	}
}