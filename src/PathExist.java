public class PathExist {

    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};


    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][]board, String word){
        int r = board.length;
        int c = board[0].length;
        boolean res = false;
        int idx = 0;
        for(int i = 0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == word.charAt(idx)){
                    if(dfs(board, word, idx, i , j)) return true;
                }
            }
        }

        return res;
    }

    private static boolean dfs(char[][] board, String word, int idx, int r, int c){
        char tmp = board[r][c];
        board[r][c] = 0;
        if(idx==word.length()-1) return true;
        boolean res = false;
        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];
            if(valid(board, nr, nc, idx+1, word)){
                res = dfs(board, word, idx+1, nr, nc);
            }
        }
        board[r][c] = tmp;
        return res;

    }

    private static boolean valid(char[][] board, int r, int c, int idx, String word){
        if(r>=0 && r<board.length && c>=0 && c<board[0].length && board[r][c]!=0 && board[r][c] == word.charAt(idx)){
            return true;
        }

        return false;
    }
}
