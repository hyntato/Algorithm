// 각 요소의 왼쪽 구간 중 최솟값, 오른쪽 구간 중 최솟값을 구하여 각각 배열에 저장
class Balloon {
    public int solution(int[] a) {
        int N = a.length;
        int[] minL = new int[N];
        int[] minR = new int[N];
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            if(a[i] < min) {
                min = a[i];
            }
            minL[i] = min;
        }
        
        min = Integer.MAX_VALUE;
        for(int i=N-1; i>=0; i--) {
            if(a[i] < min) {
                min = a[i];
            }
            minR[i] = min;
        }
        
        int answer = 0;
        for(int i=0; i<N; i++) {
            if(!(minL[i]<a[i] && minR[i]<a[i])) {
                answer++;
            }
        }
        return answer;
    }
}

/*
import java.util.*;

class Balloon {
    public int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        int minL = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        
        for(int i=0; i<a.length; i++) {
            minL = Math.min(minL, a[i]);
            minR = Math.min(minR, a[a.length-1-i]);
            set.add(minL);
            set.add(minR);
        }
        return set.size();
    }
}
*/
