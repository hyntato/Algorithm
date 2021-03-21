import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath {

	private static int V;
	private static List<List<Vertex>> list;
	private static final int INF = Integer.MAX_VALUE;

	private static void findShortestPath(int start) {
    
		int[] distance = new int[V+1];
		Arrays.fill(distance, INF);
		
		dijikstra(start, distance);
		
		for (int i=1; i<=V; i++) {
			if (distance[i] == INF)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

	private static void dijikstra(int start, int[] distance) {
    
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

		distance[start] = 0;
		pq.offer(new Vertex(start, distance[start]));

		while (!pq.isEmpty()) {
			// 최소 거리의 정점
			int curr = pq.poll().getIdx();
			
			if(visited[curr]) continue;

			visited[curr] = true;
			
			// curr를 거쳐가는 거리 vs 기존 거리
			for (Vertex vertex : list.get(curr)) {
				int idx = vertex.getIdx();
				int dist = vertex.getDist();

				if (distance[curr] + dist < distance[idx]) {
					distance[idx] = distance[curr] + dist;
					pq.offer(new Vertex(idx, distance[idx]));
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());

		list = new ArrayList<List<Vertex>>();
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<Vertex>());
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.get(u).add(new Vertex(v, w));
		}

		findShortestPath(start);
	}

}

class Vertex implements Comparable<Vertex> {

	private int idx;
	private int dist;

	public Vertex(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}
	public int getIdx() { return idx; }
	public int getDist() { return dist; }

	@Override
	public int compareTo(Vertex v) {
		return this.dist - v.dist;
	}

}
