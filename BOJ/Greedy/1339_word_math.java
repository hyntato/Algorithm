import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordMath {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] alphabet = new int[26];
		
		for(int i=0; i<n; i++) {
			String word = br.readLine();
			for(int j=0; j<word.length(); j++) {
				alphabet[word.charAt(j)-'A'] += (int) Math.pow(10, word.length()-j-1);
			}
		}
		
		Arrays.sort(alphabet);
		
		int num = 9;
		int sum = 0;
		
		for(int i=alphabet.length-1; i>=0; i--) {
			if(alphabet[i] == 0)
				break;
			sum += alphabet[i] * num--;
		}
		
		System.out.println(sum);
	}

}
