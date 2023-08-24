//No3055_탈출_두번만에 정답 _ 물과 도치가 동시에 움직이는 로직이 잘못됨
package Graph_Traversal;

import java.io.*;
import java.util.*;

public class No3055 {
    static final int[] upDown = {-1, 1, 0, 0};
    static final int[] leftRight = {0, 0, -1, 1};
    static int[][] dist, waterDist;
    static char[][] map;
    static Queue<Pair> water = new LinkedList<Pair>();
    static Queue<Pair> hedgehog = new LinkedList<Pair>();

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void waterMove(int sizeN, int sizeM) {
        int waterSize = water.size();
        while(waterSize-- > 0) {
            int currX = water.peek().x;
            int currY = water.peek().y;
            water.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if((map[nextX][nextY] != 'X' && map[nextX][nextY] != 'D') && waterDist[nextX][nextY] == 0) {                    
                    waterDist[nextX][nextY] = waterDist[currX][currY] + 1;
                    water.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    static void bfs(int x, int y, int sizeN, int sizeM) {
        hedgehog.add(new Pair(x, y));
        dist[x][y] = 1;

        while(!hedgehog.isEmpty()) {
            int currX = hedgehog.peek().x;
            int currY = hedgehog.peek().y;
            hedgehog.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = currX + upDown[i];
                int nextY = currY + leftRight[i];
                if(nextX < 0 || nextX > sizeN - 1 || nextY < 0 || nextY > sizeM - 1) continue;
                if((map[nextX][nextY] == '.' || map[nextX][nextY] == 'D') && dist[nextX][nextY] == 0 && (waterDist[nextX][nextY] == 0 || dist[currX][currY] + 1 < waterDist[nextX][nextY])) {                    
                    dist[nextX][nextY] = dist[currX][currY] + 1;
                    hedgehog.add(new Pair(nextX, nextY));
                }
            }

            waterMove(sizeN, sizeM);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sLoc = new int[2];
        int[] dLoc = new int[2];

        dist = new int[n][m];
        waterDist = new int[n][m];
        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'S') {
                    sLoc[0] = i;
                    sLoc[1] = j;
                }
                if(map[i][j] == 'D') {
                    dLoc[0] = i;
                    dLoc[1] = j;
                }
                if(map[i][j] == '*') {
                    water.add(new Pair(i, j));
                }
            }
        }

        waterMove(n, m);
        bfs(sLoc[0], sLoc[1], n, m);
        
        if (dist[dLoc[0]][dLoc[1]] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(dist[dLoc[0]][dLoc[1]] - 1);
        }
    }
}
