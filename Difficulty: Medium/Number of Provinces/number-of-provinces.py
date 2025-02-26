#User function Template for python3

class Solution:
    def numProvinces(self, adj, n):
        # code here 
        visited = set()
        stack = []
        cycle = 0
        
        for i in range(n):
            if i not in visited:
                cycle = cycle +1
                stack.append(i)
                while stack:
                    node = stack.pop()
                    if node not in visited:
                        #cycle = cycle+1
                        visited.add(node)
                        for idx in range(n):
                            if adj[node][idx] and idx not in visited:
                                stack.append(idx)
        
        return cycle
                        
                        
                        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        V=int(input())
        adj=[]
        
        for i in range(V):
            temp = list(map(int,input().split()))
            adj.append(temp);
        
        ob = Solution()
        print(ob.numProvinces(adj,V))
        print("~")
# } Driver Code Ends