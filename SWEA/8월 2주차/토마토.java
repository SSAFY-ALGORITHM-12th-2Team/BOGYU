package section7;
import java.util.*;

class Point2 {
	public int x;
	public int y;
	public Point2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class 토마토 {
	static int board[][];
	static int check[][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static Queue<Point2> q = new LinkedList<>();
	static int a, b;
	static int max_sum = Integer.MIN_VALUE;
	public static  void BFS() {
		while(!q.isEmpty()) {
			Point2 v = q.poll();
			for(int i=0; i<4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < b && ny < a && board[nx][ny] ==0) {
					board[nx][ny] = 1;
					check[nx][ny] = check[v.x][v.y] + 1;
					q.offer(new Point2(nx, ny));
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		토마토 T = new 토마토();
		Scanner kb = new Scanner(System.in);
		a = kb.nextInt();
		b = kb.nextInt();
		board = new int[b][a];
		check = new int[b][a];
		for (int i=0; i<b; i++) {
			for(int j=0; j<a; j++) {
				board[i][j] = kb.nextInt();
				if(board[i][j]==1) q.offer(new Point2(i, j));
				
			}
		}
		T.BFS();
		boolean flag=true;
		int answer=Integer.MIN_VALUE;
		for(int i=0; i<b; i++){
			for(int j=0; j<a; j++){
				if(board[i][j]==0) flag=false;
			}
		}
		if(flag){
			for(int i=0; i<b; i++){
				for(int j=0; j<a; j++){
					answer=Math.max(answer, check[i][j]);
				}
			}
			System.out.println(answer);
		}
		else System.out.println(-1);
	}
}
		



