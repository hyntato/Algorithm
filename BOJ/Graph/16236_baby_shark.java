import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {
	private static int N;
	private static int[][] map;
	private static int[] dx = {-1, 0, 0, 1};  // 상좌우하
	private static int[] dy = {0, -1, 1, 0};
	
	private static int time = 0;
	private static int size = 2;
	private static int eaten = 0;
	
	private static void bfs(Node node) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		q.offer(node);
		visited[node.x][node.y] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if(map[curr.x][curr.y] != 0 && map[curr.x][curr.y] < size) {
				Node next = findNearestFish(curr, q);
				map[next.x][next.y] = 0;
				time = next.dist;
				if(++eaten == size) {
					size++;
					eaten = 0;
				}
				bfs(next);
				return;
			}
			
			for(int i=0; i<dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
					if(map[nx][ny] > size) {
						continue;
					}
					if(map[nx][ny] == 0 || map[nx][ny] <= size) {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, curr.dist+1));
					}
				}
			}
		}
	}
	
	// 가장 가까운 거리, 가장 위, 가장 왼쪽 찾기
	private static Node findNearestFish(Node curr, Queue<Node> q) {
		int x = curr.x;
		int y = curr.y;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(map[node.x][node.y] == 0 || map[node.x][node.y] == size || node.dist != curr.dist) {
				continue;
			}
			if(node.x < x) {
				x = node.x;
				y = node.y;
			}
			if(node.x == x && node.y < y) {
				x = node.x;
				y = node.y;
			}
		}
		return new Node(x, y, curr.dist);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int[] sharkPos = new int[2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkPos[0] = i;
					sharkPos[1] = j;
					map[i][j] = 0;
				}
			}
		}
		
		bfs(new Node(sharkPos[0], sharkPos[1], 0));
		System.out.println(time);
	}

}

class Node {
	int x, y, dist;
	public Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}



// 또는 이중 와일문, {먹을 수 있는 물고기 모두 저장 -> 가장 가까운 물고기 찾기}로 구현하기
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark2 {
	private static int N;
	private static int[][] map;
	private static int[] dx = {-1, 0, 0, 1};  // 상좌우하
	private static int[] dy = {0, -1, 1, 0};
	
	private static int time = 0;
	private static int size = 2;
	private static int eaten = 0;
	
	private static void bfs(Node node) {
		
		while(true) {
			List<Node> fish = new ArrayList<>();
			Queue<Node> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			
			q.offer(node);
			visited[node.x][node.y] = true;
			
			while(!q.isEmpty()) {
				Node curr = q.poll();
				for(int i=0; i<dx.length; i++) {
					int nx = curr.x + dx[i];
					int ny = curr.y + dy[i];
					if(0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]) {
						if(map[nx][ny] > size) {
							continue;
						}
						if(map[nx][ny] == 0 || map[nx][ny] <= size) {
							visited[nx][ny] = true;
							q.offer(new Node(nx, ny, curr.dist+1));
						}
						if(0 < map[nx][ny] && map[nx][ny] < size) {
							fish.add(new Node(nx, ny, curr.dist+1));
						}
					}
				}
			}
			
			if(fish.size() == 0) {
				break;
			}
			
			Collections.sort(fish);
			Node next = fish.get(0);
			node = next;
			
			map[next.x][next.y] = 0;
			time = next.dist;
			if(++eaten == size) {
				size++;
				eaten = 0;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int[] sharkPos = new int[2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkPos[0] = i;
					sharkPos[1] = j;
					map[i][j] = 0;
				}
			}
		}
		
		bfs(new Node(sharkPos[0], sharkPos[1], 0));
		System.out.println(time);
	}

}

class Node implements Comparable<Node> {
	int x, y, dist;
	public Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
  
  // 가장 가까운 거리, 가장 위, 가장 왼쪽 찾기
	@Override
	public int compareTo(Node o1) {
		if(this.dist == o1.dist) {
			if(this.x == o1.x) {
				return this.y - o1.y;
			}
			return this.x - o1.x;
		}
		return this.dist - o1.dist;
	}
}
*/

