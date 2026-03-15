package leecode.matrix;

import java.util.HashSet;
import java.util.Set;

public class setZeroes73 {
    /*
    这道题，说实话，节省空间本身就没太大意义，主要还是要从可读性出发
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> needZeroRow = new HashSet<>();
        Set<Integer> needZeroColumn = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    needZeroRow.add(i);
                    needZeroColumn.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (needZeroRow.contains(i) || needZeroColumn.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
