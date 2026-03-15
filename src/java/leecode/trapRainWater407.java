package leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class trapRainWater407 {
    public int trapRainWater(int[][] heightMap) {
        Map<String, Integer> firstPointMap = new HashMap<>();

        for (int i = 0; i < heightMap.length; i++) {
            int maxLeft = 0;
            Map<Integer, Integer> leftMap = new HashMap<>();
            for (int ii = 0; ii < heightMap[i].length; ii++) {
                maxLeft = Math.max(maxLeft, heightMap[i][ii]);
                leftMap.put(ii, maxLeft - heightMap[i][ii]);
            }

            int maxRight = 0;
            Map<Integer, Integer> rightMap = new HashMap<>();
            for (int ii = heightMap[i].length - 1; ii >= 0; ii--) {
                maxRight = Math.max(maxRight, heightMap[i][ii]);
                rightMap.put(ii, maxRight - heightMap[i][ii]);
            }

            for (int ii = 0; ii < leftMap.entrySet().size(); ii++) {
                firstPointMap.put(String.format("%d-%d", i, ii), Math.min(leftMap.get(ii), rightMap.get(ii)));
            }
        }

        Map<String, Integer> secondPointMap = new HashMap<>();

        for (int i = 0; i < heightMap[0].length; i++) {
            int maxLeft = 0;
            Map<Integer, Integer> leftMap = new HashMap<>();
            for (int ii = 0; ii < heightMap.length; ii++) {
                maxLeft = Math.max(maxLeft, heightMap[ii][i]);
                leftMap.put(ii, maxLeft - heightMap[ii][i]);
            }

            int maxRight = 0;
            Map<Integer, Integer> rightMap = new HashMap<>();
            for (int ii = heightMap.length - 1; ii >= 0; ii--) {
                maxRight = Math.max(maxRight, heightMap[ii][i]);
                rightMap.put(ii, maxRight - heightMap[ii][i]);
            }

            for (int ii = 0; ii < leftMap.entrySet().size(); ii++) {
                secondPointMap.put(String.format("%d-%d", ii, i), Math.min(leftMap.get(ii), rightMap.get(ii)));
            }
        }

        return firstPointMap.entrySet().stream()
                .map(entry -> Math.min(secondPointMap.get(entry.getKey()), entry.getValue()))
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
