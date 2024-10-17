class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        findSubset(nums,0,new ArrayList<Integer>(),ans);
        return ans;
    }

    static void findSubset(int[] a,int idx,List<Integer> al,List<List<Integer>> ans){
        ans.add(new ArrayList<>(al) );
        

        for(int i=idx;i<a.length;i++){
            al.add(a[i]);
            findSubset(a,i+1,al,ans);
            al.remove(al.size()-1);
        }

    }
}