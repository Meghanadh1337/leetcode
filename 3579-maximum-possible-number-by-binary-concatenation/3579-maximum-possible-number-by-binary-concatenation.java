class Solution {
    public int maxGoodNumber(int[] nums) {
        Integer[] ans=new Integer[nums.length];
        for(int i=0;i<nums.length;i++)
            ans[i]=nums[i];
        Arrays.sort( ans, (a,b)->{
            String x=Integer.toBinaryString(a);
            String y=Integer.toBinaryString(b);
            return (y+x).compareTo(x+y);
        });
        String binaryString="";
        for(Integer x:ans)
            binaryString+=Integer.toBinaryString(x);
        return Integer.parseInt(binaryString,2);

    }
}