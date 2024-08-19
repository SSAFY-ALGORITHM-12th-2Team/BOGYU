package 알고리즘스터디;

import java.util.*;

public class 수제버거장인 {
    static int ans = 0, n, m;
    static int[] sel = new int[1000];
    static boolean[][] map = new boolean[21][21];
    static boolean[] visited = new boolean[21];

    static boolean check(int depth, int idx) {
        for (int i = 0; i < depth; i++) {
            if (map[idx][sel[i]]) return false;
        }
        return true;
    }

    static void dfs(int depth, int startIdx) {
        if (depth <= n) {
            ans++;
            for (int i = startIdx; i <= n; i++) {
                if (!visited[i] && check(depth, i)) {
                    visited[i] = true;
                    sel[depth] = i;
                    dfs(depth + 1, i + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        
        for (int t_case = 1; t_case <= t; t_case++) {
            n = kb.nextInt();
            m = kb.nextInt();
            
            // 초기화
            for (int i = 0; i < 21; i++) {
                for (int j = 0; j < 21; j++) {
                    map[i][j] = false;
                }
            }
            
            for (int i = 0; i < m; i++) {
                int a = kb.nextInt();
                int b = kb.nextInt();
                map[a][b] = true;
                map[b][a] = true;
            }
            
            // 방문 배열 초기화
            for (int i = 0; i < 21; i++) {
                visited[i] = false;
            }
            
            dfs(0, 1);
            
            System.out.printf("#%d %d\n", t_case, ans);
            
            ans = 0;
        }
    }
}