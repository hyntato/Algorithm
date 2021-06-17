import java.util.*;

class FrogRiverOne {
    public int solution(int X, int[] A) {
        int answer = -1;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<A.length; i++) {
            if(A[i] <= X && set.add(A[i]) && set.size() == X) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
