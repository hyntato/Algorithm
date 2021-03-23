import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery {
	
	private static int findMinNumOfBags(int n) {
		int count = 0;
		
		while(n >= 0) {
			if(n%5 == 0)
				return n/5 + count;
			else
   				n -= 3;
			count++;
		}
    
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(findMinNumOfBags(n));
	}

}

