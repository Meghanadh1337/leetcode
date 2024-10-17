class Solution {
    public void nextPermutation(int[] nums) {
        
        int n=nums.length;
        int i=n-2;

        while(i>=0 && nums[i]>=nums[i+1] )
            i--;
        
        if(i>=0){

            int j=n-1;

            while(j>=i && nums[j]<=nums[i] )
                j--;
            
            swap(nums,i,j);
        }

        reverse(nums,i+1);

    }

    static void swap(int[] a,int i,int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    static void reverse(int[] a,int i)
    {
        int j=a.length-1;

        for(int idx=i;idx<j;idx++)
        {
            swap(a,idx,j);
            j--;
        }
    }
}