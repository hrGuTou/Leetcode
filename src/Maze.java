import java.util.Arrays;

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
       // System.out.println(Arrays.toString(grid));
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
        if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==0){
            return true;
        }else{
            return false;
        }
    }
}
