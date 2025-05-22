#User function Template for python3

class Solution:
    
    def armstrongNumber (self, n):
        ans=0
        copy=n
        while n>=1:
           x=n%10
           ans=ans+(x**3)
           n=n//10
        return (ans==copy)
    
           