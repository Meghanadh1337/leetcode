/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        ArrayList<Integer> levelSum=new ArrayList<Integer>();
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();

        if(root==null)
            return null;
        
        q.add(root);

        while(q.size()!=0){

            int n=q.size();
            int sum=0;
            while(n-->0){

                TreeNode x=q.poll();
      
                sum=sum+x.val;

                if(x.left!=null)
                    q.add(x.left);
                
                if(x.right!=null)
                    q.add(x.right);
            }
            levelSum.add(sum);
        }

        q.add(root);
        int i=1;
        root.val=0;

        while(q.size()!=0){

            int n=q.size();

            while(n-->0){
                TreeNode x=q.poll();
 
                int leftVal= (x.left==null)?0:x.left.val;
                int rightVal= (x.right==null)?0:x.right.val;

                if(x.left!=null)
                {    x.left.val=levelSum.get(i)-(leftVal+rightVal);
                    q.add(x.left);
                }

                if(x.right!=null){
                    x.right.val=levelSum.get(i)-(leftVal+rightVal);
                    q.add(x.right);
                }


            }
            i++;
        }

        return root;

    }
}