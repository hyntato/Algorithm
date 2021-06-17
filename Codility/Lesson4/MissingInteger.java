import java.util.*;

class MissingInteger {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        int max = 1;

        for(int n: A) {
            if(n > 0) set.add(n);
        }
        for(int i=1; i<=set.size()+1; i++) {
            if(!set.contains(i)) {
                max = i;
                break;
            }
        }
        return max;
    }
}
