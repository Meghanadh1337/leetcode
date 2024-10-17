class Solution {
    public int maximumSwap(int num) {
        char[] numArray=Integer.toString(num).toCharArray();

        int[] indexArray=new int[10];

        for(int i=0;i<numArray.length;i++){
            indexArray[numArray[i]-'0']=i;
        }

        for(int i=0;i<numArray.length;i++) {
            int cur=numArray[i]-'0';
            for(int d=9;d>cur;d--) {
                
                int lastidx=indexArray[d];

                    if(lastidx>i){
                        
                        numArray[i]=(char)(d+'0');
                        numArray[lastidx]=(char)(cur+'0');
                        return Integer.parseInt( String.valueOf(numArray) );
                    }
            }
        }

        return num;



    }
}