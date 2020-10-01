import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,1},
                        {0,0,0,0,0}};
        int[] start = {0,0};
        int[] destination = {4,4};

        System.out.println(mazeSolve(grid, start, destination));
        //System.out.println(bfsSolver(grid, start, destination));
       // System.out.println(Arrays.toString(grid));
    }

    static boolean bfsSolver(int[][] grid, int[] pos, int[] dest){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        visited[pos[0]][pos[1]] = true;

        q.offer(pos);
        while(!q.isEmpty()){
            int[] cur = q.peek();
            if(cur[0]==dest[0] && cur[1]==dest[1]) return true;
            q.poll();
            for(int[] dir: directions) {
                int newX = cur[0] + dir[0];
                int newY = cur[1] + dir[1];

                if (isValid(grid, newX, newY) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    q.offer(new int[]{newX, newY});
                }

            }
        }

        return false;
    }


    static boolean mazeSolve(int[][] grid, int[] pos, int[] destination){ //dfs
        //int r = grid.length;
        //int c = grid[0].length;
        //boolean res= false;

        if(pos[0] == destination[0] && pos[1] == destination[1]){
            return true;
        }

        if(grid[pos[0]][pos[1]] == -1) return false;

        grid[pos[0]][pos[1]] = -1;

        for(int[]dir : directions){
            int x = pos[0]; int y = pos[1];
            while(isValid(grid, x+dir[0], y+dir[1])){
                x += dir[0];
                y += dir[1];
            }
            //x-=dir[0]; y-=dir[1];
            if(mazeSolve(grid, new int[]{x,y} , destination)){
                return true;
            }
        }

        return false;
    }

    static boolean isValid(int[][]grid, int x, int y){
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0;
    }
}
