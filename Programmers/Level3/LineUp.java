import java.util.*;

class LineUp {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        
        long fact = 1;
        for(int i=2; i<=n; i++) {
            fact *= i;
        }
        
        k--;
        int[] answer = new int[n];
        
        for(int i=0; i<answer.length; i++) {
            fact = fact / n--;
            
            int idx = (int)(k / fact);
            answer[i] = list.get(idx);
            list.remove(idx);
            
            k  = k % fact;
        }
        
        return answer;
    }
}
