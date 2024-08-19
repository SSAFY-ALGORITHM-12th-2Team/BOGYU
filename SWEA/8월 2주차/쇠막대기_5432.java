package 알고리즘스터디;
import java.util.*;
public class 쇠막대기_5432 {
	public static void main(String args[]) throws Exception
	{
        Scanner kb = new Scanner(System.in);
        
        int test_case = kb.nextInt();
        kb.nextLine(); // 버퍼 비우기
        
        for (int t=1; t<=test_case; t++) {
            String s = kb.nextLine();
            Stack<Character> stack = new Stack<>();
            int result = 0;
            
            for (int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    stack.pop();
                    if (s.charAt(j-1) == '(') {
                        // 레이저일 경우
                        result += stack.size();
                    } else {
                        // 쇠막대기의 끝일 경우
                        result++;
                    }
                }
            }
            
            System.out.println("#" + t + " " + result);
        }
        
        kb.close();
    }
}