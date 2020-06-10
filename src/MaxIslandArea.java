public class MaxIslandArea {

    static final int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}}; // all possible direction

    public static void main(String[] args) {

        int[][] grid = {{1,1}};

        System.out.println(maxAreaOfIsland(grid));


    }

    static int maxAreaOfIsland(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        //if(r==1||c==1) return 0;
        int maxArea = 0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    maxArea=Math.max(maxArea,dfs(grid,i,j));
                    //maxArea = Math.max(maxArea,dfsRecursion(grid, i, j));
                }
            }
        }
        return maxArea;
    }


    static int dfs(int[][] grid, int r, int c){
        int answer = 1;
        //max visited;
        grid[r][c] = -1;

        for(int[] dir:direction){
            int nr = dir[0]+r; int nc = dir[1]+c;
            if(isValid(grid, nr,nc)){
                answer += dfs(grid,nr,nc);
            }
        }
        return answer;
    }

    static boolean isValid(int[][] grid, int r, int c ){
        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] == 1){
            return true;
        }else{
            return false;
        }
    }
}
