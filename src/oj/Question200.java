package oj;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qindingkang on 2020/4/3.
 */
public class Question200 {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    //深度优先
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        //遍历整个二维数组
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    //广度优先搜索
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        //行数
        int nr = grid.length;
        //列数
        int nc = grid[0].length;
        int num_islands = 0;

        int max = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> queue = new LinkedList<>();
                    //当前为1的位置
                    queue.add(r * nc + c);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        //通过id获取行列
                        int row = id / nc;
                        int col = id % nc;
                        //判断当前的位置的上方位置是否为1，如果为1，则加入到queue中，并同时设置为0
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            queue.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        //判断当前位置的下方位置是否为1
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            queue.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        //判断当前位置的左边位置是否为1
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            queue.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        //判断当前位置的右边位置是否为1
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            queue.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                        max = Math.max(queue.size(),max);
                    }
                }
            }
        }

        System.out.println(max);

        return num_islands;
    }


    public static void main(String[] args) {

        char[][] a = new char[20][15];

        for (int i=0;i<20;i++){

            for (int j=0;j<15;j++){
                a[i][j] = '1';
            }

        }
        new Question200().numIslands1(a);
    }
    
}
