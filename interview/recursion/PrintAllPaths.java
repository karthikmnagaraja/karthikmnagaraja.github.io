package interview.recursion;

import java.util.*;

public class PrintAllPaths{

	public List<List<Integer>> printAllPaths(TreeNode root) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        
        pathHelper(root,new ArrayList<Integer>(),result);
        return result;
    }
    
     public void pathHelper(TreeNode node,List<Integer> list,List<List<Integer>> result){
        if(node==null) return;
        list.add(node.val);
        if(node.left==null&&node.right==null){
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }else{
            pathHelper(node.left,list,result);
            pathHelper(node.right,list,result);
            
        }
        list.remove(list.size()-1);
        
        
    }
}