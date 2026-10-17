/*
I am at 0,0 and I have to reach m - 1, n - 1

I have to find all the possilbe way to reach there

two movements are allowed either right or down

we can do dfs to find all possible way

But it is too inefficient as we  are calulating for same place again and again

what if we use dp? like by how many place we can reach current plac

we can reach current place either by top or by right

*/

class Solution {
    public int uniquePaths(int m, int n) {
        // first approach
        // int[] ans = new int[1];
        // dfs(0, 0, m, n, ans);
        // return ans[0];

        // 2nd approach
        // if (m == 1 && n == 1)
        //     return 1;
        // if (m < 1 || n < 1)
        //     return 0;

        // return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);


        int[][] dp = new int[m][n];
        for(int row = 0; row < m; row++){
                dp[row][0] = 1;

        }

        for(int col = 0; col < n; col++){
            dp[0][col] = 1;
        }

        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        return dp[m-1][n-1];
    }

    // private void dfs(int i, int j, int m, int n, int[] ans){
    //     if(i >= m || j >= n) return;

    //     if(i == m - 1 && j == n - 1) ans[0]++;

    //     //down
    //     dfs(i + 1, j, m, n, ans);

    //     // right
    //     dfs(i, j + 1, m, n, ans);
    // }
}
