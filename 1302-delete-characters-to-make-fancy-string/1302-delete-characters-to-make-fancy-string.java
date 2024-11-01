class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder("");
        int count=0;
        char c=',';
        for( int i=0; i < s.length() ; i++ ){

            if( s.charAt(i)== c){

                count++;
                if(count==3)
                    count--;
                else{
                    sb.append( s.charAt(i) );
                }    
        
            }
            else{
                c=s.charAt(i);
                sb.append(c);
                count=1;
            }
        }

        return sb.toString();
    }
}