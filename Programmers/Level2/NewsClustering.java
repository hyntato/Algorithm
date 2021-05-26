import java.util.*;

class NewsClustering {
    public int solution(String str1, String str2) {
        List<String> str1List = new ArrayList<String>();
        List<String> str2List = new ArrayList<String>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0; i<str1.length()-1; i++) {
            String str = str1.substring(i, i+2);
            if('a'<=str.charAt(0) && str.charAt(0)<='z' && 'a'<=str.charAt(1) && str.charAt(1)<='z') {
                str1List.add(str);
            }
        }
        for(int i=0; i<str2.length()-1; i++) {
            String str = str2.substring(i, i+2);
            if('a'<=str.charAt(0) && str.charAt(0)<='z' && 'a'<=str.charAt(1) && str.charAt(1)<='z') {
                str2List.add(str);
            }
        }
      
        if(str1List.size() == 0 && str2List.size() == 0) return 1 * 65536;
        
        int inter = 0;
        Iterator iter = str1List.iterator();
        while(iter.hasNext()) {
            String str = (String)iter.next();
            if(str2List.contains(str)) {
                inter++;
                iter.remove();
                str2List.remove(str);
            }
        }
        int union = str1List.size() + str2List.size() + inter;
        
        return (int) ((inter / (double)union) * 65536);
    }
}
