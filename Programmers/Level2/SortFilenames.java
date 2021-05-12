import java.util.*;

class SortFilenames {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1Arr = splitFilename(s1);
                String[] s2Arr = splitFilename(s2);
                
                if(s1Arr[0].compareTo(s2Arr[0]) == 0)  // 또는 equals()
                    return Integer.parseInt(s1Arr[1]) - Integer.parseInt(s2Arr[1]);
                else
                    return s1Arr[0].compareTo(s2Arr[0]);
            }
        });
        return files;
    }
    
    public String[] splitFilename(String str) {
        String[] split = {"", ""};
        for(char ch: str.toCharArray()) {
            if('0'<=ch && ch <= '9') break;
            else split[0] += ch;
        }
        
        split[0] = split[0].toLowerCase();
        str = str.substring(split[0].length());
        
        for(char ch: str.toCharArray()) {
            if('0'<=ch && ch <= '9') split[1] += ch;
            else  break;
        }
        return split;
    }
}
