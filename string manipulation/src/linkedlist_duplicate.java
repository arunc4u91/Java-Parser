
public class linkedlist_duplicate {
	Node head;
	
	public linkedlist_duplicate() {
		// TODO Auto-generated constructor stub
		head = new Node();
		
	}
	public void add(int d){
		Node end = new Node(d);
		Node n = head;
		while (n.next!=null){
			n = n.next;
		}
		n.next = end;
	}
	public void display() {
		Node n = head.next;
		while (n!=null){
			System.out.println(n.data);
			n = n.next;
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedlist_duplicate a = new linkedlist_duplicate();
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(5);
		a.add(6);
		a.add(8);
		a.add(7);
		a.display();
		System.out.println("-------");
		a.check();
		a.display();

	}
	public void check() {
		// TODO Auto-generated method stub
		int[] hash = new int[10];
		Node n = head.next;
		Node prev = head;
		while (n!=null){
			
			if(hash[n.data]>0){
				
				prev.next = n.next;
				
				n = n.next;
			}
			else{
				hash[n.data]++;
				prev = n;
				n = n.next;
				
			}
			
		}
		
	}

}

 class Node { 

    int data;
    Node next;
    public Node() {
    	this.next = null;
    }
    public Node(int item) { 

       data = item;

    }

}