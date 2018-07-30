package interview.tree;



public class TreeTraversals{
//1a. Post Order Iterative traversal
public List<Integer> postorderTraversal(TreeNode root) {
	List<Integer> list= new LinkedList<Integer>();
	if(root==null) return list;

	Stack<TreeNode> stack= new  Stack<TreeNode>();
	stack.push(root);
	while(!stack.isEmpty()){
		 TreeNode node=stack.pop();
		 list.addFirst(node.value);
		 if(node.left!=null) stack.push(node.left);
		 if(node.right!=null) stack.push(node.right);
	}

	return list;
}
//1b.Post Order Traversal Recursive
public List<Integer> postorderRecursiveTraversal(TreeNode root) {
	List<Integer> list= new ArrayList<Integer>();
	postOrderHelper(root,list);
	return list;
}

public void postOrderHelper(TreeNode node,List<Integer> list){
	if(node==null) return;
	postOrderHelper(node.left,list);
	postOrderHelper(node.right,list);
	list.add(node.value);
}

//2a.Pre Order Traversal Iterative
public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> list= new ArrayList<Integer>();
	if(root==null) return list;

	Stack<TreeNode> stack= new  Stack<TreeNode>();
	stack.push(root);
	while(!stack.isEmpty()){
		 TreeNode node=stack.pop();
		 list.add(node.value);
		 if(node.left!=null) stack.push(node.left);
		 if(node.right!=null) stack.push(node.right);
	}

	return list;
}
2b.Pre Order Traversal Recursive
public List<Integer> preorderRecursiveTraversal(TreeNode root) {
	List<Integer> list= new ArrayList<Integer>();
	preOrderHelper(root,list);
	return list;
}

public void preOrderHelper(TreeNode node,List<Integer> list){
	if(node==null) return;
	list.add(node.value);
	preOrderHelper(node.left,list);
	preOrderHelper(node.right,list);
	
}
//3a.In Order Traversal  Iterative using stack
public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> list= new ArrayList<Integer>();
	if(root==null) return list;

	Stack<TreeNode> stack= new  Stack<TreeNode>();
	
	while(root!=null||!stack.isEmpty()){
			while(root!=null){
				stach.push(root.left);
				root=root.left
			}
		  root=stack.pop();
		 list.add(node.val);
		 root=root.right;
	}

	return list;
}
//3b. In Order Traversal Recursive
public List<Integer> inOrderRecursiveTraversal(TreeNode root) {
	List<Integer> list= new ArrayList<Integer>();
	inOrderHelper(root,list);
	return list;
}

public void preOrderHelper(TreeNode node,List<Integer> list){
	if(node==null) return;
	
	inOrderHelper(node.left,list);
	list.add(node.val);
	inOrderHelper(node.right,list);
	
}
//4a. Level Order or Bfs
public List<List<Integer> levelOrderTraversal(TreeNode root){
	List<List<Integer>> list=new ArrayList<List<Integer>>();
	if(root==null) return list;
	Queue<TreeNode> queue= new LinkedList<TreeNode>();

	queue.offer(root);

	while(!queue.isEmpty()){
		int size=queue.size();
		ArrayList<Integer> level= new ArrayList<Integer>();
		for(int i=0;i<size;i++){
			TreeNode node= queue.poll();
			level.add(node.val);
			if(node.left!=null) queue.offer(node.left);
			if(node.right!=null) queue.offer(node.right);
		}
		list.add(level);
	}
	return list;
}
}
