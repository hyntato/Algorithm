import java.util.*;

class HIndex {
  
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int hIndex = citations.length;
        for(int i=0; i<citations.length; i++) {
            if(hIndex <= citations[i]) break;
            hIndex--;
        }
        return hIndex;
    }
  
}
/*
[3, 0, 6, 1, 5]

5편의 논문은 0회 이상 인용됨
4편의 논문은 1회 이상 인용됨
3편의 논문은 3회 이상 인용됨
2편의 논문은 5회 이상 인용됨
1편의 논문은 6회 이상 인용됨
*/
