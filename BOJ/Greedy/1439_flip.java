import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Flip {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] count = new int[2];
		
		char pre = s.charAt(0);
		
		for(int i=1; i<s.length(); i++) {
			if(pre != s.charAt(i)) {
				count[pre-'0']++;
				pre = s.charAt(i);
			}
		}
		
		count[pre-'0']++;
		
		System.out.println(Math.min(count[0], count[1]));
	
		/*// StringTokenizer를 이용한 풀이
		String zero = s.replaceAll("1", " ");
		String one = s.replaceAll("0", " ");
		
		int zeroCount = new StringTokenizer(zero).countTokens();
		int oneCount = new StringTokenizer(one).countTokens();
		
		System.out.println(Math.min(zeroCount, oneCount));
		*/
	}
}
