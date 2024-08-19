package 알고리즘스터디;

import java.util.*;

public class 유기농배추 {
    static int M, N, K;
    static int[][] matrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        for (int t = 0; t < T; t++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            matrix = new int[M][N];
            int cnt = 0;

            
            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                matrix[x][y] = 1;
            }

            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) {
                    if (matrix[a][b] == 1) {
                        BFS(a, b);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
        sc.close();
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        matrix[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (matrix[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    matrix[nx][ny] = 0;
                }
            }
        }
    }
}