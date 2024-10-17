class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> al=new ArrayList<>();
        findComb(candidates,0,target,al,ans);
        return ans;
    }

    static void findComb(int[] a,int idx,int target,List<Integer> al,List<List<Integer>> ans)
    {
        if(idx>a.length || target<0)
            return;
        if(idx==a.length){
            if(target==0)
                ans.add(new ArrayList<>(al) );
            return;
        }
        if(target==0  ){
            ans.add(new ArrayList<>(al) );
            return;
        }
        al.add(a[idx]);
        target=target-a[idx];

        findComb(a,idx,target,al,ans);

        al.remove( (Object)a[idx]);
        target=target+a[idx];

        findComb(a,idx+1,target,al,ans);
    }
}