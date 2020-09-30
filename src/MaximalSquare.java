public class MaximalSquare {
    int resDFS;
    public static void main(String[] args) {
        int[][] grid = {{1}};
        System.out.println(maximalSquare(grid));

    }

    public static int maximalSquare(int[][] grid){
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<n; i++){
            dp[0][i] = grid[0][i];
        }

        for(int i=0; i<m; i++){
            dp[i][0] = grid[i][0];
        }

        //dp

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(grid[i][j] == 0) dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1])+1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }



        return res*res;
    }




}

