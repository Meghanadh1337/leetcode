class Solution {
    public int maxUniqueSplit(String s) {
        return splitString(s.toCharArray(),0,new StringBuilder(""),new HashSet<String>() );
    }

    static int splitString(char[] a,int idx,StringBuilder s,HashSet<String> ans)
    {
        if(idx==a.length)
            return ans.size();

        int maxCount=0;
        for(int i=idx;i<a.length;i++)
        {
            s.append(a[i]);

            if(ans.contains(s.toString() ) == false ){
                
                ans.add(s.toString() );

                maxCount=Math.max(maxCount,splitString(a,i+1,new StringBuilder(""),ans) );

                ans.remove(s.toString() );
            }
        }

        return maxCount;


    }
}