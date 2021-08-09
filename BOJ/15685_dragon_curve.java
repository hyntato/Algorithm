import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DragonCurve {
	private static boolean[][] map = new boolean[101][101];
	private static int[] dx = {0, -1, 0, 1};
	private static int[] dy = {1, 0, -1, 0};
	
	// 스택으로 구현해도 괜찮을듯!
	private static void findPath(int[] path, int x, int y, int d, int g) {
		path[0] = d;
		for(int i=0; i<g; i++) {
			int end = (int)Math.pow(2, i);
			int off = 0;
			while(off < end) {
				path[end+off] = (path[end-1-off]+1) % 4;
				off++;
			}
		}
	}
	
	private static void drawPath(int[] path, int x, int y) {
		map[x][y] = true;
		for(int i=0; i<path.length; i++) {
			int nx = x + dx[path[i]];
			int ny = y + dy[path[i]];
			map[nx][ny] = true;
			x = nx;
			y = ny;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int[] path = new int[(int)Math.pow(2, g)];
			findPath(path, x, y, d, g);
			drawPath(path, x, y);
		}
		
		int cnt = 0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
