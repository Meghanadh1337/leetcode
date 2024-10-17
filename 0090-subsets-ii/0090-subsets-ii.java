class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        findSubset(nums,0,new ArrayList<Integer>(),ans);
        return ans;        
    }

    static void findSubset(int[] a,int idx,List<Integer> al,List<List<Integer>> ans){

        if(idx==a.length)
        {
            ans.add(new ArrayList<Integer>(al) );
            return;
        }

        ans.add(new ArrayList<Integer>(al) );

        for(int i=idx;i<a.length;i++){

            if(i>idx && a[i]==a[i-1])
                continue;
            al.add(a[i]);
            findSubset(a,i+1,al,ans);
            al.remove(al.size()-1);

        }


    }
}