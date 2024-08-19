package 알고리즘스터디;

import java.util.*;

public class 햄버거다이어트 {
    static int N, L;
    static int[] s, k;
    static int maxTaste;

    public static void dfs(int i, int taste, int kcal) {
        if (kcal > L) { // 칼로리 초과
            return;
        }
        if (taste > maxTaste) { // 최대 칼로리 저장
            maxTaste = taste;
        }
        if (i == N) { // 끝
            return;
        }
        dfs(i + 1, taste + s[i], kcal + k[i]); // 현재 재료 선택
        dfs(i + 1, taste, kcal); // 현재 재료 미선택
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            L = sc.nextInt();
            s = new int[N];
            k = new int[N];

            for (int i = 0; i < N; i++) {
                s[i] = sc.nextInt(); // score
                k[i] = sc.nextInt(); // kcal
            }

            maxTaste = 0;
            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + maxTaste);
        }

        sc.close();
    }
}