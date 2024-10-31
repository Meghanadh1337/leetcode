class Solution {
    public int rob(int[] a) {
        
        int n=a.length;

        int[] dp=new int[n];

        dp[0]=a[0];

        if(n>=2)
            dp[1]=Math.max( a[0] , a[1] );
        
        for(int i=2 ; i < n ; i++ )
        {
            int pickNot=dp[i-1];
            
            int pick = dp[i-2] + a[i];

            dp[i] = Math.max(pick,pickNot);
        } 

        return dp[n-1];

    }
}