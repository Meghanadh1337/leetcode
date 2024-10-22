class Solution {
    public boolean exist(char[][] board, String word) {
       
       for(int i=0;i<board.length;i++)
       {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0) && check(board,0,i,j,word.toCharArray() ) )
                    return true;
            }
       }
       return false;

    }


    static boolean check(char[][] brd,int idx,int r,int c,char[] word)
    {
        if(idx==word.length )
            return true;
         if( !isSafe(brd,r,c) ) 
                    return false;
        
        if(word[idx]==brd[r][c] )
        {
            char temp=brd[r][c];
            brd[r][c]='#';
            
           

            int[] x={0,0,1,-1};
            int[] y={1,-1,0,0};

            for(int i=0;i<4;i++){

                int newRow=r+x[i];
                int newCol=c+y[i];


                    if(check(brd,idx+1,newRow,newCol,word) )
                        return true;
                

            }

            brd[r][c]=temp;
        }

        return false;
        
    }

    static boolean isSafe(char[][] brd,int r,int c){

        if( !( (0<=r && r<brd.length ) && (0<=c && c<brd[0].length) )  )
            return false;
        
        if( brd[r][c]=='#')
            return false;

        return true;
    }
}