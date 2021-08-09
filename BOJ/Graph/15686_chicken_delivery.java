import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDelivery {
	private static int N, M;	
	private static int minDist;
	private static boolean[] visited;
	private static List<int[]> house = new ArrayList<>();  // 또는 Node 객체에 저장
	private static List<int[]> chicken = new ArrayList<>();
	
	private static void dfs(int start, int cnt) {
		if(cnt == M) {
			calcDistance();
			return;
		}
		for(int i=start; i<chicken.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
	
	private static void calcDistance() {
		int sum = 0;
		for(int[] h: house) {
			int min = 100;
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) {
					int dist = Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]);
					min = Math.min(min, dist);
				}
			}
			sum += min;
		}
		minDist = Math.min(minDist, sum);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new int[] {i, j});
				} else if(map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		minDist = house.size()*100;
		visited = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.println(minDist);
	}
}

//class Node {
//	int x, y;
//	public Node(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
