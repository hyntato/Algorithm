import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {
	
	private static int max = 0;
	
	private static int n, m;
	private static int[][] map;
	private static List<Point> virusList = new ArrayList<Point>();
	private static List<Point> blankList = new ArrayList<Point>();
	
	// combination: backtracking
	private static void dfs(int start, int wallNum) {
		if(wallNum == 0) {
			max = Math.max(max, blankList.size() - bfs() - 3);
			return;
		}
		
		for(int i=start; i<blankList.size(); i++) {
			Point p = blankList.get(i);
			
			map[p.x][p.y] = 1;
			dfs(i+1, wallNum-1);
			map[p.x][p.y] = 0;
		}
	}
	
	private static int bfs() {
		int count = 0;
		
		boolean[][] visited = new boolean[n][m];
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		Queue<Point> q = new LinkedList<Point>();
		
		for(int i=0; i<virusList.size(); i++) {
			Point p = virusList.get(i);
			q.offer(p);
			visited[p.x][p.y] = true;
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(!visited[nx][ny] && map[nx][ny]==0) {
						
						q.offer(new Point(nx, ny));
						visited[nx][ny] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 0) {
					blankList.add(new Point(i, j));
				}
				if(map[i][j] == 2) {
					virusList.add(new Point(i, j));
				}
			}
		}
		
		dfs(0, 3);
		System.out.println(max);
	}

}
