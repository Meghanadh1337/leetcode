class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> al=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int[] a=new int[n];
        int counter=1;
        for(int i=0;i<a.length;i++)
            a[i]=counter++;
        findComb(a,0,k,al,ans);
        return ans;
    }

    static void findComb(int[] a,int idx,int size,List<Integer> al,
    List<List<Integer>> ans)
    {
        if(al.size()==size){
            ans.add(new ArrayList<Integer>(al) );
            return;
        }

        for(int i=idx;i<a.length;i++){
            al.add(a[i]);
            findComb(a,i+1,size,al,ans);
            al.remove(al.size()-1);
        }
    }
}