import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSorting {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int total = 0;
		
		while(pq.size() > 1) {
			int count = pq.poll() + pq.poll();
			total += count;
			pq.offer(count);
		}
		
		System.out.println(total);
	}

}
