import java.util.*;

class MenuRenewal {
    
    Map<String, Integer> courseMap = new HashMap<>();
    List<String> answerList = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        // orders를 모두 오름차순으로 정렬
        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        for(int i=0; i<course.length; i++) {
            // course 갯수 만큼의 모든 조합 구하기
            for(int j=0; j<orders.length; j++) {
                if (course[i] <= orders[j].length()) {
                    boolean[] visited = new boolean[orders[j].length()];
                    combination(0, "", orders[j], course[i], visited);
                }
            }
            // 가장 많이 주문한 조합 구하기
            if(!courseMap.isEmpty()) {
                findPopularCourse();
                courseMap.clear(); 
            }  
        }
        
        Collections.sort(answerList);
        
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public void combination(int start, String str, String order, int course, boolean[] visited) {
        if(course == 0) {
            courseMap.put(str, courseMap.getOrDefault(str, 0) + 1);
            return;
        }
        
        for(int i=start; i<order.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(i+1, str+order.charAt(i), order, course-1, visited);
                visited[i] = false;
            }
        }
    }
    
    public void findPopularCourse() {
        List<Integer> countList = new ArrayList<>(courseMap.values());
        int max = Collections.max(countList);
        
        if(max >= 2) {
            for(String key: courseMap.keySet()) {
                if(courseMap.get(key) == max)
                    answerList.add(key);
            }
        }
    }
}
