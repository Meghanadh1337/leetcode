class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> brd=new ArrayList<>();
        StringBuilder rowOfBoard = new StringBuilder();

        // Initialize an empty board
        for (int i = 0; i < n; i++) {
            rowOfBoard.append(".");
        }

        // Fill the board with empty rows
        for (int i = 0; i < n; i++) {
            brd.add(rowOfBoard.toString());
        }

       findSol(brd,0,n,ans);
       return ans;
    }

     static boolean isSafe(List<String> brd,int row,int col,int n)
    {
        System.out.println(brd);
        int orgR=row;
        int orgC=col;

        while(col>=0)
        {
            if(brd.get(row).charAt(col)=='Q' )
                return false;
            col--;
        }

        row=orgR;
        col=orgC;

        while( row>=0 && col>=0)
        {
            if(brd.get(row).charAt(col)=='Q' )
                return false;
            row--;
            col--;
        }


        row=orgR;
        col=orgC;

        while( row<n && col>=0)
        {
            if(brd.get(row).charAt(col)=='Q' )
                return false;
            row++;
            col--;
        }
        return true;
    }

    static void findSol(List<String> brd,int col,int n,List<List<String>> ans)
    {

        if(col==n)
        {
            System.out.println("yes");
            ans.add(new ArrayList<>(brd) );
            return;
        }
        
        for(int row=0;row<n;row++){

            if( isSafe(brd,row,col,n) ) {
                StringBuilder newRow=new StringBuilder(brd.get(row) );
                newRow.setCharAt(col,'Q');
                brd.set(row,newRow.toString() );

                   findSol(brd,col+1,n,ans);
            
                newRow.setCharAt(col,'.');
                brd.set(row,newRow.toString() );
        }
    }


    
   }

}