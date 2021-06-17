class OddOccurrencesInArray {
    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: A) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int answer = 0;
        for(int key: map.keySet()) {
            if(map.get(key)%2 == 1) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
