package leecode.hash;

import java.util.*;

public class groupAnagrams49 {
    /*
    最基本的数组存储策略
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] originArray = str.toCharArray();
            Arrays.sort(originArray);
            String sortedStr = Arrays.toString(originArray);
            res.putIfAbsent(sortedStr, new ArrayList<>());
            res.get(sortedStr).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
