import java.util.*;

class Tuple {
    public int[] solution(String s) {
        s = s.replace("},{", " ").replaceAll("[" + "{}" + "]", "");
        String[] split = s.split(" ");
        
        Arrays.sort(split, (o1,o2)->{ return o1.length()-o2.length(); });
        
        Set<Integer> set = new HashSet<Integer>();
        int[] answer = new int[split.length];
        int idx = 0;
        
        for(String str: split) {
            for(String n: str.split(",")) {
                if(set.add(Integer.parseInt(n))) {
                    answer[idx++] = Integer.parseInt(n);
                    break;
                }
            }
        }
        return answer;
    }
}
