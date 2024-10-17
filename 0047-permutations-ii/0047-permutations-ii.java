class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
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
            
            if(i>0 && a[i]==a[i-1] && vis[i-1]==false)
                continue;
        
            if(vis[i]==false){
                vis[i]=true;
                al.add(a[i]);

                
                findPerm(a,i+1,al,ans,vis);

                vis[i]=false;
                al.remove(al.size()-1);

            }
        }

    }
}