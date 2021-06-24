import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {
	private static int maxSafeArea = 0;
	
	private static int N, M;
	private static int[][] map;
	
	private static List<int[]> blankList = new ArrayList<>();
	private static List<int[]> virusList = new ArrayList<>();

	private static void combination(int start, int r) {
		if(r == 0) {
			int count = blankList.size()-bfs()-3;
			if(maxSafeArea < count) {
				maxSafeArea = count;
			}
			return;
		}
		for(int i=start; i<blankList.size(); i++) {
			int[] loc = blankList.get(i);
			map[loc[0]][loc[1]] = 1;
			combination(i+1, r-1);
			map[loc[0]][loc[1]] = 0;
		}
	}

	private static int bfs() {
		int count = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		for(int[] loc: virusList) {
			q.offer(loc);
			visited[loc[0]][loc[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			
			for(int i=0; i<dx.length; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(!visited[nx][ny] && map[nx][ny] == 0) {
						q.offer(new int[]{nx, ny});
						visited[nx][ny] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int token = Integer.parseInt(st.nextToken());
				if(token == 0) {
					blankList.add(new int[]{i, j});
				}
				if(token == 2) {
					virusList.add(new int[]{i, j});
				}
				map[i][j] = token;
			}
		}
		
		combination(0, 3);
		System.out.println(maxSafeArea);
	}

}
