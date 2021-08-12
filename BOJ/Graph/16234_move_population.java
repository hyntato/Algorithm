// BFS, 리스트에 연합국 좌표 저장, 연합국별 move
public class MovePopulation {
	private static int N, L, R;
	private static int[][] map;
	private static boolean[][] opened;
	private static List<Country> list;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static int bfs(int x, int y) {
		Queue<Country> q = new LinkedList<>();
		list = new ArrayList<Country>();
		
		q.offer(new Country(x, y));
		opened[x][y] = true;
		int sum = 0;
		
		while(!q.isEmpty()) {
			Country c = q.poll();
			list.add(new Country(c.x, c.y));
			sum += map[c.x][c.y];
			
			for(int i=0; i<dx.length; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					int diff = Math.abs(map[c.x][c.y]-map[nx][ny]);
					if(!opened[nx][ny] && L<=diff && diff<=R) {
						opened[nx][ny] = true;
						q.offer(new Country(nx, ny));
					}
				}
			}
		}
		return sum;
	}
	
	private static void move(int population) {
		for(Country c: list) {
			map[c.x][c.y] = population;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while(true) {
			opened = new boolean[N][N];
			boolean moved = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(opened[i][j]) {
						continue;
					}
					int sum = bfs(i, j);
					int cnt = list.size();
					if(cnt > 1) {
						moved = true;
						move(sum / cnt);
					}
				}
			}
			if(!moved) break;
			day++;
		}
		System.out.println(day);
	}

}

class Country {
	int x, y;
	public Country(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


// DFS, tmp배열에 연합국별 인덱스 저장, 하루 단위 move
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MovePopulation2 {
	private static int N, L, R;
	private static int sum, cnt;
	
	private static int[][] map;
	private static int[][] tmp;
	private static boolean[][] opened;
	private static List<Country> country = new ArrayList<>();
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static void dfs(int x, int y, int idx) {
		for(int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				int diff = Math.abs(map[x][y]-map[nx][ny]);
				if(!opened[nx][ny] && L<=diff && diff<=R) {
					opened[nx][ny] = true;
					tmp[nx][ny] = idx;
					cnt++;
					sum += map[nx][ny];
					dfs(nx, ny, idx);
				}
			}
		}
	}
	
	private static void move(int idx) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(1<=tmp[i][j] && tmp[i][j]<=idx) {
					map[i][j] = country.get(tmp[i][j]-1).population;
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		int idx = 1;
		while(true) {
			opened = new boolean[N][N];
			tmp = new int[N][N];
			boolean moved = false;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!opened[i][j]) {
						sum = 0;
						cnt = 0;
						dfs(i, j, idx);
						if(cnt > 0) {
							country.add(new Country(sum, cnt));
							moved = true;
							idx++;
						}
					}
				}
			}
			if(!moved) {
				break;
			}
			move(idx);
			day++;
		}
		System.out.println(day);
	}

}

class Country {
	int total, cnt, population;
	public Country(int total, int cnt) {
		this.total = total;
		this.cnt = cnt;
		this.population = total / cnt;
	}
}
*/
