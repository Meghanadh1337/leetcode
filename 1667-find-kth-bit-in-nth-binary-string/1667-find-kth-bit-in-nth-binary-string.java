class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder ans=new StringBuilder("0");
        while (ans.length()<k ) {
            
            StringBuilder invert=invertString(ans);

            StringBuilder reverse=invert.reverse();

            ans.append("1"+reverse.toString() );
        }
        System.out.println(ans);
        return ans.charAt(k-1);
    }

    static StringBuilder invertString(StringBuilder s){

        StringBuilder sb=new StringBuilder("");

        for(char c:s.toString().toCharArray() )
        {
           if(c=='0')
                sb.append("1");
            else
                sb.append("0");
        }
        return sb;
    }


}