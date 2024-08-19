package 알고리즘스터디;

import java.util.*;

public class 암호생성기 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int T = 10; 

        for (int test_case = 1; test_case <= T; test_case++) {
            kb.nextInt();  
            Queue<Integer> arr = new LinkedList<>();
            
           
            for (int i = 0; i < 8; i++) {
                arr.offer(kb.nextInt());
            }

            int i = 1;
            while (true) {
                int a = arr.poll() - i;
                if (a <= 0) {
                    arr.offer(0);
                    break;
                } else {
                    arr.offer(a);
                }
                i++;
                if (i > 5) {
                    i = 1;
                }
            }

         
            System.out.print("#" + test_case + " ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}