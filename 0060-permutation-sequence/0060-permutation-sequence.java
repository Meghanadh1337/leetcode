class Solution {
    public String getPermutation(int n, int k) {
        int[] fact=new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++)
            fact[i]=fact[i-1]*i;
        
        StringBuilder ans=new StringBuilder("");
        ArrayList<Integer> al=new ArrayList<>();

        for(int i=1;i<=n;i++)
            al.add(i);
        k--;
        while(ans.length()!=n){

            int size=al.size();
            int index=k/fact[size-1];

            ans.append( al.get(index) );
            al.remove( index );
            k=k%fact[size-1];

        }

        return ans.toString();



    }
}