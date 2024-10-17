class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int target) {
        Arrays.sort(a);
        List<Integer> al=new ArrayList<Integer>();
        List<List<Integer>> ans=new ArrayList<>();
        findComb(a,0,target,al,ans);
        return ans;
    }


    static void findComb(int[] a,int idx,int target,List<Integer> al,List<List<Integer>> ans)
    {
        if(target<0)
            return;
        if(target==0){
            ans.add(new ArrayList<Integer>(al) );
            return;
        }
        for(int i=idx;i<a.length;i++){

            if( i>idx && a[i]==a[i-1])
                continue;
            
            al.add(a[i]);
            findComb(a,i+1,target-a[i],al,ans);
            al.remove(al.size()-1 );

        }


    }
}