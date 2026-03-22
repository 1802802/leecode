package leecode.normal_array;

import java.util.*;

public class merge56 {
    public int[][] merge(int[][] intervals) {
        intervals = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(a -> a[0]))
                .toArray(int[][]::new);
        List<int[]> list = new ArrayList<>();
        for (int[] currentRange : intervals) {
            if (list.isEmpty()) {
                list.add(currentRange);
            } else {
                int[] latestRange = list.get(list.size() - 1);
                if (currentRange[0] <= latestRange[1]) {
                    latestRange[1] = Math.max(currentRange[1], latestRange[1]);
                } else {
                    list.add(currentRange);
                }
            }
        }
        return list.toArray(new int[0][]);
    }
}
