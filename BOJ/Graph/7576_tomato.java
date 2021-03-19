import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TomatoBox {

	// 상하좌우
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	
	private static int n, m;
	private static int[][] box;
	
	private static int bfs(Queue<Tomato> q) {
		
		int day = 0;
	
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			day = t.getDay();
			
			for(int i=0; i<4; i++) {
				int nx = t.getX() + dx[i];
				int ny = t.getY() + dy[i];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(box[nx][ny] == 0) {
						box[nx][ny] = 1;
						q.offer(new Tomato(nx, ny, day+1));
					}
				}
			}
		}
		// 예외사항
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 0) {
					return -1;
				}
			}
		}
		return day;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		box = new int[n][m];
		Queue<Tomato> q = new LinkedList<Tomato>();

		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					q.offer(new Tomato(i, j, 0));
				}
			}
		}
		
		System.out.println(bfs(q));
	}

}

class Tomato {
	private int x;
	private int y;
	private int day;
	
	public Tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getDay() { return day; }
	public void setDay(int day) { this.day = day; }
}
