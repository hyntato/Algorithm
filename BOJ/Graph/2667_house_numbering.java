import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HouseNumbering {
	
	// 상하좌우
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static int[][] map;
	private static boolean[][] visited;
	
	private static void numbering(int n) {

		List<Integer> list = new ArrayList<Integer>();
		int num = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					list.add(dfs(i, j, ++num));  // 단지별 집의 수
				}
			}
		}
		
		System.out.println(list.size());  // 총 단지수
		Collections.sort(list);  // 오름차순
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static int dfs(int x, int y, int num) {
		
		int count = 1;

		visited[x][y] = true;
		map[x][y] = num;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<visited.length && 0<=ny && ny<visited.length) {
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					map[nx][ny] = num;
					count += dfs(nx, ny, num);
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i=0; i<n; i++) {
			String row = br.readLine();
			for (int j=0; j<n; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}

		numbering(n);
	}

}
