import java.util.*;

class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> genreMap = new HashMap<>();    // <장르, 곡 정보>
        groupingGenres(genreMap, genres, plays);
        
        Map<Integer, List<int[]>> playMap = new HashMap<>();    // <장르 재생수, 곡 정보>
        int[] keys = new int[genreMap.size()];                  // [장르 재생수]
        countingPlays(genreMap, playMap, keys);
        
        Arrays.sort(keys);
        
        List<Integer> ansList = new ArrayList<>();
        chooseBestSongs(playMap, keys, ansList);
        
        int[] answer = new int[ansList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = ansList.get(i);
        }
        return answer;
    }
    
    public void groupingGenres(Map<String, List<int[]>> genreMap, String[] genres, int[] plays) {
        for(int i=0; i<genres.length; i++) {
            if(genreMap.containsKey(genres[i])) {
                genreMap.get(genres[i]).add(new int[]{i, plays[i]});
            }
            else {
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i, plays[i]});
                genreMap.put(genres[i], list);
            }
        }
    }
    
    public void countingPlays(Map<String, List<int[]>> genreMap, Map<Integer, List<int[]>> playMap, int[] keys) {
        int idx = 0;
        for(String key: genreMap.keySet()) {
            List<int[]> list = genreMap.get(key);
            Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);
            
            int sum = 0;
            for(int[] song: list) {
                sum += song[1];
            }
            
            keys[idx++] = sum;
            playMap.put(sum, list);
        }
    }
    
    public void chooseBestSongs(Map<Integer, List<int[]>> playMap, int[] keys, List<Integer> ansList) {
        for(int i=keys.length-1; i>=0; i--) {
            List<int[]> list = playMap.get(keys[i]);
            for(int j=0; j<list.size() && j<2; j++) {
                ansList.add(list.get(j)[0]);
            }
        }
    }
}
