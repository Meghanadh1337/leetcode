class Solution {
    public List<String> letterCombinations(String digits) {
        String[] a={"abc","def","ghi","jkl","mno","pqrs","tuv",
        "wxyz" };
        List<String> dict=new ArrayList<String>(Arrays.asList(a) );

        List<String> ans=new ArrayList<String>();

        findComb(digits.toCharArray(),0,new StringBuilder(""),ans,dict);

        return ans;

    }

    static void findComb(char[] a,int i,StringBuilder cur,List<String> ans,List<String> dict){

        if(i==a.length)
         {   
            if(cur.length()!=0)
                ans.add(cur.toString() );
             return;
         }
        
     

            char c=a[i];
            int number=(int)(c-'0');
            String map=dict.get(number-2);

            for(char alpha:map.toCharArray() ){

                cur.append(alpha);

                findComb(a,i+1,cur,ans,dict);

                cur.deleteCharAt(cur.length()-1 );
            }

        

    }
}