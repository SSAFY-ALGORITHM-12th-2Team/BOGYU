package 알고리즘스터디;
import java.util.*;
public class 메모리복구_1289 {
    public static void main(String[] args) {
    	Scanner kb = new Scanner(System.in);
    	int T = kb.nextInt();
    	String m;
    	char b; 
    	int ans; 
    	for (int t=1; t<=T; t++) {
    		m = kb.next();
    		b = '0';
    		ans = 0;
    		for(int i=0; i<m.length(); i++) {
    			if(b != m.charAt(i)) {
    				b = m.charAt(i);
    				ans++;
    			}
    		}
    		System.out.printf("#%d %d\n", t, ans);
    	}
    
    }
}

