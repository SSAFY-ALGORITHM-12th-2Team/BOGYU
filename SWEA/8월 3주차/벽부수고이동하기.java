package 알고리즘스터디;

import java.util.*;

public class 벽부수고이동하기 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        N = kb.nextInt();
        M = kb.nextInt();
        
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = kb.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(BFS());
       
    }

    static int BFS() {
        int[][][] visited = new int[N][M][2];
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0, 1});
        visited[0][0][1] = 1;

        while (!Q.isEmpty()) {
            int[] current = Q.poll();
            int x = current[0], y = current[1], possible = current[2];

            if (x == N-1 && y == M-1) {
                return visited[x][y][possible];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (arr[nx][ny] == 1 && possible == 1) {
                        visited[nx][ny][0] = visited[x][y][1] + 1;
                        Q.offer(new int[]{nx, ny, 0});
                    } else if (visited[nx][ny][possible] == 0 && arr[nx][ny] == 0) {
                        Q.offer(new int[]{nx, ny, possible});
                        visited[nx][ny][possible] = visited[x][y][possible] + 1;
                    }
                }
            }
        }
        return -1;
    }
}