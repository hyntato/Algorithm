import java.util.*;

class PermCheck {
    public int solution(int[] A) {
        Arrays.sort(A);
        
        for(int i=0; i<A.length; i++) {
            if(i+1 != A[i]) return 0;
        }
        return 1;
    }
}

/*
import java.util.*;

class PermCheck {
    public int solution(int[] A) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();

        for(int n: A) {
            set.add(n);
        }
        if(set.size() != N) {		// 중간에 숫자가 비거나 숫자가 중복되는 경우
            return 0;
        }
        for(int i=1; i<=N; i++) {	// 1부터 N까지 연속된 숫자가 아닌 경우
            if(!set.contains(i)) {
                return 0;
            }
        }
        return 1;
    }
}
*/
