class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<ArrayList<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++) {
            g.add(new ArrayList<>() );
        }

        for(int[] a:prerequisites) {
            g.get(a[0]).add(a[1]);
        }

        System.out.println(g);
        boolean[] vis= new boolean[n];
        boolean[] pathVis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]) {
                if( dfsCheck(i,g,vis,pathVis) )
                    return !true;
            }
        }
        return !false;
    }

    static boolean dfsCheck(int node,List<ArrayList<Integer>> g,boolean[] vis,boolean[] pathVis) {

        if(pathVis[node]==true)
            return true;
        
        if(vis[node]==true)
            return false;

        pathVis[node] = true;
        

        for(Integer nbr:g.get(node) ){
                    if(dfsCheck(nbr,g,vis,pathVis))
                        return true;
        }

        pathVis[node]=false;
        vis[node]=true;

        return false;
    }

}