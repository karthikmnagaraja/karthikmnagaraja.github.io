package interview.tree;
/**
Path sum mean= sum of value of nodes from root to leaf nodes


**/
public class HasPathSum2{

public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        
        pathHelper(root,new ArrayList<Integer>(),result,sum);
        return result;
    }
    public void pathHelper(TreeNode node,List<Integer> list,List<List<Integer>> result,int sum){
        if(node==null) return;
        list.add(node.val);
        if(node.left==null&&node.right==null&&sum==node.val){
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }else{
            pathHelper(node.left,list,result,sum-node.val);
            pathHelper(node.right,list,result,sum-node.val);
            
        }
        list.remove(list.size()-1);
        
        
    }
  }