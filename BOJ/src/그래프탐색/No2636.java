package 그래프탐색;
//No2636_치즈_정답
import java.util.*;
import java.io.*;

public class No2636 {
	static int[][] board;
	static boolean[][] isVisited;
	static final int[] upDown = {-1, 1, 0, 0};
	static final int[] leftRight = {0, 0, -1, 1};
	
	//외부 공기를 2로 바꾸는 메소드
	static void checkAir(int a, int b, int sizeN, int sizeM) {
		isVisited[a][b] = true;
		board[a][b] = 2;
		
		for(int i = 0; i < 4; i++) {
			int tmpA = a + upDown[i];
			int tmpB = b + leftRight[i];
			if(tmpA < 0 || tmpA > sizeN - 1 || tmpB < 0 || tmpB > sizeM - 1) continue;
			if((board[tmpA][tmpB] == 2 || board[tmpA][tmpB] == 0) && !isVisited[tmpA][tmpB]) checkAir(tmpA, tmpB, sizeN, sizeM);
		}
	}
	
	static void melt(int sizeN, int sizeM) {
		for(int i = 1; i < sizeN - 1; i++) {
			for(int j = 1; j < sizeM - 1; j++) {
				if(board[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						int tmpA = i + upDown[k];
						int tmpB = j + leftRight[k];
						if(board[tmpA][tmpB] == 2) {
							board[i][j] = 3;
							break;
						}
					}
				}
			}
		}
		
		for(int i = 1; i < sizeN - 1; i++) {
			for(int j = 1; j< sizeM - 1; j++) {
				if(board[i][j] == 3) board[i][j] = 2;
			}
		}
	}
	
	//치즈가 남아있는지 확인하는 메소드
	static boolean isCheeseExist(int sizeN, int sizeM) {
		for(int i = 1; i < sizeN - 1; i++) {
			for(int j = 1; j < sizeM - 1; j++) {
				if(board[i][j] == 1) return true;
			}
		}
		return false;
	}
	
	//남아 있는 치즈가 몇개인지 확인하는 메소드
	static int checkNumOfCheese(int sizeN, int sizeM) {
		int numOfCheese = 0;
		for(int i = 1; i < sizeN - 1; i++) {
			for(int j = 1; j < sizeM - 1; j++) {
				if(board[i][j] == 1) numOfCheese += 1;
			}
		}
		return numOfCheese;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		isVisited = new boolean[n][m];
		int totalTime = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//입력
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(isCheeseExist(n, m)) {
			checkAir(0, 0, n, m);
			list.add(checkNumOfCheese(n,m));
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					isVisited[i][j] = false;
				}
			}
			melt(n, m);
			totalTime += 1;
		}
		
		System.out.println(totalTime);
		System.out.println(list.get(list.size() - 1));
	}
}