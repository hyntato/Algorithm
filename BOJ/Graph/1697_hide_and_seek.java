import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
	
	private static int getFastestTime(int n, int k) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visited = new int[1000001];
		
		q.offer(n);
		visited[n] = 0;
		
		while(!q.isEmpty()) {
			n = q.poll();
			
			if(n == k) break;
			
			if(0<n && visited[n-1] == 0) {
				q.offer(n-1);
				visited[n-1] = visited[n] + 1;
			}
			if(n<1000000 && visited[n+1] == 0) {
				q.offer(n+1);
				visited[n+1] = visited[n] + 1;
			}
			if(n*2<=1000000 && visited[n*2] == 0) {
				q.offer(n*2);
				visited[n*2] = visited[n] + 1;
			}
		}
		return visited[k];
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());  // 수빈이 위치
		int k = Integer.parseInt(st.nextToken());  // 동생 위치
		
		System.out.println(getFastestTime(n, k));
	}

}
