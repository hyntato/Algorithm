import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree {
	private static int N, M, K;
	private static Land[][] map;
	private static int[][] nut;
	
	private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	private static void spring() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Land land = map[i][j];
				Collections.sort(land.trees);
				int cnt = land.trees.size();
				for(int k=0; k<cnt; k++) { 
					int age = land.trees.remove(0);
					if(land.nutrient >= age) {
						land.nutrient -= age;
						land.trees.add(age+1);
					} else {
						land.dead_trees.add(age);
					}
				}
			}
		}
	}
	
	private static void summer() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Land land = map[i][j];
				int cnt = land.dead_trees.size();
				for(int k=0; k<cnt; k++) {
					int age = land.dead_trees.remove(0);
					land.nutrient += age / 2;
				}
			}
		}
	}
	
	private static void fall() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int age: map[i][j].trees) {
					if(age%5 == 0) {
						for(int d=0; d<dx.length; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if(!(0<=nx && nx<N && 0<=ny && ny<N)) {
								continue;
							}
							map[nx][ny].trees.add(1);
						}
					}
				}
			}
		}
	}
	
	private static void winter() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j].nutrient += nut[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new Land[N][N];
		nut = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				nut[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new Land(5);
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			map[x-1][y-1].trees.add(age);
		}
		
		for(int i=0; i<K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		int total = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				total += map[i][j].trees.size();
			}
		}
		System.out.println(total);
	}
	
}

class Land {
	int nutrient;
	List<Integer> trees = new LinkedList<>();
	List<Integer> dead_trees = new LinkedList<>();
	public Land(int nutrient) {
		this.nutrient = nutrient;
	}
}

