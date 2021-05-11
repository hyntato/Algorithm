import java.util.*;

class Cache {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length*5;
        
        int runtime = 0;
        List<String> list = new ArrayList<>();
        
        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (list.contains(city)) {
                runtime += 1;
                list.remove(city);
                list.add(city);
            }
            else {
                runtime += 5;
                if (list.size() == cacheSize) list.remove(0);
                list.add(city);
            }
        }
        return runtime;
    }
}
