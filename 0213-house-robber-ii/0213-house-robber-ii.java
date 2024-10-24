class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        int first=maxAmount(nums,0,n-2);
        int last=maxAmount(nums,1,n-1);
        return Math.max(first,last);
    }

    static int maxAmount(int[] nums,int start,int end)
    {
        int n=nums.length;
        int[] dp=new int[n];

        dp[start]=nums[start];
        
        for(int i = start+1 ;i <= end ; i++ ) {
            int notPick=0;
            int pick=0;
            notPick=dp[i-1];
            if(i>1)
                pick=dp[i-2]+nums[i];
            else
                pick=nums[i];

            dp[i] = Math.max(pick,notPick );
        }
        
        return dp[end];
    }
}