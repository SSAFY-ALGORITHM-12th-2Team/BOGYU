package 알고리즘스터디;
import java.util.*;

public class 등산로조성 {
    static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, K, ans;
    static int[][] mountain, visited;

    static void dfs(int x, int y, int dist, int K) {
        if (dist > ans) {
            ans = dist;
        }
        visited[x][y] = 1;
        for (int[] d : dxy) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == 0) {
                if (mountain[nx][ny] < mountain[x][y]) {
                    dfs(nx, ny, dist + 1, K);
                } else if (K > 0 && K > mountain[nx][ny] - mountain[x][y]) {
                    int tmp = mountain[nx][ny];
                    mountain[nx][ny] = mountain[x][y] - 1;
                    dfs(nx, ny, dist + 1, 0);
                    mountain[nx][ny] = tmp;
                }
            }
        }
        visited[x][y] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            mountain = new int[N][N];
            visited = new int[N][N];
            int top = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mountain[i][j] = sc.nextInt();
                    if (mountain[i][j] > top) {
                        top = mountain[i][j];
                    }
                }
            }

            ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mountain[i][j] == top) {
                        dfs(i, j, 1, K);
                    }
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
        sc.close();
    }
}