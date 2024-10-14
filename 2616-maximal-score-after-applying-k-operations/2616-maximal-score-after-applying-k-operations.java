class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(  Collections.reverseOrder() );
        for (int x:nums) {
            pq.add(x);
        }

        System.out.println(pq); 

        while (k-->0 ) {
            int x=pq.poll();
            ans=ans+x;
            x=(int)Math.ceil ( (double)x/3 );
            pq.add(x);
        }
        return ans;
    }
}