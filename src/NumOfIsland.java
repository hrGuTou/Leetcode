public class NumOfIsland {
    static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};

        System.out.println(numIslands(grid));

    }

    static int numIslands(char[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int answer = 0;

        for(int i=0;i<r;i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i,j);
                    answer++;
                }
            }
        }
     return answer;
    }

    static void dfs(char[][] grid, int r, int c){
        grid[r][c] = 'A';
        for(int[]dir: directions){
            int nr= dir[0]+r;
            int nc = dir[1]+c;
            if(isValid(grid, nr,nc)){
                dfs(grid, nr, nc);
            }
        }

    }

    static boolean isValid(char[][] grid, int r, int c){
        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1'){
            return true;
        }else{
            return false;
        }
    }
}
