import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TomatoBox {
  
	// 상하좌우, 앞뒤
	private static int[] dh = {0, 0, 0, 0, 1, -1};
	private static int[] dx = {0, 0, -1, 1, 0, 0};
	private static int[] dy = {-1, 1, 0, 0, 0, 0};
	
	private static int m, n, h;
	private static int[][][] box;

	private static int bfs(Queue<Tomato> q) {
		int day = 0;
	
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			day = t.getDay();
			
			for(int i=0; i<6; i++) {
				int nh = t.getH() + dh[i];
				int nx = t.getX() + dx[i];
				int ny = t.getY() + dy[i];
				
				if(0<=nh && nh<h && 0<=nx && nx<n && 0<=ny && ny<m) {
					if(box[nh][nx][ny]==0) {
						box[nh][nx][ny] = 1;
						q.offer(new Tomato(nh, nx, ny, day+1));
					}
				}
			}
		}
		// 예외사항
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(box[k][i][j] == 0) {
						return -1;
					}
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
		h = Integer.parseInt(st.nextToken());
		
		box = new int[h][n][m];
		Queue<Tomato> q = new LinkedList<Tomato>();

		for(int k=0; k<h; k++) {
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<m; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
					if(box[k][i][j] == 1) {
						q.offer(new Tomato(k, i, j, 0));
					}
				}
			}
		}
		
		System.out.println(bfs(q));
	}

}

class Tomato {
	private int h, x, y;
	private int day;
	
	public Tomato(int h, int x, int y, int day) {
		this.h = h;
		this.x = x;
		this.y = y;
		this.day = day;
	}
	public int getX() { return x; }
	public int getY() { return y; }
	public int getH() { return h; }
	public int getDay() { return day; }
}
