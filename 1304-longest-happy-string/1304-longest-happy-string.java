 public class Pair{
        int count;
        char c;
        Pair(char c,int count) {
            this.c=c;
            this.count=count;
        }
}

class Solution {
    
    public String longestDiverseString(int a, int b, int c) {
        Comparator<Pair> cmp=(x,y) -> Integer.compare(y.count,x.count);

        PriorityQueue<Pair> maxheap=new PriorityQueue<>( cmp );

        if(a>0){
            maxheap.add( new Pair('a',a) );
        } 
        if(b>0){
             maxheap.add( new Pair('b',b) );
        }
         if(c>0){
            maxheap.add( new Pair('c',c) );
        }

        int[] count=new int[3];
        StringBuilder ans=new StringBuilder();
        while ( maxheap.size()!= 0) {
            Pair cand=maxheap.poll();
            int n=ans.length();
            if( n>=2 &&
                ans.charAt(n-1)==ans.charAt(n-2) &&
                ans.charAt(n-2)==cand.c ) {
                    if(maxheap.size()==0)
                        break;
                    
                    Pair nextCand=maxheap.poll();
                    ans.append(nextCand.c);
                    if(nextCand.count>1)
                        maxheap.add( new Pair(nextCand.c,nextCand.count-1) );
                    maxheap.add( new Pair(cand.c,cand.count) );
                }
            else {
                ans.append(cand.c);
                if( cand.count > 1)
                    maxheap.add( new Pair(cand.c,cand.count-1) );
            }
        }
        return ans.toString();
    }
}

