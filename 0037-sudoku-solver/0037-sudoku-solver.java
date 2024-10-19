class Solution {
    public void solveSudoku(char[][] brd) {
        findSol(brd);
    }

    static boolean findSol(char[][] brd){


        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(brd[r][c]=='.')
                {
                    for(int digit=1;digit<=9;digit++){
                        
                        char d=(char)(digit+'0');
                        if(isSafe(brd,r,c,digit) )
                        {
                            brd[r][c]=d;
                            if( findSol(brd))
                                return true;
                            brd[r][c]='.';
                        }
                    }
                    return false;
                }
            }

        }

        return true;
    }

    static boolean isSafe(char[][] brd,int r,int c,int digit)
    {
        char d=(char)(digit+'0');
        for(int i=0;i<9;i++)
        {
            if(brd[r][i]==d)
                return false;
            
            if(brd[i][c]==d)
                return false;
        }

        int startRowSub=(r/3)*3;
        int startColSub=(c/3)*3;

        for(int i=startRowSub;i<startRowSub+3;i++)
        {
            for(int j=startColSub;j<startColSub+3;j++)
            {
                if(brd[i][j]==d)
                    return false;
            }
        }

        return true;
    }





}