package 알고리즘스터디;
import java.util.*;
public class 오셀로_4615 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int T = kb.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = kb.nextInt();
            int M = kb.nextInt();
            int[][] arr = new int[N+1][N+1];

            int m = N / 2;
            arr[m][m] = arr[m+1][m+1] = 2;
            arr[m][m+1] = arr[m+1][m] = 1;

            for (int i = 0; i < M; i++) {
                int si = kb.nextInt();
                int sj = kb.nextInt();
                int d = kb.nextInt();
                arr[si][sj] = d;

                int[] di = {-1, -1, -1, 1, 1, 1, 0, 0};
                int[] dj = {-1, 0, 1, -1, 0, 1, -1, 1};

                for (int k = 0; k < 8; k++) {
                    int ni = si + di[k];
                    int nj = sj + dj[k];
                    int mul = 1;
                    while (true) {
                        ni = si + di[k] * mul;
                        nj = sj + dj[k] * mul;
                        if (ni >= 1 && ni <= N && nj >= 1 && nj <= N) {
                            if (arr[ni][nj] == 0) {
                                break;
                            } else if (arr[ni][nj] == d) {
                                for (int l = 1; l < mul; l++) {
                                    arr[si + di[k] * l][sj + dj[k] * l] = d;
                                }
                                break;
                            }
                        } else {
                            break;
                        }
                        mul++;
                    }
                }
            }

            int bcnt = 0, wcnt = 0;
            for (int[] row : arr) {
                for (int val : row) {
                    if (val == 1) bcnt++;
                    else if (val == 2) wcnt++;
                }
            }

            System.out.println("#" + test_case + " " + bcnt + " " + wcnt);
        }

        kb.close();
    }
}