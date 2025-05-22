#User function Template for python3

class Solution:
    def evenlyDivides(self, n):
        a=n
        ans=0
        while n>=1:
            x=n%10
            if(x!=0 and a%x==0):
                ans=ans+1
            n=n//10
        return ans
            