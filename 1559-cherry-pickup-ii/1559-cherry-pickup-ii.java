class Solution {
    public int cherryPickup(int[][] a) {

        int r=a.length;
        int c = a[0].length;

        int[][][] dp = new int[r][c][c];


        for(int j1=0; j1<c ;j1++){
            for(int j2=0;j2<c;j2++){
                if(j1==j2)
                    dp[r-1][j1][j2] = a[r-1][j1];
                else
                    dp[r-1][j1][j2] = a[r-1][j1] + a[r-1][j2] ;
            }
        }


        for ( int i=r-2; i>=0 ; i-- ){

            for( int j1=0; j1 < c ; j1++){

                for(int j2=0; j2< c; j2++ ){
                        int maxi=Integer.MIN_VALUE;
                        for(int dj1=-1;dj1<=1;dj1++){
                            for(int dj2=-1; dj2<=1 ; dj2++){

                                int ans= 0 ;

                                if( j1== j2)
                                    ans = a[i][j1];
                                else
                                    ans= a[i][j1] + a[i][j2];
                                
                                int c1=j1+dj1;
                                int c2=j2+dj2;
                                if( 0<=c1 && c1<c && 0<=c2 && c2<c)
                                    ans = ans + dp[i+1][c1][c2];
                                else
                                    ans = -(int)(1e8);

                            maxi=Math.max(maxi,ans);

                            }
                        }

                        dp[i][j1][j2]=maxi;

                }

            }


        }


        return dp[0][0][c-1];
        
        
    }
}