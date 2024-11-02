class Solution {
    public int minFallingPathSum(int[][] a) {
        int n = a.length;
        
        // Create a DP array to store minimum path sums up to each cell
        int[][] dp = new int[n][n];
        
        for (int j=0;j<n ; j++ )
            dp[0][j] = a[0][j];
        
        // Fill the DP table from the first row to the last row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                int up = Integer.MAX_VALUE;
                int upleft = Integer.MAX_VALUE;
                int upright = Integer.MAX_VALUE;
                
                // Check the cell directly above
                if (i >= 1) {
                    up = dp[i - 1][j];
                }
                
                // Check the cell above and to the left
                if (i >= 1 && j >= 1) {
                    upleft = dp[i - 1][j - 1];
                }
                
                // Check the cell above and to the right
                if (i >= 1 && j + 1 < n) {
                    upright = dp[i - 1][j + 1];
                }
                
                // Calculate the minimum path sum to the current cell
                dp[i][j] = Math.min(up, Math.min(upleft, upright)) + a[i][j];
            }
        }

        // Find the minimum value in the last row of the DP table
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        
        return min;
    }

}
