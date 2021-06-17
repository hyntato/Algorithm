import java.util.*;

class PermMissingElem {
    public int solution(int[] A) {
        Arrays.sort(A);

        int answer = 0;
        for(int i=0; i<A.length; i++) {
            if(i+1 != A[i]) {
                answer = i+1;
                break;
            }
        }
        if(answer == 0) {
            answer = A.length+1;
        }
        return answer;
    }
}
