class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] a={1,2,3,4,5,6,7,8,9};
        List<Integer> al=new ArrayList<Integer>();
        List<List<Integer>> ans=new ArrayList<>();
        findComb(a,0,n,k,al,ans);
        return ans;
    }

    static void findComb(int[] a,int idx,int target,int size,List<Integer> al,List<List<Integer>> ans){

        if(al.size()>size)
            return;
        else if(target<0)
            return;
        else if(target==0 && al.size()==size)
        {
            ans.add(new ArrayList<>(al) );
            return;
        }

        for(int i=idx;i<a.length;i++){
            al.add(a[i]);
            findComb(a,i+1,target-a[i],size,al,ans);
            al.remove(al.size()-1);
        }


    }
}