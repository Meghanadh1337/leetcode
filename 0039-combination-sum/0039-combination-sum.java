class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> al=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        check(candidates,0,target,al,ans);
        return ans;
    }

    static void check(int[] a,int idx,int target,List<Integer> al,
    List<List<Integer>> ans)
    {
        if(target<0)
            return;
        if(target==0){
                ans.add(new ArrayList<>(al) );
                return;
        }
          
        for(int i=idx;i<a.length;i++)
        {
            al.add(a[i]);
            check(a,i,target-a[i],al,ans);
            al.remove( (Object)a[i]);

        }

    }
}