class Solution {
    public int uniquePathsWithObstacles(int[][] a) {

        int r = a.length;

        int c = a[0].length;

        int[][] dp = new int[r][c];

        if(a[0][0]==0)
            dp[0][0] = 1;

        for ( int i=0; i < r ; i++ ){

            for( int j = 0 ; j < c ; j++ ){

                if( i==0 && j==0 )
                    continue;

                if(a[i][j]==1)
                    continue;
                
                int left = 0;
                int up = 0;

                if( i >= 1 && a[i-1][j]==0 )
                    up = dp[i-1][j];
                if( j >= 1 && a[i][j-1]==0 )
                    left = dp[i][j-1];
                
                dp[i][j]=left+up;

            }
        }


        return dp[r-1][c-1];

        
    }
}