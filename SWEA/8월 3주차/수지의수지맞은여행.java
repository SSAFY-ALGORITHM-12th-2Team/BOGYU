package 알고리즘스터디;

import java.util.*;

public class 수지의수지맞은여행 {
    static char[][] map;
    static int R, C;
    static boolean[] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max;

    public static void dfs(int x, int y, int depth) {
        max = Math.max(max, depth);
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                int alphaIndex = map[nx][ny] - 'A';
                if(!visited[alphaIndex]) {
                    visited[alphaIndex] = true;
                    dfs(nx, ny, depth + 1);
                    visited[alphaIndex] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int T = kb.nextInt();
        
        for(int t = 1; t <= T; t++) {
            R = kb.nextInt();
            C = kb.nextInt();
            map = new char[R][C];
            visited = new boolean[26];  // A-Z
            max = 0;

            for(int i = 0; i < R; i++) {
                String s = kb.next();
                for(int j = 0; j < C; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            visited[map[0][0] - 'A'] = true;
            dfs(0, 0, 1);

            System.out.println("#" + t + " " + max);
        }
       
    }
}
