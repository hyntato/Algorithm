import java.util.*;

class Distinct {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int n: A) {
            set.add(n);
        }
        return set.size();
    }
}
