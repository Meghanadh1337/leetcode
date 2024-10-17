class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        findPerm(nums,0,new ArrayList<>(),ans,new boolean[nums.length]);
        return ans;
    }

    static void findPerm(int[] a,int idx,List<Integer> al,List<List<Integer>> ans,boolean[] vis){
        
        if(al.size()==a.length)
        {
            ans.add(new ArrayList<Integer>(al) );
            return;
        }


        for(int i=0;i<a.length;i++){
            if(vis[i]==false){
                al.add(a[i]);
                vis[i]=true;
                findPerm(a,i+1,al,ans,vis);
                al.remove(al.size()-1);
                vis[i]=false;
            }
            
        }

    }
}