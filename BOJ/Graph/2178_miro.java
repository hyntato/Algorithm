import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Miro {
	
	// 상하좌우
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
			
	private static int n, m;
	private static int[][] miro;
	private static boolean[][] visited;
	
	private static void findShortestPath(int x, int y) {
		// bfs
		Queue<Point> q = new LinkedList<Point>();
		
		q.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(!visited[nx][ny] && miro[nx][ny]==1) {
						
						q.offer(new Point(nx, ny));
						visited[nx][ny] = true;
						miro[nx][ny] = miro[p.x][p.y] + 1;
					}
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken()); 
		
		miro = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				miro[i][j] = chars[j] - '0';
			}
		}
		
		findShortestPath(0, 0);
		
		System.out.println(miro[n-1][m-1]);
	}

}
