#User function Template for python3

class Solution:
    def isPrime(self, n):
        for i in range(2,int(n**0.5)+1):
            if(n%i==0):
                return False
        return True