import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
    
		int[] times = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		
		int sum = 0;
		for(int i=1; i<=n; i++) {
			times[i] += times[i-1];
			sum += times[i];
		}
		System.out.println(sum);
	}

}
