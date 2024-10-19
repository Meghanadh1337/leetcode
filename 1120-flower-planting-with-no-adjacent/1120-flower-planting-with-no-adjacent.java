class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        for(int[] path:paths)
        {
            path[0]--;
            path[1]--;
        }
        
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<Integer>() );
        }

         for(int[] path:paths)
        {
            create(path,graph);
        }
        int[] flower=new int[n];
        for(int i=0;i<n;i++)
            flower[i]=-1;
        
        findSol(flower,graph,n);
        return flower;
    }

    static void create(int[] path,List<List<Integer>> graph){
        graph.get(path[0]).add(path[1]);
        graph.get(path[1]).add(path[0]);
    }



    static boolean isSafe(int type,int[] flower,int garden,List<List<Integer>> graph){

        List<Integer> grd=graph.get(garden);

        for(int nbrs:grd)
        {
            if(flower[nbrs]==type)
                return false;
        }

        return true;
    }


    static boolean findSol(int[] flower,List<List<Integer>> graph,int n)
    {


        for(int garden=0;garden<n;garden++)
        {
            List<Integer> grd=graph.get(garden);

            if(flower[garden]==-1) {
                for(int type=1;type<=4;type++)
                {

                    if(isSafe(type,flower,garden,graph) ) {

                        flower[garden]=type;
                        if(findSol(flower,graph,n)){
                            return true;
                        }
                        flower[garden]=-1;
                    }
                }
                return false;
            }
        }

        return true;
    }



}