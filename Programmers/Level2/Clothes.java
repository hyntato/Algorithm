import java.util.*;

class Clothes {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
      
        for(String[] c: clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        int count = 1;
        for(int n: map.values()) {
            count *= n+1;
        }
        return count-1;
    }
}
