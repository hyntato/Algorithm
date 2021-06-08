import java.util.*;

class ExpressAsN {
    private Set<Integer>[] dp = new HashSet[9];
    
    public int solution(int N, int number) {
        for(int i=1; i<dp.length; i++) {
            dp[i] = new HashSet<Integer>();
        }
        
        int answer = -1;
        for(int i=1; i<dp.length; i++) {
            // 1. NN...N
            int nN = N;
            for(int k=1; k<i; k++) {
                nN = nN * 10 + N;
            }
            dp[i].add(nN);
          
            // 2. dp[j]와 dp[i-j] 사칙연산
            for(int j=1; j<i; j++) {
                doOperation(i, j, N);
            }
            
            // 3. N을 i개 사용하여 number를 표현하면 break
            if(dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public void doOperation(int i, int j, int N) {
        Set<Integer> set1 = dp[j];
        Set<Integer> set2 = dp[i-j];
        
        for(int n1: set1) {
            for(int n2: set2) {
                dp[i].add(n1+n2);
                dp[i].add(n1-n2);
                dp[i].add(n1*n2);
                if(n2 != 0) dp[i].add(n1/n2);
            }
        }
    }
}
