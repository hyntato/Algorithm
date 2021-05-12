import java.util.*;

class MakeMin {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int len = A.length;
        
        for(int i=0; i<len; i++) {
            answer += A[i] * B[len-1-i];
        }
        return answer;
    }
}
