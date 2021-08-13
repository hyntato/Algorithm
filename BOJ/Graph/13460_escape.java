import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Escape {
	private static int cnt = 0;
	private static int N, M;
	private static char[][] map;
	private static boolean[][][][] visited;
	
	private static int[] red;
	private static int[] blue;
	private static int[] hole;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static void bfs() {
		Queue<Ball> q = new LinkedList<>();
		q.offer(new Ball(red, blue, 0));
		visited[red[0]][red[1]][blue[0]][blue[1]] = true;
		
		while(!q.isEmpty()) {
			Ball ball = q.poll();
			if(ball.depth == 10) {
				continue;
			}
			red = ball.red;
			blue = ball.blue;
			for(int i=0; i<dx.length; i++) {
				int[] next_red = new int[2];
				int[] next_blue = new int[2];
        
				if((i==0 && red[0]<blue[0]) || (i==1 && red[0]>blue[0]) || (i==2 && red[1]<blue[1]) || (i==3 && red[1]>blue[1])) {
					next_red = moveBall(red[0], red[1], blue, i);
					next_blue = moveBall(blue[0], blue[1], next_red, i);
				} else {
					next_blue = moveBall(blue[0], blue[1], red, i);
					next_red = moveBall(red[0], red[1], next_blue, i);
				}
        
				if(visited[next_red[0]][next_red[1]][next_blue[0]][next_blue[1]]) {
					continue;
				}
				if(isSamePosition(hole, next_red) && isSamePosition(hole, next_blue)) {  // 두 공 모두 구멍으로 들어감
					continue;
				}
				if(isSamePosition(hole, next_blue) && !isSamePosition(hole, next_red)) {  // 파란공 먼저 구멍으로 들어감
					continue;
				}
				if(isSamePosition(hole, next_red) && !isSamePosition(hole, next_blue)) {  // 성공!
					cnt = ball.depth + 1;
					return;
				}
        
				visited[next_red[0]][next_red[1]][next_blue[0]][next_blue[1]]  = true;
				q.offer(new Ball(next_red, next_blue, ball.depth+1));
			}
		}
		cnt = -1;
	}
	
	private static int[] moveBall(int x, int y, int[] another, int dir) {
		int nx = x;
		int ny = y;
		while(true) {
			nx = x + dx[dir];
			ny = y + dy[dir];
			if(!(0<=nx && nx<N && 0<=ny && ny<M)) {
				break;
			}
			if(map[nx][ny] == 'O'){
				x = nx;
				y = ny;
				break;
			}
			if(isSamePosition(new int[] {nx, ny}, another) || map[nx][ny] == '#') {
				break;
			}
			x = nx;
			y = ny;
		}
		return new int[] {x, y};
	}
	
	private static boolean isSamePosition(int[] pos1, int[] pos2) {
		return (pos1[0] == pos2[0] && pos1[1] == pos2[1]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		red = new int[2];
		blue = new int[2];
		hole = new int[2];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
			if(str.contains("R")) {
				red[0] = i;
				red[1] = str.indexOf("R");
			}
			if(str.contains("B")) {
				blue[0] = i;
				blue[1] = str.indexOf("B");
			}
			if(str.contains("O")) {
				hole[0] = i;
				hole[1] = str.indexOf("O");
			}
		}
		bfs();
		System.out.println(cnt);
	}

}

class Ball {
	int[] red, blue;
	int depth;
	public Ball(int[] red, int[] blue, int depth) {
		this.red = red;
		this.blue = blue;
		this.depth = depth;
	}
}
