import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] distance = new long[n-1];
		long[] price = new long[n-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		
		long min = Long.MAX_VALUE;
		long sum = 0;
		
		for(int i=0; i<n-1; i++) {
			if(price[i] < min)
				min = price[i];
			sum += distance[i] * min;
		}
		System.out.println(sum);
	}

}
