
public class kthelement {
	Node head;
	public kthelement() {
		// TODO Auto-generated constructor stub
		head = new Node();
	}
	public void add(int x){
		Node end = new Node(x);
		Node temp= head;
		while(temp.next!=null)
			temp = temp.next;
		temp.next = end;
		
	}
	public void display() {
		Node temp = head.next;
		while(temp!=null)
		{
			System.out.print(temp.data);
			temp = temp.next;
		}
		
	}
	
	public void kth(int x){
		Node temp = head;
		int counter = 0;
		while(counter <x){
			temp = temp.next;
			counter++;
		}
		Node kth = head;
		while(temp!=null){
			temp = temp.next;
			kth = kth.next;
		}
		System.out.println(kth.data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kthelement obj = new kthelement();
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.add(6);
		obj.add(7);
		obj.add(8);
		obj.display();
		obj.kth(4);
	}

}

class Node {
	public int data;
	public Node next;
	public Node() {
		this.next = null;
	}
	public Node(int x){
		this.data = x;
		this.next = null;
	}
}
