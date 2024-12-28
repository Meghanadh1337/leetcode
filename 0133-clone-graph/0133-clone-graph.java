/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
            
        Map<Node,Node> hm=new HashMap<>();
        return clone(node,hm);
    }

    static Node clone(Node node,Map<Node,Node> hm) {
        if(hm.containsKey(node) )
            return hm.get(node);
        
        Node x = new Node();
        x.val = node.val;
        hm.put(node,x);
        List<Node> xNb = new ArrayList<Node>();
        
        for(Node n:node.neighbors) {
             xNb.add( clone(n,hm) );
        }

        x.neighbors=xNb;
        
        return x;
    }
}