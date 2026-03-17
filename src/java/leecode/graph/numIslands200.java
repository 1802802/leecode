package leecode.graph;

public class numIslands200 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    void dfs(char[][] grid, int row, int column) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        if (row >= 0 && column >= 0 && row < rowLength && column < columnLength && grid[row][column] == '1') {
            grid[row][column] = '0';
            dfs(grid, row - 1, column);
            dfs(grid, row + 1, column);
            dfs(grid, row, column - 1);
            dfs(grid, row, column + 1);
        }
    }
}
