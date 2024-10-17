class Solution {
    public List<List<String>> partition(String s) {
        List<String> al=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        char[] c=s.toCharArray();
        findComb(c,0,new StringBuilder(),al,ans);
        return ans;
    }

    static void findComb(char[] a,int idx,StringBuilder cur,List<String> al,List<List<String>> ans)
    {
        if(idx==a.length){
            ans.add(new ArrayList<>(al) );
            return;
        }

        for(int i=idx;i<a.length;i++){
            
            cur.append(a[i]);
            if(isPal(cur)) {
                al.add(cur.toString()  );
                findComb(a,i+1,new StringBuilder(),al,ans);
                al.remove(al.size()-1);
            }
        }
    }

    static boolean isPal(StringBuilder s)
    {
        StringBuilder rev=new StringBuilder(s).reverse();
        return s.toString().equals(rev.toString() );

    }
}