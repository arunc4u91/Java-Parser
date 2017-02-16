
public class BST1 {
	private static TreeNode root;
	
	public BST1() {
		this.root = null;
	}
	public boolean find(int data){
		TreeNode current = root;
		while(current!=null){
			if(current.data == data)
				return true;
			else if(current.data<data)
				current = current.right;
			else
				current = current.left;
			
		}
		return false;
	}
	public void insert(int data){
		TreeNode newnode = new TreeNode(data);
		if(root==null){
			root = newnode;
			return;
		}
		TreeNode current = root;
		TreeNode parent = null;
		while(true){
			parent = current;
			if(data<current.data){
				current = current.left;
				if(current==null)
				{
					parent.left = newnode;
					return;
				}
			}
			else{
				current = current.right;
				if(current == null)
				{
					parent.right = newnode;
					return;
				}
			}
			
		}
	}
	public void inorder(TreeNode root){
		if(root != null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST1 obj = new BST1();
		obj.insert(5);
		obj.insert(1);
		obj.insert(7);
		obj.inorder(obj.root);
		System.out.println(obj.find(90));
	}

}
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data = data;
	}
}