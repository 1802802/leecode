package leecode.matrix;

import java.util.*;

public class spiralOrder54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int columnIndex = 0;
        int rowIndex = 0;
        int columnMin = 0;
        int rowMin = 1;
        int columnMax = matrix[0].length - 1;
        int rowMax = matrix.length - 1;
        int area = matrix.length * matrix[0].length;
        String decretion = "right";
        while(result.size() < area) {
            switch (decretion) {
                case "right":
                    if (columnIndex < columnMax) {
                        result.add(matrix[rowIndex][columnIndex]);
                        columnIndex++;
                    } else if (columnIndex == columnMax) {
                        decretion = "down";
                        columnMax--;
                    } else {
                        result.add(matrix[rowIndex][columnIndex]);
                    }
                    break;
                case "down":
                    if (rowIndex < rowMax) {
                        result.add(matrix[rowIndex][columnIndex]);
                        rowIndex++;
                    } else if (rowIndex == rowMax) {
                        decretion = "left";
                        rowMax--;
                    } else {
                        result.add(matrix[rowIndex][columnIndex]);
                    }
                    break;
                case "left":
                    if (columnIndex > columnMin) {
                        result.add(matrix[rowIndex][columnIndex]);
                        columnIndex--;
                    } else if (columnIndex == columnMin) {
                        decretion = "up";
                        columnMin++;
                    } else {
                        result.add(matrix[rowIndex][columnIndex]);
                    }
                    break;
                case "up":
                    if (rowIndex > rowMin) {
                        result.add(matrix[rowIndex][columnIndex]);
                        rowIndex--;
                    } else if (rowIndex == rowMin) {
                        decretion = "right";
                        rowMin++;
                    } else {
                        result.add(matrix[rowIndex][columnIndex]);
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(arr));
    }
}
