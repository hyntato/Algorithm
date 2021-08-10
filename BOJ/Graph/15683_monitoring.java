import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Monitoring {
	private static int N, M;
	private static int answer;
	private static int[][] map;
	private static int[][] tmp;
	
	private static boolean[] visited;
	private static List<CCTV> cctvList = new ArrayList<>();
	private static List<String> order = new ArrayList<>();
	
	// 상하좌우
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	// cctv별 탐색 가능한 방향
	private static int[][][] cctvDir = 
			{{{0}, {1}, {2}, {3}},
			{{0, 1}, {2, 3}},
			{{0, 3}, {3, 1}, {2, 1}, {2, 0}},
			{{2, 0, 3}, {0, 3, 1}, {3, 2, 1}, {1, 2, 0}}, 
			{{0, 1, 2, 3}}};
	
	private static void dfs(int start, int cnt, String od) {
		if(cnt == cctvList.size()) {
			order.add(od);
			return;
		}
		for(int i=start; i<cctvList.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				for(int j=0; j<cctvDir[cctvList.get(i).num-1].length; j++) {
					dfs(i+1, cnt+1, od+j);
				}
				visited[i] = false;
			}
		}
	}
	
	private static void monitoring() {
		for(String od: order) {
			copyMap();
			for(int i=0; i<cctvList.size(); i++) {
				CCTV cctv = cctvList.get(i);
				int dir = od.charAt(i)-'0';
				for(int j=0; j<cctvDir[cctv.num-1][dir].length; j++) {
					move(cctv.x, cctv.y, cctvDir[cctv.num-1][dir][j]);
				}
				
			}
			answer = Math.min(answer, countBlind());
		}
	}
	
	private static void move(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(0<=nx && nx<N && 0<=ny && ny<M) {
			if(tmp[nx][ny] != 6) {
				tmp[nx][ny] = -1;
				move(nx, ny, dir);
			}
		}
	}
	
	private static void copyMap() {
		tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	}
	
	private static int countBlind() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tmp[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = N*M;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(1<=map[i][j] && map[i][j]<=5) {
					cctvList.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		
		visited = new boolean[cctvList.size()];
		dfs(0, 0, "");
		monitoring();
		System.out.println(answer);
	}
}

class CCTV {
	int x, y, num;
	public CCTV(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

