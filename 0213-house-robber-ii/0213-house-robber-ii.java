class Solution {
    public int rob(int[] a) {
        int zero=maxRob(a,0,a.length-2);
        int one=maxRob(a,1,a.length-1);

        return Math.max(zero,one);
    }

    static int maxRob(int[] a,int start,int end){

        int n=a.length;
        if(n==1)
            return a[0];
            
        int[] dp=new int[n];

        dp[start]=a[start];

        for(int i=start+1 ; i <= end ;i++){
            
            int pick=0;
            if(i==1)
                pick=a[i];
            else
                pick=dp[i-2]+a[i];

            int pickNot= dp[i-1];

            dp[i]=Math.max(pick,pickNot);
        }


        return dp[end];


    }
}