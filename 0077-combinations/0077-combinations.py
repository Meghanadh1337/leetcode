class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        sol=[]
        ans=[]
        self.get_combinations(n+1,k,1,ans,sol)
        return sol
        

    def get_combinations(self,n,k,idx,ans,sol):
        if(idx>n):
            return
        elif(k==0):
            b=[]
            for i in range(len(ans)):
                b.append(ans[i])
            sol.append( b)
        else:
            ans.append(idx)
            self.get_combinations(n,k-1,idx+1,ans,sol)
            ans.remove(idx)
            self.get_combinations(n,k,idx+1,ans,sol)