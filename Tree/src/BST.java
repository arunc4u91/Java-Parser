
public class BST {
	public static Node root;
	public BST(){
		this.root = null;
	}
	public boolean find(int id){
		Node current = root;
		while(current != null){
			if (current.data == id)
				return true;
			else if (current.data>id)
				current = current.left;
			else
				current = current.right;
			}
		return false;
	}
	
	public void insert(int id){
		Node newNode = new Node(id);
		if(root == null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			}
			else {
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public void display (Node root){
		if (root!=null){
			display(root.left);
			System.out.print(" "+root.data);
			display(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST b = new BST();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);
		b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
	}

}

class Node {
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
