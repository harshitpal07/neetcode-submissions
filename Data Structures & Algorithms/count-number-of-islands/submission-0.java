class Solution {
    boolean valid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    void dfs(char[][] a, int n, int m, int i, int j,
             boolean[][] vis) {

        vis[i][j] = true;

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {

            int row = i + di[k];
            int col = j + dj[k];

            if (valid(row, col, n, m)
                    && vis[row][col] == false
                    && a[row][col] == '1') {

                dfs(a, n, m, row, col, vis);
            }
        }
        return;
    }

    public int numIslands(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        int res = 0;

        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '1' && vis[i][j] == false) {
                    dfs(a, n, m, i, j, vis);
                    res++;
                }
            }
        }
        return res;
    }
}