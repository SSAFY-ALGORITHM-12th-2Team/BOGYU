package 알고리즘스터디;

import java.util.*;

public class contect {
    static List<List<Integer>> graph;
    static int[][] visited;

    static void bfs(int start) {
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, count});
        visited[start][0] = 1;
        visited[start][1] = count;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int v = current[0];
            count = current[1];

            for (int i : graph.get(v)) {
                if (visited[i][0] == 0) {
                    visited[i][0] = 1;
                    visited[i][1] = count + 1;
                    queue.offer(new int[]{i, count + 1});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int N = sc.nextInt();
            int v = sc.nextInt();

            graph = new ArrayList<>();
            for (int i = 0; i <= 100; i++) {
                graph.add(new ArrayList<>());
            }

            visited = new int[101][2];

            for (int i = 0; i < N; i += 2) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph.get(from).add(to);
            }

            bfs(v);

            int max = 0;
            int result = 0;

            for (int i = 1; i <= 100; i++) {
                if (max <= visited[i][1]) {
                    max = visited[i][1];
                    result = i;
                }
            }

            System.out.println("#" + tc + " " + result);
        }

        sc.close();
    }
}