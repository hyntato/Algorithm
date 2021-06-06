import java.util.*;

class NumberGame {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int idxA = 0;
        int idxB = 0;
        
        while(idxB < B.length) {
            if(A[idxA] < B[idxB]) {
                answer++;
                idxA++;
            }
            idxB++;
        }
        return answer;
    } 
}
